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
		<div class="col-lg-3 list-nav-bar">
			<ul class="sidebar-nav">
				<c:forEach var="document" items="${apiDocumentList}">
					<li><a href="#" id="${document.id}" class="document-list">
							<c:out value="${document.documentName}"></c:out>
					</a></li>
				</c:forEach>

			</ul>
		</div>


		<div class="col-lg-9 document-div">&nbsp;</div>
	</div>


	<jsp:include page="footer.jsp" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/documentation.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".document-list:first").click();
			activeThisPage("documentation");
		});
	</script>

</body>
</html>