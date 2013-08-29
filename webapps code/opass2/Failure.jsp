<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<style type="text/css">
a:link {
	text-decoration: none;
	color: #999999;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
	color: #090;
}
a:active {
	text-decoration: none;
}
body {
	background-color: #1A5555;
}
.style1 {
	color: #FF0000;
	font-size: 36;
}
.style2 {font-size: 36px;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	color: #FFFFFF;
}
.style3 {color: #FF0000; font-size: 16px; }
.style4 {color: #FFFFFF}
</style>
</head>

<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center"><span class="style2">OPass - Login</span></p>
<table width="597" height="184" border="0" align="center" cellpadding="5" cellspacing="5">
  <tr>
    <th scope="col"><form id="form1" name="form1" method="post" action="index.jsp">
      <table width="383" height="85" border="0" align="center" cellpadding="5" cellspacing="5">
        <tr>
          <th width="259" scope="col"><p class="style1">Login Failure.... </p>
            <p class="style3">(Invalid Username/URL/OTP) </p></th>
          <th width="89" scope="col"><a href="GetUsername.jsp" target="_self" class="style4">Try Again</a></th>
          </tr>
        <tr>
          <th colspan="2" scope="row">&nbsp;</th>
          </tr>
      </table>
    </form></th>
  </tr>
</table>
</body>
</html>