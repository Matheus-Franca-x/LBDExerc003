<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<!-- Script -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script>
	
</script>

<link rel="stylesheet" href="./css/style.css">

<title>Motorista</title>
</head>
<body>
<div class="bg-black custom">
	<div class="container bg-white scroll" id="nav-container">
		<h1 class="text-center">CRUD - Motorista</h1>
		<nav class="navbar navbar-expand">
			<div class="container-fluid">
				<div class="m-auto">
					<div class="row">
						<div class="col-auto p-0 text-center" style="width: 100px;">
							<button class="btn btn-outline-primary" style="width: 93px" OnClick="window.location.href='./'">home</button>
						</div>
						<div class="col-auto p-0 text-center" style="width: 100px;">
							<button class="btn btn-outline-primary" style="width: 93px" OnClick="window.location.href='./motorista'">motorista</button>
						</div>
						<div class="col-auto p-0 text-center" style="width: 100px;">
							<button class="btn btn-outline-primary" style="width: 93px" OnClick="window.location.href='./onibus'">onibus</button>
						</div>
						<div class="col-auto p-0 text-center" style="width: 100px;">
							<button class="btn btn-outline-primary" style="width: 93px" OnClick="window.location.href='./viagem'">viagem</button>
						</div>
					</div>
				</div>
			</div>
		</nav>
		<main class="rounded-4 border border-primary form-container m-auto mb-3">
			<form action="motorista" method="post">
				<div class="form-floating d-flex mb-3">
					<input type="number" class="form-control input-height" id="floatingInput" placeholder="Codigo" step="1" name="codigo" value='<c:out value="${motorista.codigo}"></c:out>'>
					<label for="floatingInput" class="font-text">C�digo</label>
					<button class="btn btn-outline-secondary" name="botao" value="Buscar">Buscar</button>
				</div>
				<div class="form-floating mb-3">
					<input type="text" class="form-control input-height" id="floatingInput" placeholder="Nome" name="nome" value='<c:out value="${motorista.nome}"></c:out>'>
					<label for="floatingInput" class="font-text">Nome</label>
				</div>
				<div class="form-floating mb-3 input-height">
					<input type="text" class="form-control input-height" id="floatingInput" placeholder="Naturalidade" name="naturalidade" value='<c:out value="${motorista.naturalidade}"></c:out>'>
					<label for="floatingInput" class="font-text">Naturalidade</label>
				</div>
				<div class="d-flex">
					<button class="btn btn-success me-3" name="botao" value="Cadastrar">Cadastrar</button>
					<button class="btn btn-primary me-3" name="botao" value="Alterar">Alterar</button>
					<button class="btn btn-danger ms-auto" name="botao" value="Excluir">Excluir</button>
				</div>
			</form>
		</main>
		<div>
			<c:if test="${not empty erro}">
				<h2 class="text-center"><b><c:out value="${erro}"/></b></h2>
			</c:if>
		</div>
		<div>
			<c:if test="${not empty saida}">
				<h2 class="text-center"><b><c:out value="${saida}"/></b></h2>
			</c:if>
		</div>
		<div class="form-container m-auto border border-primary rounded-4">
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="col">C�digo</th>
						<th class="col">Nome</th>
						<th class="col">Naturalidade</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty motoristas}">
						<c:forEach var="m" items="${motoristas}">
							<tr>
								<th scope="row"><c:out value="${m.codigo}"/></th>
								<td><c:out value="${m.nome}"/></td>
								<td><c:out value="${m.naturalidade}"/></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>