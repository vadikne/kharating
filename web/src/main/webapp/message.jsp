<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload Result</title>
    
</head>
<body>

    <center>
  <h2>${message}</h2>
</center>
<div align="center">
  <table width="80%" border="0">
    <tr valign="middle">
      <td width="50%" align="center">
      <input value="скачать свежий рейтинг" onclick="location.href='ind.html'" type="button" />
    </td>
      <td width="50%" align="center">
      <input type="button" onclick="history.back();" value="загрузить еще один .xml"/>
      </td>
    </tr>
  </table>
</div>




</body>
</html>