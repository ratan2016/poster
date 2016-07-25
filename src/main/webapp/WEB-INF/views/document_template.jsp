<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<script type="text/javascript">
$(".document-div img").addClass("img-responsive").attr("align","middle");
</script>
<div class="row">
	<div class="col-sm-9">
		<h3>${resultDocument.documentName}</h3>
	</div>
	<div class="col-sm-3">
		<div class="btn-group pull-right" role="group">
			<h3>
				<a href="#" onclick="loadEditor('createSection');" id="add"
					title="Add Section"><span class="glyphicon glyphicon-plus"></span></a>&nbsp;&nbsp;
				<a href="#" onclick="loadSections();" title="Reorder Sections"><span
					class="glyphicon glyphicon-sort"></span></a>&nbsp;&nbsp;

			</h3>
		</div>

	</div>
</div>

<form>
	<input type="hidden" id="applicationId" value="${resultDocument.id}">

</form>
<hr />
<div class="row">
	<div class="col-sm-9">
		<c:if test="${resultDocument.documentation eq null }">
		Document content is not available.
	</c:if>
	</div>

</div>
<c:set var="sectionList"
	value="${resultDocument.documentation.sections}"></c:set>
<c:forEach var="section" items="${sectionList}">

	<div class="col-sm-9">
		<h4 class="section-head">${section.sectionName}</h4>
		<p>${section.sectionDetail}</p>


	</div>
	<div class="col-sm-3">
		<div class="btn-group pull-right">
			<a href="#" onclick='loadEditor("updateSection","${section.id}");'
				id="update" title="Update Section"><span
				class="glyphicon glyphicon-edit"></span></a>&nbsp;&nbsp;&nbsp; <a
				href="#" onclick="deleteSection(${section.id});" id="delete"
				title="Delete Section"><span class="glyphicon glyphicon-trash"></span></a>



		</div>

	</div>


</c:forEach>




