<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<script type="text/javascript">
$(".document-div img").addClass("img-responsive").attr("align","middle");
</script>
<div class="col-lg-12 documentHead">
<h3>
	${resultDocument.documentName} <a href="#" class="pull-right small"
		onclick="loadSections();" title="Reorder Sections"><span
		class="glyphicon glyphicon-sort"></span></a> <a href="#"
		class="pull-right small pad-r-10" onclick="loadEditor('createSection');" id="add"
		title="Add Section"><span class="glyphicon glyphicon-plus"></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</h3>
<hr>
</div>


<form>
	<input type="hidden" id="applicationId" value="${resultDocument.id}">

</form>
	<div class="col-lg-12">
		<c:if test="${resultDocument.documentation eq null }">
		Document content is not available.
	</c:if>
	</div>


<c:set var="sectionList"
	value="${resultDocument.documentation.sections}"></c:set>
<c:forEach var="section" items="${sectionList}">

	<div class="col-lg-12">
		<h4 class="section-head">${section.sectionName}
		<a class="pull-right small"
				href="#" onclick="deleteSection(${section.id});" id="delete"
				title="Delete Section"><span class="glyphicon glyphicon-trash"></span></a>
		
		<a class="pull-right small pad-r-10" href="#" onclick='loadEditor("updateSection","${section.id}");'
				id="update" title="Update Section"><span
				class="glyphicon glyphicon-edit"></span></a>
		</h4>
		<p>${section.sectionDetail}</p>


	</div>

</c:forEach>



