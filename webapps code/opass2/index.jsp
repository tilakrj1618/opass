<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Documen</title>
<style type="text/css">
<!--
body {
	background-color: #1A5555;
}
.style1 {	font-size: 36px;
	font-weight: bold;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	color: #FFFFFF;
}
.style2 {
	color: #FFFFFF;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}
-->
</style>
<script type="text/javascript">
function check()
{
if (document.getElementById('url').value=="")
{
alert("Enter URL...");
document.form1.url.focus();
return false;
//document.getElementById('in').getAttributeNode('class').value="correct";
}
return true
}
</script>




</head>

<body>
<p>&nbsp;</p>
<p align="center"><span class="style1">OPass - Login</span></p>
<table width="597" height="184" border="0" align="center" cellpadding="5" cellspacing="5">
  <tr>
    <th scope="col"><form id="form1" name="form1" method="post" action="VerifyUser"  onsubmit="return check();">
      <table width="582" height="85" border="0" cellpadding="5" cellspacing="5">
        <tr>
          <th scope="col"><span class="style2">User Name </span>
            <input name="uname" type="text" id="uname" value="<%=request.getParameter("username")%>" /></th>
        </tr>
        <tr>
          <th scope="col"><input name="url" type="text" id="url" size="100" /></th>
          </tr>
        <tr>
          <th scope="row"><input type="submit" name="button" id="button" value="    Go    " /></th>
          </tr>
      </table>
    </form></th>
  </tr>
</table>
</body>
</html>