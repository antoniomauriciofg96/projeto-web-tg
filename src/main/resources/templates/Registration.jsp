<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="UTF-8" />
<title>Formulário de Registro</title>
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
					<h1>Formulário de Registro</h1>
					<p class="lead"></p>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form autocomplete="off" action="#" th:action="@{/registration}"
					th:object="${user}" method="post" class="form-horizontal"
					role="form">
					<div class="form-group">
						<div class="col-sm-9">
							<label th:if="${#fields.hasErrors('name')}" th:errors="*{name}"
								class="validation-message"></label> <input type="text"
								th:field="*{name}" placeholder="Nome" class="form-control" />
						</div>
					</div>
					<br/>

					<div class="form-group">
						<div class="col-sm-9">
							<label th:if="${#fields.hasErrors('lastName')}"
								th:errors="*{lastName}" class="validation-message"></label> <input
								type="text" th:field="*{lastName}" placeholder="Sobrenome"
								class="form-control" />
						</div>
					</div>
					<br/>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="text" th:field="*{email}" placeholder="E-mail"
								class="form-control" /> <label
								th:if="${#fields.hasErrors('email')}" th:errors="*{email}"
								class="validation-message"></label>
						</div>
					</div>
					<br/>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="password" th:field="*{password}" placeholder="Senha"
								class="form-control" /> <label
								th:if="${#fields.hasErrors('password')}" th:errors="*{password}"
								class="validation-message"></label>
						</div>
					</div>
					<br/>

					<div class="form-group">
						<div class="col-sm-9">
							<button type="submit" class="btn btn-primary btn-block">Registrar
								usuário</button>
						</div>
					</div>
					<br/>

					<span th:utext="${successMessage}"></span>


				</form>
			</div>
		</div>
		<br />
		<br />
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form th:action="@{/}" method="get" class="form-horizontal">
					<div class="form-group">
						<div class="col-sm-9">
							<button class="btn btn-md btn-info btn-block" type="Submit">Login</button>
						</div>
					</div>
				</form>
			</div>

		</div>
		<br/><br/>
	</div>

</body>
</html>