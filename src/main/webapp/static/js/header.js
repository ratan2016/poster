$(document).ready(function() {
	$(window).resize(checkSize);
	$("#menuBtn").click(function() {
		if ($("#menuBtn").hasClass("opened")) {
			$("#menuBtn").removeClass("opened");
			$(".mhButtonContainer").hide();
		} else {
			$("#menuBtn").addClass("opened");
			$(".mhButtonContainer").fadeIn();
		}
	});
});
function checkSize() {
	if ($(window).innerWidth() > 768) {
		$(".mhButtonContainer").show();
	} else {
		$(".mhButtonContainer").hide();
		$("#menuBtn").removeClass("opened");
	}
}

