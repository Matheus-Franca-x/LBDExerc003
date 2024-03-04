<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<link rel="stylesheet" href="./css/style.css">
<!-- Script -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<title>CRUD java web - Jakarta EE</title>
</head>
<body>
<div class="bg-black custom">
	<div class="container bg-white scroll" id="nav-container">
		<h1 class="text-center">Exerc�cio CRUD java web</h1>
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
		<div class="d-flex">
			<img class="rounded-5 m-auto" width="1000" alt="colevas" src="./img/Colevate.jpeg">
		</div>
	</div>
</div>
</body>
</html>