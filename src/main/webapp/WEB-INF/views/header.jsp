<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>API Posters</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-2.1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/script.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/header.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/header.css" />


<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>

</head>
<body>

	<nav class="navbar navbar-default">
		<div class="masthead">
			<div class="mastheadContainer">
				<div id="menuBtn"></div>
				<div class="logoContainer">
					<a class="navbar-brand head-icon"
						href="${pageContext.request.contextPath}/index">Yummy</a>
				</div>
				<div class="mhButtonContainer">
					<div class="nav active">
						<a href="${pageContext.request.contextPath}/index">HOME</a>
					</div>
					<div class="divider"></div>
					<div class="nav ">
						<a 
							href="${pageContext.request.contextPath}/documentation">DOCUMENTATION
							ALL</a>
					</div>

					<div class="divider"></div>
					<div class="nav ">
						<a href="${pageContext.request.contextPath}/applications">TOPIC
							BUNDLE</a>
					</div>

					<div class="divider"></div>
					<div class="nav ">
						<a href="${pageContext.request.contextPath}/api">TOPIC</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</nav>

	<%-- <nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand head-icon"
					href="${pageContext.request.contextPath}/index">Yummy</a>
			</div>
			
			<ul class="nav navbar-nav">
				<li class="" id="home"><a
					href="${pageContext.request.contextPath}/index">Home</a></li>
				<li id="documentation"><a
					href="${pageContext.request.contextPath}/documentation">Documentation
						All</a></li>
				<li id="application"><a
					href="${pageContext.request.contextPath}/applications">API
						Bundle</a></li>
				<li id="document"><a
					href="${pageContext.request.contextPath}/api">API Document</a></li>
			</ul>
		</div>
	</nav> --%>
</body>
</html>