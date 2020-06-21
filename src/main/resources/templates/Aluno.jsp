<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="UTF-8" />
<title>Alunos</title>
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
					<li class="nav-item"><a class="nav-link"
						th:href="@{/dashboard}">Home</a></li>
					<li class="nav-item"><a class="nav-link" th:href="@{/prova}">Avaliações</a></li>
					<li class="nav-item active"><a class="nav-link"
						th:href="@{/aluno}">Alunos</a></li>
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
					<h1>Alunos</h1>
					<p class="lead"></p>
				</div>

			</div>
		</div>

		<div class="panel panel-default">

			<div class="panel-heading">
				<strong></strong>
			</div>

			<div class="panel-body">

				<div class="table-responsive">

					<table
						class="table table-sm table-striped table-hover table-bordered">

						<thead>

							<tr>

								<th>ID</th>
								<th>Chave Identificadora do Aluno</th>
								<th>Nome do Aluno</th>
								<th></th>
								<th></th>
							</tr>

						</thead>

						<tbody>

							<tr th:each="aluno : ${alunos}">

								<td th:text="${aluno.id}"></td>
								<td th:text="${aluno.chaveAluno}"></td>

								<td th:text="${aluno.nomeAluno}"></td>
								<td><a class="btn btn-sm btn-primary"
									th:href="@{/aluno/edit/{id}(id=${aluno.id})}">Editar</a></td>
								<td><a class="delete btn btn-sm btn-danger"
									th:href="@{/aluno/delete/{id}(id=${aluno.id})}">Excluir</a></td>
							</tr>

						</tbody>

					</table>

				</div>

			</div>

			<div class="panel-footer">
				<a class="btn btn-sm btn-success" th:href="@{/aluno/add/}">Adicionar</a>
			</div>

		</div>
	</div>
</body>
</html>
