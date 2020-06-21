<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="UTF-8" />
<title>Cadastro de Avaliações</title>
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
					<li class="nav-item active"><a class="nav-link" th:href="@{/prova}">Avaliações</a></li>
					<li class="nav-item"><a class="nav-link"
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
					<h1>Cadastro de Avaliação</h1>
					<p class="lead"></p>
				</div>

			</div>
		</div>
		<div class="col-md-6">
			<form class="form-horizontal" th:object="${prova}"
				th:action="@{/prova/save}" method="POST">
				
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
					<div th:classappend="${#fields.hasErrors('titulo')}? 'has-error'">
						<label for="titulo">T&iacute;tulo</label> <input type="text"
							id="titulo" class="form-control input-sm" th:field="*{titulo}"
							autofocus="autofocus" placeholder="Informe o título"
							maxlength="300" /> 
					</div>
					<br/>
					
					<div th:classappend="${#fields.hasErrors('idTipo')}? 'has-error'">
						<label for="idTipo">Tipo</label>  <select th:field="*{idTipo}"
							id="idTipo" class="form-control">
							<option value="1" label="Mista - 4 operações" />
							<option value="2" label="Adição" />
							<option value="3" label="Subtração" />
							<option value="4" label="Multiplicação" />
							<option value="5" label="Divisão" />
						</select>
					</div>
					<br/>
					
					<div
						th:classappend="${#fields.hasErrors('descricao')}? 'has-error'">
						<label for="descricao">Descrição</label> 
						<textarea class="form-control input-sm" id="descricao"
							th:field="*{descricao}" cols="5" rows="5" placeholder="Descrição"></textarea>
					</div>
					<br/>
					
					<div th:classappend="${#fields.hasErrors('data')}? 'has-error'">
						<label for="data">Data</label> <input type="text"
							class="form-control input-sm" id="data" th:field="*{data}"
							readOnly="readonly" /> 
					</div>
					<br/>

					<input type="hidden" id="usuario" th:field="*{usuario}" />   
				</fieldset>
				<br/>
				
				<button type="submit" class="btn btn-sm btn-primary">Salvar</button>
				<a th:href="@{/prova/}" class="btn btn-sm btn-default">Cancelar</a>
			</form>
			<br/><br/>
		</div>
		
	</div>
</body>
</html>