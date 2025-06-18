<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Actor Data</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<c:choose>
		<c:when test="${!empty actorList}">
			<h1 style="color: #640D5F; text-align: center"><b><i>Actors Report Details</i></b></h1>
			
			<hr>
			<h2 style="color: #F38C79; text-align: center">
				<b><i>${resultMsg}</i></b>
			</h2>

			<table border="2" align="center" bgcolor="#EAEAEA" width="55%" height="40%">
				<tr>
					<th>aid</th>
					<th>aname</th>
					<th>addrs</th>
					<th>category</th>
					<th>fees</th>
					<th>operations</th>
				</tr>

				<c:forEach var="act" items="${actorList}">
					<tr style="color: #2D336B">
						<td><b>${act.aid}</b></td>
						<td><b>${act.aname}</b></td>
						<td><b>${act.addrs}</b></td>
						<td><b>${act.category}</b></td>
						<td><b>${act.fees}</b></td>

						<td><a href="act_edit?id=${act.aid}"><img
								src="images/edit2.jpg" width="50px" height="45px"></a>
								
								 <a href="act_delete?id=${act.aid}"><img src="images/delete3.jpg" width="50px" height="45px"></a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
		</c:when>

		<c:otherwise>
			<h1 style="color: #7D0A0A; text-align: center">
				<b><i></i></b>
			</h1>
		</c:otherwise>
	</c:choose>

	<center>
		<b><i><a href="actor_add"><img src="images/add5.jpg" width="80px"height="80px">Add Actors</a></b></i>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<b><i><a href="./"><img src="images/home4.jpg" width="80px" height="80px">Home</a></i></b>
	</center>

</body>
</html>