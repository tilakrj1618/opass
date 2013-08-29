import java.io.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
class SMSTest extends SMSUtil
{
     int msgIndex =1;
     public String phoneNo;
     public String ran;
	SMSTest() throws Exception{

		super("COM1");
	}
  	public void processSMS(String str,String ran1) throws Exception
	{
		phoneNo = str.substring(str.indexOf("REC UNREAD\",\"")+13, str.indexOf("REC UNREAD\",\"")+26);
		String mes = str.substring(str.indexOf(phoneNo)+40, str.lastIndexOf("OK")).trim();
		System.out.println("PNO = " + phoneNo);
		System.out.println("MES = " + mes);

		StringTokenizer st = new StringTokenizer(mes,"-");
        String format=st.nextToken();
		Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "opass";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String Password = "password";
			Statement stmt;

           if(format.equals("A"))
           {
               	String usern=st.nextToken();
        String uid=st.nextToken();
        String url1=st.nextToken();
        String ran=ran1;
        System.out.println("Registration Request Received.."+format+usern+uid+url1);
        	try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,Password);
				System.out.println("Connected to the database");

				ArrayList al=null;
				ArrayList userList =new ArrayList();

               	String query = "insert into userdetails set username='"+usern+"',uid='"+uid+"',url='"+url1+"',longpassword='"+ran+"',phoneno='"+phoneNo+"',flag='0'";
				stmt = conn.createStatement();

			    int i = stmt.executeUpdate(query);
				System.out.println("query" + query);
                 System.out.println("OPass Registration in Progress..");
               sendSMS(phoneNo,ran);
               deleteSMS("AT+CMGD=1\r");
               System.out.println("OPass Registration Successful..\rLong Term Password has been sent successfully!");
               }
				 catch (Exception e)

            {
			e.printStackTrace();
			}

			}

			else if(format.equals("B"))
			{
				try {
				 System.out.println("Login Request Received..");
                Class.forName(driver).newInstance();

				conn = DriverManager.getConnection(url+dbName,userName,Password);
				System.out.println("Connected to the database");
                    ResultSet rs,rs2;
                    Statement st1,st2;
                    st1 = conn.createStatement();
                    st2 = conn.createStatement();
			     	String usern=st.nextToken();


                      rs= st1.executeQuery("select * from userdetails where longpassword='"+usern+"' and phoneno='"+phoneNo+"'");
            if(rs.next())
            {
             String dCase = "abcdefghijklmnopqrstuvwxyz";
            String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
           String sChar = "!@#$%^&*";
           String intChar = "0123456789";
            Random r = new Random();
            System.out.println("OTP generation processing...");
            String pass = "";
		    while (pass.length () != 6){
            int rPick = r.nextInt(4);
            if (rPick == 0){
                int spot = r.nextInt(26);
                pass += dCase.charAt(spot);
            } else if (rPick == 1) {
                int spot = r.nextInt (26);
                pass += uCase.charAt(spot);
            } else if (rPick == 2) {
                int spot = r.nextInt (9);
                pass += sChar.charAt(spot);
            } else if (rPick == 3){
                int spot = r.nextInt (10);
                pass += intChar.charAt (spot);
            }
        }

           String otpass=GenerateMD5.MD5(pass);
           String ot=otpass.substring(1,8);

           String newpass="One Time Password is : "+ot;
           System.out.println(newpass);
           sendSMS(phoneNo,newpass);


           String query2 = "update logindetails set otp='"+ot+"' where longtermpassword='"+usern+"' and phoneno='"+phoneNo+"'";
			   int j = st2.executeUpdate(query2);


         }



         }
         		 catch (Exception e)

            {
			e.printStackTrace();
			}


     	if(mes.startsWith("A-")) {
		StringTokenizer st1 = new StringTokenizer(mes,"-");
		System.out.println(st1.nextToken());
		String type = st1.nextToken();

		System.out.println(type.trim());
		}else

        {
        System.out.println("Invalid Request... \r Login or Registration Unauthorized..");
        deleteSMS("AT+CMGD=1\r");
		}
	}     }
	public static void main(String[] args) throws Exception{
			SMSUtil util=new SMSTest();
			ArrayList al=new ArrayList();
			util.startReceive(al,5000);
            Thread.sleep(2000);
          }
        }