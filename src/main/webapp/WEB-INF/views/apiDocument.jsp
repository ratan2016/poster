<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
		href="${pageContext.request.contextPath}/static/dataTables/css/jquery.dataTables.css" />
</head>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<h1>API Document</h1>
		<div class="row">
			<spring:form role="form" id="apiDocumentForm"
				commandName="apiDocument">
				<input type="hidden" id="id" name="id" />
				<div class="row">
					<div class="form-group col-sm-6">
						<label for="bundleId">API Bundle Name *</label>
						<spring:select path="bundleId" id="bundleId" required="required"
							class="form-control">
							<option value="">--Select Bundle Name--</option>
							<c:forEach var="api" items="${apiBundleMap}">
								<option value="${api.key}"><c:out value="${api.value}" /></option>

							</c:forEach>
						</spring:select>
					</div>


				</div>
				<div class="row">
					<div class="form-group col-sm-6">
						<label for="documentName">Document Name *</label>
						<spring:input path="documentName" id="documentName"
							required="required" placeholder="Enter Document Name"
							class="form-control" />
					</div>

					<div class="form-group col-sm-6">
						<label for="documentDescription">Document Description *</label>
						<spring:input path="documentDescription" id="documentDescription"
							required="required" placeholder="Enter Document Description"
							class="form-control" />
					</div>
				</div>

				<div class="row">
					<hr />
					<div class="pull-right">
						<button type="button" class="btn btn-primary" id="add">
							<span class="glyphicon glyphicon-plus"></span> ADD
						</button>
						<button type="button" class="btn btn-warning" id="update">
							<span class="glyphicon glyphicon-edit"></span> UPDATE
						</button>
						<button type="button" class="btn btn-danger" id="delete">
							<span class="glyphicon glyphicon-trash"></span> DELETE
						</button>
						<button type="button" class="btn btn-default"
							onclick="clearEntryForm();" id="clear">CLEAR</button>

					</div>
				</div>

				<hr />

			</spring:form>
		</div>


		<div class="row" id="tableContent">
			<jsp:include page="applicationTable.jsp" />
		</div>

	</div>


	<jsp:include page="footer.jsp" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/dataTables/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/apiDocument.js"></script>
	<script type="text/javascript">
	activeThisPage("document");
	</script>

</body>
</html>