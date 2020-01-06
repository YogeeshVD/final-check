<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Movie List Customer</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span id="moviecr">Movie Cruiser</span> <img
		id="img1" src="./images/logo.png" /> <a href="ShowFavourite"
		id="linfav">Favorites</a> <a href="ShowMovieListCustomer"
		id="linkmovie">Movies</a> </header>
<body>
	<div>
		<table>
			<h1>Movies</h1>
			<tr>
				<th id="space">Title</th>
				<th id="txtleft">Box Office</th>
				<th id="txtcenter">Genre</th>
				<th id="txtcenter">Has Teaser</th>
				<th id="txtcenter">Action</th>
			</tr>
			<p>
			<h4 class="saved1">${addfav}<h4>
					<h4>${remove }</h4>



					<c:forEach items="${movieList}" var="movie">
						<tr>
							<td id="space">${movie.title}</td>
							<td id="txtleft">${movie.boxOffice}</td>
							<td id="txtcenter">${movie.genre }</td>
							<td id="txtcenter">${movie.hasTeaser?'Yes':'No' }</td>
							<td id="txtcenter"><a
								href="AddToFavourite?movieId=${movie.id}" id="linkedit">Add
									to Favorite</a></td>
						</tr>
					</c:forEach>
		</table>
	</div>
</body>
<footer>
<h3>Copyright &copy 2019</h3>
</footer>
</body>
</html>
