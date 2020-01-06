<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Customer</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="moviecr">Movie Cruiser</span> <img
		id="img1" src="./images/logo.png" /> <a href="favorites.html"
		id="linfav">Favorites</a> <a href="movie-list-customer.html"
		id="linkmovie">Movies</a> </header>
<body>
	<div>
		<h1>Movies</h1>
		<p class="para1">
			<b>Movie added to Favorites successfully</b>
		</p>

		<table>
			<tr>
				<th id="space">Title</th>
				<th id="txtleft">Box Office</th>
				<th id="txtcenter">Genre</th>
				<th id="txtcenter">Has Teaser</th>
				<th id="txtcenter">Action</th>
			</tr>
			<tr>
				<td id="space">${movie.title }</td>
				<td id="txtleft">${movie.boxOffice }</td>
				<td id="txtcenter">${movie.genre }</td>
				<td id="txtcenter">${movie.hasTeaser }</td>
				<td id="txtcenter"><a
					href="movie-list-customer-notification.html" id="linkedit">Add
						to Favorite</a></td>
			</tr>
		</table>
	</div>
</body>
<footer>
<h3>Copyright &copy 2019</h3>
</footer>
</body>
</html>
