<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="UTF-8" />
<title>Dashboard</title>
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
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						th:href="@{/dashboard}">Home</a></li>
					<li class="nav-item"><a class="nav-link" th:href="@{/prova}">Avaliações</a></li>
					<li class="nav-item"><a class="nav-link" th:href="@{/aluno}">Alunos</a></li>
					<li class="nav-item"><a class="nav-link"
						th:href="@{/alunoprova}">Alunos/Avaliações</a></li>
					<li class="nav-item"><a class="nav-link"
						th:href="@{/respostausuario}">Respostas de Alunos</a></li>
				</ul>

				<ul class="nav navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" th:href="@{/logout}"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="page-header" id="banner">
			<div class="row">
				<div class="col-lg-8 col-md-7 col-sm-6">
					<h1>VRUM - WEB</h1>
					<p class="lead">Sistema para gestão do professor</p>
				</div>

			</div>
		</div>

		<div class="panel panel-default">

			<div class="panel-heading">
				<strong>Dashboard</strong>
			</div>

			<div class="panel-body">
				<div class="card text-white bg-primary mb-3"
					style="max-width: 18rem;">
					<div class="card-header">Total de avaliações cadastradas</div>
					<div class="card-body">
						<p class="card-text">
							<h1 th:text="${totalProvas}"></h1>
						</p>
					</div>
				</div>

				<div class="card text-white bg-primary mb-3"
					style="max-width: 18rem;">
					<div class="card-header">Total de alunos cadastrados</div>
					<div class="card-body">
						<p class="card-text">
							<h1 th:text="${totalAlunos}"></h1>
						</p>
					</div>
				</div>

			</div>

			<div class="panel-footer"></div>

		</div>

	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
</body>
</html>