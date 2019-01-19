<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form name="bmiForm" action="bmi" method="post">
    <table>
      <tr>
        <td>体重(kg)</td>
        <td><input type="text" name="weight" /></td>
      </tr>
      <tr>
        <td>身高(m)</td>
        <td><input type="text" name="height" /></td>
      </tr>
      <th><input type="submit" value="提交" name="find"/> </th>
      <th><input type="reset" value="重置" name="reset"/> </th>
    </table>
      <h1>${bmi}</h1>
      <h2>${result}</h2>
  </form>

  </body>
</html>