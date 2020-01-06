<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Admin</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="moviecr">Movie Cruiser</span> <img
		id="img1" src="./images/logo.png" /> <a href="ShowMovieListAdmin"
		id="linkmovie">Movies</a> </header>
<body>
	<div>
		<table>
			<h1>Movies</h1>
			<tr>
				<th id="space">Title</th>
				<th id="txtleft">Box Office</th>
				<th id="txtcenter">Active</th>
				<th id="txtcenter">Date of Launch</th>
				<th id="txtcenter">Genre</th>
				<th id="txtcenter">Has Teaser</th>
				<th id="txtcenter">Action</th>
			</tr>
			<c:forEach items="${movieList}" var="movie">
				<tr>
					<td id="space">${movie.title }</td>
					<td id="txtleft">$.${movie.boxOffice }</td>
					<td id="txtcenter">${movie.active?'Yes':'No' }</td>
					<td id="txtcenter">${movie.dateOfLaunch }</td>
					<td id="txtcenter">${movie.genre }</td>
					<td id="txtcenter">${movie.hasTeaser?'Yes':'No' }</td>
					<td id="txtcenter"><a href="ShowEditMovie?movieId=${movie.id}"
						id="linkedit">Edit</a></td>
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
