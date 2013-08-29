   import java.io.*;
   import java.sql.*;
   import javax.servlet.*;
   import javax.servlet.http.*;
   public class verifyOTP extends HttpServlet {
    String uname="";
    String url="",otp="";
    Connection con=null;
    Statement st=null;
     Statement st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        uname = req.getParameter("uname");
        url = req.getParameter("url");
        otp = req.getParameter("otpassword");
           System.out.println(uname+url+otp);


                try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/opass","root","password");
            st = con.createStatement();
           rs= st.executeQuery("select * from logindetails where username='"+uname+"' and url='"+url+"' and otp='"+otp+"'");
            if(rs.next())
            {
               // rd=req.getRequestDispatcher("/VerifyLTP.jsp");
               res.sendRedirect(res.encodeRedirectURL(url));
            }
            else {
	            rd=req.getRequestDispatcher("/Failure.jsp");
	           // out.println("welcome");
	        }
	        rd.forward(req,res);
        } catch(Exception e2) {
            System.out.println(e2);
            //  out.println(e2);
        }
    }
}