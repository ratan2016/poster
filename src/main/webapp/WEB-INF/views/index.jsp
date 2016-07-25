<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<h1>Recipes</h1>
		<div class="row">
			<c:forEach var="api" items="${apiBundleList}">
				<a href="documentation/${api.id}">
					<div class="col-sm-3 cards">
						<h3>
							<c:out value="${api.bundleName}" />
						</h3>
						<p>
							<c:out value="${api.bundleDescription}" />
							...
						</p>
					</div>
				</a>
			</c:forEach>
		</div>

	</div>





	<jsp:include page="footer.jsp" />
	<script type="text/javascript">
		activeThisPage("home");
	</script>


</body>
</html>