<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
		href="${pageContext.request.contextPath}/static/dataTables/css/jquery.dataTables.css" />
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<h1>API Bundle</h1>
		<div class="row">
			<spring:form role="form" id="apiBundleForm" commandName="apiBundle">
				<input type="hidden" id="id" name="id" />
				<div class="row">
					<div class="form-group col-sm-6">
						<label for="bundleName">Bundle name *</label>
						<spring:input path="bundleName" id="bundleName"
							required="required" placeholder="Enter Bundle Name"
							class="form-control" />
					</div>

					<div class="form-group col-sm-6">
						<label for="bundleName">Bundle Description *</label>
						<spring:input path="bundleDescription" id="bundleDescription"
							required="required" placeholder="Enter Bundle Description"
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
		src="${pageContext.request.contextPath}/static/js/application.js"></script>
	<script type="text/javascript">
		activeThisPage("application");
	</script>

</body>
</html>