<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="container">
	<div class="jumbotron">
		<h1>XXXXWEB</h1>
		<p>Descripcion / Eslogan de la app</p>
		<div sec:authorize="isAuthenticated()" style="text-align: right">

			<sec:authorize access="hasRole('ADMIN')">

				<a href="logout.html" class="btn btn-primary">Logout</a>

			</sec:authorize>





		</div>

	</div>
</div>
</html>