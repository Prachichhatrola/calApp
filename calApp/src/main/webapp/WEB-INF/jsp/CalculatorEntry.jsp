<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div align="center">
    <form method="post" action="/calculate">
      <h2>
        Enter 1st operand:<input type="text" name="operand1"/>
        <br/><br/>
        Enter 2nd operand:<input type="text" name="operand2"/>
        <br/><br/>
        Enter Math Operator:<input type="text" name="operator"/>
        <br/><br/>
        <button type="submit">Submit</button>
      </h2>
    </form>
  </div>
</body>
</html>
