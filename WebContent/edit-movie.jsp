<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Edit Movie</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
<script src="./js/script.js" type="text/Javascript"></script>
</head>
<body>
	<header> <span id="moviecr">Movie Cruiser</span> <img
		id="img1" src="./images/logo.png" /> <a href="ShowMenuItemListAdmin"
		id="linkmovie">Movies</a> </header>
<body>
	<div>
		<form name="form1" action="EditMovie?movieId=${movieItem.id}"
			onsubmit="return validate()" method="post">
			<table>
				<h1>Edit Movie</h1>
				<tr>
					<td><h4>Title</h4></td>
				</tr>

				<tr>
					<td colspan="4""><input type="text" name="title" size="80px"
						value="${movieItem.title}" /></td>
				</tr>

				<tr>
					<td><h4>Gross ($)</h4></td>
					<td><h4>Active</h4></td>
					<td><h4>Date of Launch</h4></td>
					<td><h4>Genre</h4></td>
				</tr>

				<tr>
					<td><input type="text" name="boxOffice"
						value="${movieItem.boxOffice }" />
					<td><label><input type="radio" name="active"
							value="${movieItem.active?'Yes':'No'}"
							<c:if test="${movieItem.active eq 'Yes'}">checked</c:if> />Yes</label> <label><input
							type="radio" name="active" value="${movieItem.active?'Yes':'No'}"
							<c:if test="${movieItem.active eq 'No'}"></c:if> />No</label></td>

					<fmt:formatDate value="${movieItem.dateOfLaunch }"
						pattern="dd/MM/yyy" var="dol" />
					<td><input type="text" name="dateOfLaunch" value="${dol}" /></td>
					<td><select name="genre">
							<option
								<c:if test="${movieItem.genre eq 'Science Fiction'}">Selected</c:if>>Science
								Fiction</option>
							<option
								<c:if test="${movieItem.genre eq 'SuperHero'}">Selected</c:if>>SuperHero</option>
							<option
								<c:if test="${movieItem.genre eq 'Romance'}">Selected</c:if>>Romance</option>
							<option
								<c:if test="${movieItem.genre eq 'Comedy'}">Selected</c:if>>Comedy</option>
							<option
								<c:if test="${movieItem.genre eq 'Adventure'}">Selected</c:if>>Adventure</option>
							<option
								<c:if test="${movieItem.genre eq 'Thriller'}">Selected</c:if>>Thriller</option>

					</select></td>
				</tr>

				<tr></tr>
				<tr></tr>
				<tr></tr>

				<tr>
					<td><input type="checkbox" name="hasTeaser" id="chBox"
						value="true" <c:if test="${movieItem.hasTeaser}"></c:if> checked /><b>
							Has Teaser</b></td>
				</tr>

				<tr></tr>
				<tr></tr>
				<tr></tr>

				<tr>
					<td><input type="Submit" value="Save" class="sub" /></td>
				</tr>

			</table>
		</form>
	</div>
</body>
<footer>
<h3>Copyright &copy 2019</h3>
</footer>
</body>
</html>
