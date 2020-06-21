<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="UTF-8" />
<title>Associação Alunos/Avaliações</title>
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
					<li class="nav-item"><a class="nav-link"
						th:href="@{/aluno}">Alunos</a></li>
					<li class="nav-item active"><a class="nav-link"
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
					<h1>Associação Aluno/Avaliação</h1>
					<p class="lead"></p>
				</div>

			</div>
		</div>
		<div class="col-md-6">
			<form class="form-horizontal" th:object="${alunoProva}"
				th:action="@{/alunoprova/save}" method="POST">
				
				<fieldset>
					
					<div class="alert alert-danger" th:if="${#fields.hasAnyErrors()}">
						
						<div th:each="detailedError : ${#fields.detailedErrors()}">
							<span th:text="${detailedError.message}"></span> 
						</div>
						
					</div>
					<br/>
					<label for="id">Código</label> <input type="text"
						class="form-control input-sm" id="id" th:field="*{id}"
						readOnly="readonly" />  
					<br/>
					<select class="form-control"
						th:field="${alunoProva.aluno.id}" id="dropAluno">
						<option value="">Selecione um aluno</option>
						<option th:each="aluno : ${alunos}" th:value="${aluno.id}"
							th:text="${aluno.chaveAluno + ' - ' + aluno.nomeAluno}">
							</option>
					</select> 
					<br/>
					<select class="form-control" th:field="${alunoProva.prova.id}"
						id="dropProva">
						<option value="">Selecione um Avaliação</option>
						<option th:each="prova : ${provas}" th:value="${prova.id}"
							th:text="${prova.titulo}">
							</option>
					</select>  
					<br/>
					
					<input type="hidden" id="usuarioProfessor"
						th:field="*{usuarioProfessor}" />   
				</fieldset>
				<br/>
				<button type="submit" class="btn btn-sm btn-primary">Salvar</button>
				<a th:href="@{/alunoprova/}" class="btn btn-sm btn-default">Cancelar</a>
			</form>
			<br/><br/>
			
		</div>
		
	</div>
</body>
</html>