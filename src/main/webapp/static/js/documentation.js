$(document).ready(function() {

	$(".document-list").click(function() {
		$(".sidebar-nav li").removeClass("active");
		$(this).parent().addClass("active");

		var id = $(this).attr("id");
		$.ajax({
			url : "/poster/documents/" + id,
			type : "GET",
			success : function(result) {
				$(".document-div").html(result);
			}

		});

	});

});

function loadEditor(operation, id) {
	var applicationId = $("#applicationId").val();
	var json = {
		"applicationId" : applicationId,
		"id" : parseInt(id),
		"operation" : operation
	};
	$.ajax({
		url : "/poster/editor",
		data : JSON.stringify(json),
		contentType : "application/json",
		type : "POST",
		success : function(result) {

			showModel("Add Section", result);
		}

	});

}

function loadSections() {
	var applicationId = $("#applicationId").val();
	$.ajax({
		url : "/poster/loadSections/" + applicationId,
		type : "GET",
		success : function(result) {

			showModel("Reorder Sections", result);
		}

	});
}

function reorderSections() {
	var applicationId = $("#applicationId").val();
	var json = new Object();
	$("#sortable li").each(function(count) {
		var span = $(this).find("span");
		json[$(span).attr("id")] = count + 1;
	});
	$.ajax({
		url : "/poster/reorderSections/" + applicationId,
		data : JSON.stringify(json),
		contentType : "application/json",
		type : "POST",
		success : function(result) {

			$(".document-div").html(result);
			hideModal();
		}

	});
}

function deleteSection(sectionId) {
	var applicationId = $("#applicationId").val();
	var json = {
		"applicationId" : applicationId,
		"id" : sectionId
	};
	$.ajax({
		url : "/poster/deleteSection",
		data : JSON.stringify(json),
		contentType : "application/json",
		type : "POST",
		success : function(result) {

			$(".document-div").html(result);
		}

	});
}