<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#save").click(function() {

			var id = $("#sectionId").val();
			var applicationId = $("#applicationId").val();
			var sectionName = $("#sectionName").val();
			var sectionDetail = CKEDITOR.instances.editor.getData();
			var sectionOrder = $("#sectionOrder").val();
			var json = {
				"applicationId" : applicationId,
				"id" : id,
				"sectionName" : sectionName,
				"sectionDetail" : sectionDetail,
				"sectionOrder" : sectionOrder
			};
			var operation = $("#operation").val();
			if (requiredField('sectionForm')) {
				$.ajax({
					url : "/" + operation,
					type : "POST",
					data : JSON.stringify(json),
					contentType : "application/json",
					success : function(result) {
						$(".document-div").html(result);
						hideModal();
					}

				});
			}

		});
	});

	var initSample = (function() {
		return function() {
			var editorElement = CKEDITOR.document.getById('editor');
			var sectionDetails = $("#sectionDetail").val();
			if (sectionDetails == null || sectionDetails == "") {
				editorElement.setHtml('Add content here...');
			} else {
				editorElement.setHtml(sectionDetails);
			}

			CKEDITOR.replace('editor');
		};

	})();

	initSample();
</script>

	
		<spring:form role="form" id="sectionForm" commandName="section">
			<spring:hidden id="sectionId" path="id" />
			<spring:hidden id="sectionDetail" path="sectionDetail" />
			<spring:hidden id="sectionOrder" path="sectionOrder" />
			<input type="hidden" name="operation" id="operation"
				value="${operation}" />
			<div class="row">
				<div class="form-group col-lg-6">
					<label for="sectionName">Section Name *</label>
					<spring:input path="sectionName" id="sectionName"
						required="required" class="form-control" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-lg-12">
					<label for="bundleName">Bundle Description</label>

					<div contenteditable="true" id="editor"></div>
				</div>
			</div>
			<div class="row">
				<hr />
				<div class="btn-group pull-right margin-right-15" role="group">
					<button type="button" class="btn btn-primary" id="save">SAVE</button>
					<!-- <button type="button" class="btn btn-default"
						onclick="clearEntryForm();" id="clear">CLEAR</button> -->
				</div>
			</div>

			

		</spring:form>

