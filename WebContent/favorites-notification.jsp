<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Remove Favorite</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="moviecr">Movie Cruiser</span> <img
		id="img1" src="./images/logo.png" /> <a href="ShowFavourite"
		id="linfav">Favorites</a> <a href="ShowMovieListCustomer"
		id="linkmovie">Movies</a> </header>
<body>
	<div>
		<h1>Favorites</h1>
		<p class="para3">
		<h4>${ remove}</h4>

		</p>
		<table>
			<tr>
				<th id="space">Title</th>
				<th id="txtleft">Box Office</th>
				<th id="txtcenter">Genre</th>
				<th id="txtcenter"></th>
			</tr>
			<h4>${ remove}</h4>
			<c:forEach items="${ movieListCustomer}" var="mov">
				<tr>
					<td id="space">${mov.title}}</td>
					<td id="txtleft">${mov.boxOffice}</td>
					<td id="txtcenter">${mov.genre}</td>
					<td id="txtcenter"><a href="RemoveFavourite?movieId=${mov.id}"
						id="linkedit">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<b>No. of Favorites:2</b>
		</p>

	</div>
</body>
<footer>
<h3>Copyright &copy 2019</h3>
</footer>
</body>
</html>
