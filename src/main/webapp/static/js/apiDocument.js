$(document).ready(function() {

	$.ajax({
		url : "/poster/documents",
		type : "GET",
		success : function(result) {
			$("#tableContent").html(result);
		}

	});

	$("#add").click(function() {
		if (requiredField('apiDocumentForm')) {
			$.ajax({
				url : "/poster/addApi",
				type : "POST",
				data : $("#apiDocumentForm").serialize(),
				success : function(result) {
					$("#tableContent").html(result);
					clearEntryForm();
				}

			});
		}

	});

	$("#update").click(function() {
		if (requiredField('apiDocumentForm')) {
			$.ajax({
				url : "/poster/modifyDocument",
				type : "POST",
				data : $("#apiDocumentForm").serialize(),
				success : function(result) {
					$("#tableContent").html(result);
					clearEntryForm();
				}

			});
		}

	});
	$("#delete").click(function() {
		if (requiredField('apiDocumentForm')) {
			$.ajax({
				url : "/poster/deleteApi",
				type : "POST",
				data : $("#apiDocumentForm").serialize(),
				success : function(result) {
					$("#tableContent").html(result);
					clearEntryForm();
				}

			});
		}

	});

});

function clearEntryForm() {
	$("#id").val();
	$("#documentName").val("");
	$("#documentDescription").val("");
	$("#bundleId").val("");
}
function dataFiller(thisObj) {
	if (!thisObj.checked) {
		thisObj.checked = false;
	} else {
		var id = $(thisObj).attr("id");
		$("#id").val(id);
		$("#documentName").val($("#documentName_" + id).text());
		$("#documentDescription").val($("#documentDescription_" + id).text());
		$("#bundleId").val($("#bundle_hidden_" + id).val());

	}
}
