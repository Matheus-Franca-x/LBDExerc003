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

<title>Viagem</title>
</head>
<body>
<div class="bg-black custom">
	<div class="container bg-white scroll" id="nav-container">
		<h1 class="text-center">CRUD - Viagem</h1>
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
			<form action="viagem" method="post">
				<div class="form-floating d-flex mb-3">
					<input type="number" class="form-control input-height" id="floatingInput" placeholder="Codigo" step="1" name="codigo" value='<c:out value="${motorista.codigo}"></c:out>'>
					<label for="floatingInput" class="font-text">C�digo</label>
					<button class="btn btn-outline-secondary" name="botao" value="Buscar">Buscar</button>
				</div>
				<div class="form-floating mb-3">
					<input type="text" class="form-control input-height" id="floatingInput" placeholder="Placa" name="placaOnibus" value='<c:out value="${viagem.onibus.placa}"></c:out>'>
					<label for="floatingInput" class="font-text">Placa do onibus</label>
				</div>
				<div class="form-floating mb-3 input-height">
					<input type="number" class="form-control input-height" id="floatingInput" placeholder="CodigoMotorista" step="1" name="codigoMotorista" value='<c:out value="${viagem.motorista.codigo}"></c:out>'>
					<label for="floatingInput" class="font-text">C�digo do motorista</label>
				</div>
				<div class="form-floating mb-3 input-height">
					<input type="number" class="form-control input-height" id="floatingInput" placeholder="HoraSaida" step="1" name="horaSaida" value='<c:out value="${viagem.horaSaida}"></c:out>'>
					<label for="floatingInput" class="font-text">Hora de sa�da</label>
				</div>
				<div class="form-floating mb-3 input-height">
					<input type="number" class="form-control input-height" id="floatingInput" placeholder="HoraChegada" step="1" name="horaChegada" value='<c:out value="${viagem.horaChegada}"></c:out>'>
					<label for="floatingInput" class="font-text">Hora de Chegada</label>
				</div>
				<div class="form-floating mb-3 input-height">
					<input type="text" class="form-control input-height" id="floatingInput" placeholder="Partida" name="partida" value='<c:out value="${viagem.partida}"></c:out>'>
					<label for="floatingInput" class="font-text">Partida</label>
				</div>
				<div class="form-floating mb-3 input-height">
					<input type="text" class="form-control input-height" id="floatingInput" placeholder="Destino" name="destino" value='<c:out value="${viagem.destino}"></c:out>'>
					<label for="floatingInput" class="font-text">Destino</label>
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
		<div class="form-container m-auto border border-primary rounded-4" style="max-width: 800px;">
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="col font-text">C�digo</th>
						<th class="col font-text">Placa do onibus</th>
						<th class="col font-text">C�digo do motorista</th>
						<th class="col font-text">Hora de sa�da</th>
						<th class="col font-text">Hora de chegada</th>
						<th class="col font-text">Partida</th>
						<th class="col font-text">Destino</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty viagens}">
						<c:forEach var="v" items="${viagens}">
							<tr>
								<th scope="row"><c:out value="${v.codigo}"/></th>
								<td><c:out value="${v.onibus.placa}"/></td>
								<td><c:out value="${v.motorista.codigo}"/></td>
								<td><c:out value="${v.horaSaida}"/></td>
								<td><c:out value="${v.horaChegada}"/></td>
								<td><c:out value="${v.partida}"/></td>
								<td><c:out value="${v.destino}"/></td>
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