$(document).ready(function() {

	$("body input").on("keydown", function() {
		var value = $(this).val();
		if ($(this).attr("required") == "required") {
			if (value == "" || value == null) {
				validateFlag = false;
				$(this).addClass("error-empty");
			} else {
				validateFlag = true;
				$(this).removeClass("error-empty");
			}
		}
	});

	$("body select").on("change", function() {
		var value = $(this).val();
		if ($(this).attr("required") == "required") {
			if (value == "" || value == null) {
				validateFlag = false;
				$(this).addClass("error-empty");
			} else {
				validateFlag = true;
				$(this).removeClass("error-empty");
			}
		}
	});

});

function showModel(title, modalBody, modalFooter) {
	var modalDiv = $("<div>").addClass("modal-content");

	var headerDiv = $("<div>").addClass("modal-header");
	var closeButton = $("<button>").attr({
		"type" : "button",
		"data-dismiss" : "modal",
		"class" : "close",
		"onclick" : "hideModal();"
	}).html("&times;");
	var modalTitle = $("<h4>").addClass("modal-title").text(title);
	headerDiv.append(closeButton).append(modalTitle);

	modalDiv.append(headerDiv);

	var body = $("<div>").addClass("modal-body").html(modalBody);
	modalDiv.append(body);

	$("#popup").html(modalDiv).css("display", "block").addClass("in");
	$("body").addClass("modal-open");
	positionPopUp();
}

function positionPopUp() {
	var popup_height = document.getElementById('popup').offsetHeight;
	var popup_width = document.getElementById('popup').offsetWidth;
	$("#popup").css('top', (($(window).height() - popup_height) / 2));
	$("#popup").css('left', (($(window).width() - popup_width) / 2));
}

function hideModal() {
	$("#popup").removeClass("in").css("display", "none");
	$("body").removeClass("modal-open");
}

function requiredField(formId) {
	var validateFlag = true;
	$("#" + formId + " input, select").each(function() {
		var value = $(this).val();
		if ($(this).attr("required") == "required") {
			if (value == "" || value == null) {
				validateFlag = false;
				$(this).addClass("error-empty");
			} else {
				validateFlag = true;
				$(this).removeClass("error-empty");
			}
		}

	});
	return validateFlag;
}

function activeThisPage(pageId) {
	$(".navbar-nav li").removeClass("active");
	$("#" + pageId).addClass("active");
}