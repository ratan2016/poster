<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-ui/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/jquery-ui/jquery-ui.min.css" />

<script>
	$(function() {
		$("#sortable").sortable();
		$("#sortable").disableSelection();
	});
</script>
<div class="row wrapper-div">
	<ul id="sortable">
		<c:set var="sectionList"
			value="${resultDocument.documentation.sections}"></c:set>
		<c:forEach var="section" items="${sectionList}">
			<li class="ui-state-default"><span id="${section.id}"
				class="ui-icon ui-icon-arrowthick-2-n-s"></span>${section.sectionName}</li>
		</c:forEach>
	</ul>

</div>

<div class="row">
	<hr />
	<div class="btn-group pull-right margin-right-15" role="group">
		<button type="button" class="btn btn-primary" id="save"
			onclick="reorderSections();">SAVE</button>
		<!-- <button type="button" class="btn btn-default"
						onclick="clearEntryForm();" id="clear">CLEAR</button> -->
	</div>

</div>
