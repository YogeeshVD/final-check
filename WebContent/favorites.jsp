<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Favorites</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="moviecr">Movie Cruiser</span> <img
		id="img1" src="./images/logo.png" /> <a href="ShowFavourite"
		id="linfav">Favorites</a> <a href="ShowMovieListCustomer"
		id="linkmovie">Movies</a> </header>

	<div>
		<h1>Favorites</h1>
		<table>
			<tr>
				<th id="space">Title</th>
				<th id="txtleft">Box Office</th>
				<th id="txtcenter">Genre</th>
				<th id="txtcenter"></th>
			</tr>
			<h3>${ remove}</h3>
			<c:forEach items="${movieListCustomer}" var="movie">
				<tr>
					<td id="space">${movie.title }</td>
					<td id="txtleft">${movie.boxOffice }</td>
					<td id="txtcenter">${movie.genre }</td>
					<td id="txtcenter"><a
						href="RemoveFavourite?movieId=${movie.id}" id="linkedit">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<b>No. of Favorites:</b>${count}</p>
	</div>
</body>
<footer>
<h3>Copyright &copy 2019</h3>
</footer>
</body>
</html>