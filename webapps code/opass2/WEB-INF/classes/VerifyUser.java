   import java.io.*;
   import java.sql.*;
   import javax.servlet.*;
   import javax.servlet.http.*;
   public class VerifyUser extends HttpServlet {
    String uname="";
    String url="";
    Connection con=null;
    Statement st=null;
     Statement st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        uname = req.getParameter("uname");
        url = req.getParameter("url");


                try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/opass","root","password");
            st = con.createStatement();
           rs= st.executeQuery("select * from userdetails where username='"+uname+"' and url='"+url+"'");
            if(rs.next())
            {
             String un=rs.getString(1);
			 String uid= rs.getString(2);

			 String url=rs.getString(3);
             String longpassword= rs.getString(4);
             String phoneno=rs.getString(5);

              String query1 = " insert into logindetails(username,uid,url,longtermpassword,phoneno) values('"+un+"','"+uid+"','"+url+"','"+longpassword+"','"+phoneno+"')";
              st1 = con.createStatement();
              st1.executeUpdate(query1);

                rd=req.getRequestDispatcher("/VerifyLTP.jsp");
            }
            else {
	            rd=req.getRequestDispatcher("/Failure.jsp");
	           // out.println("welcome");
	        }
	        st1.close();
	        con.close();
	        rd.forward(req,res);
        } catch(Exception e2) {
            System.out.println(e2);
            //  out.println(e2);
        }
    }
}