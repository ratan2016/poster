$(document).ready(function() {

	$.ajax({
		url : "/bundles",
		type : "GET",
		success : function(result) {
			$("#tableContent").html(result);
		}

	});

	$("#add").click(function() {
		var bundleName = $("#bundleName").val();
		var bundleDescription = $("bundleDescription").val();
		if (requiredField('apiBundleForm')) {
			$.ajax({
				url : "/add",
				type : "POST",
				data : $("#apiBundleForm").serialize(),
				success : function(result) {
					$("#tableContent").html(result);
					clearEntryForm();
				}

			});
		}

	});

	$("#update").click(function() {
		var bundleName = $("#bundleName").val();
		var bundleDescription = $("bundleDescription").val();
		if (requiredField('apiBundleForm')) {
			$.ajax({
				url : "/modifyBundles",
				type : "POST",
				data : $("#apiBundleForm").serialize(),
				success : function(result) {
					$("#tableContent").html(result);
					clearEntryForm();
				}

			});
		}

	});
	$("#delete").click(function() {
		var bundleName = $("#bundleName").val();
		var bundleDescription = $("bundleDescription").val();
		if (requiredField('apiBundleForm')) {
			$.ajax({
				url : "/delete",
				type : "POST",
				data : $("#apiBundleForm").serialize(),
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
	$("#bundleName").val("");
	$("#bundleDescription").val("");

}
function dataFiller(thisObj) {
	if (!thisObj.checked) {
		thisObj.checked = false;
	} else {
		var id = $(thisObj).attr("id");
		$("#id").val(id);
		$("#bundleName").val($("#bundleName_" + id).text());
		$("#bundleDescription").val($("#bundleDescription_" + id).text());

	}
}
