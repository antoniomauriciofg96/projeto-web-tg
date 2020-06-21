<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="UTF-8" />
<title>Login</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" th:href="@{/dashboard}">VRUM - WEB</a>
			</div>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">

			</div>
		</div>
	</nav>

	<div class="container">

		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1></h1>
					<p class="lead"></p>
				</div>

			</div>
		</div>

		<form th:action="@{/login}" method="POST" class="form-signin">
			<h3 class="form-signin-heading" th:text="Login"></h3>
			<br /> <input type="text" id="email" name="email"
				th:placeholder="E-mail" class="form-control" /> <br /> <input
				type="password" th:placeholder="Senha" id="password" name="password"
				class="form-control" /> <br />

			<div align="center" th:if="${param.error}">
				<p style="font-size: 20; color: #FF1C19;">E-mail e/ou Senha
					inválidos</p>
			</div>
			<button class="btn btn-lg btn-primary btn-block" name="Submit"
				value="Login" type="Submit" th:text="Login"></button>
		</form>
		<br />
		<form th:action="@{/registration}" method="get">
			<button class="btn btn-md btn-info btn-block" type="Submit">Registre-se</button>
		</form>
		<br/><br/>
	</div>

</body>
</html>