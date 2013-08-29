<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<style type="text/css">
#form1 table tr th {
	text-align: center;
}
body {
	background-color: #1A5555;
}
.style1 {
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 36;
	color: #FFFFFF;
}
.style2 {font-size: 36px;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	color: #FFFFFF;
}
</style>
</head>

<body>
<p align="center">&nbsp;</p>
<p align="center"><span class="style2">OPass - Login</span></p>
<p>&nbsp;</p>
<table width="597" height="184" border="0" align="center" cellpadding="5" cellspacing="5">
  <tr>
    <th scope="col"><form id="form1" name="form1" method="post" action="verifyOTP">
      <p>
        <input name="uname" type="text" id="uname" value="<%=request.getParameter("uname")%>" />
        <input name="url" type="text" id="url" value="<%=request.getParameter("url")%>" />
      </p>
      <table width="545" height="85" border="0" align="center" cellpadding="5" cellspacing="5">
        <tr>
          <th colspan="3" scope="col"><span class="style1">Enter Long Term Password from Your Android Device..</span></th>
          </tr>
        <tr>
          <th width="198" scope="row"><div align="right">One Time Password
            </div></th>
          <th width="169" scope="row"><input name="otpassword" type="text" id="otpassword" /></th>
          <th width="128" scope="row"><div align="left">
		  
            <input type="submit" name="Submit" value="Submit" />
          </div></th>
        </tr>
      </table>
    </form></th>
  </tr>
</table>
</body>
</html>