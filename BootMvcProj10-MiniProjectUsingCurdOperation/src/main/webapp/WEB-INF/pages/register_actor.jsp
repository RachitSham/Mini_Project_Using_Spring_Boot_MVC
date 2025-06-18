<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Actor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<h1 style="color: #EB5B00; text-align: center">
		<b><i>🌟 Register The Actor Information 🌟</i></b>
	</h1>
	<hr>

	<frm:form modelAttribute="act">
		<table border="2" align="center" bgcolor="#D3E671" width="30%"
			height="25%">

			<tr>
				<td><b> Actor Name::</b></td>
				<td><frm:input path="aname" /></td>
			</tr>

			<tr>
				<td><b> Actor Address::</b></td>
				<td><frm:input path="addrs" /></td>
			</tr>

			<tr>
				<td><b> Actor Category::</b></td>
				<td><frm:input path="category" /></td>
			</tr>

			<tr>
				<td><b> Actor Fees::</b></td>
				<td><frm:input path="fees" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="submit"></td>
				<td><input type="reset" value="cancel"></td>
			</tr>

		</table>

		<br>

		<div align="middle">
			<a href="report" class="btn btn-primary">Go To Actor Report</a>
		</div>

	</frm:form>
</body>
</html>