<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Actor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<h1 style="color: #066cae; text-align: center">
		<b><i> Update the Actor Details </i></b>
	</h1>
	<hr>

	<frm:form modelAttribute="act">
		<table border="2" align="center" bgcolor="#D3E671" width="30%"
			height="25%">
			<tr>
				<td><b>Actor Id</b></td>
				<td><frm:input path="aid" readonly="true" /></td>
			</tr>

			<tr>
				<td><b>Actor Name::</b></td>
				<td><frm:input path="aname" /></td>
			</tr>

			<tr>
				<td><b>Actor Address::</b></td>
				<td><frm:input path="addrs" readonly="true" /></td>
			</tr>

			<tr>
				<td><b>Actor Category::</b></td>
				<td><frm:input path="category" readonly="true" /></td>
			</tr>


			<tr>
				<td><b>Actor fees::</b></td>
				<td><frm:input path="fees" readonly="true" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update Actor"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>

		<br>

		<div align="middle">
			<a href="report" class="btn btn-primary">Go To Actor Report</a>
		</div>
	</frm:form>
</body>
</html>