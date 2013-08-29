<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<style type="text/css">
<!--
.style1 {
	font-size: 36px;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	color: #FFFFFF;
}
.style2 {font-family: Verdana, Arial, Helvetica, sans-serif}
body {
	background-color: #1A5555;
}
-->
</style>
<script type="text/javascript">
function check()
{
if (document.getElementById('username').value=="")
{
alert("Enter Username...");
document.form1.username.focus();
return false;
//document.getElementById('in').getAttributeNode('class').value="correct";
}
return true
}
</script>
</head>

<body>
<p align="center" class="style1">&nbsp;</p>
<p align="center" class="style1">OPass - Login</p>
<p class="style2">&nbsp;</p>
<table width="597" height="184" border="0" align="center" cellpadding="5" cellspacing="5">
  <tr>
    <th scope="col"><form id="form1" name="form1" method="post" action="index.jsp" onsubmit="return check();">
      <table width="323" height="85" border="0" align="center" cellpadding="5" cellspacing="5">
        <tr>
          <th width="198" scope="col"><input name="username" type="text" id="username" value="Enter Username" size="30" /></th>
          <th width="90" scope="col"><input type="submit" name="button" id="button" value="    Go    " /></th>
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