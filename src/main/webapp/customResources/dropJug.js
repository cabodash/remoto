/**
 * 
 */
$(".dropdown img.flag").addClass("flagvisibility");
		$(".dropdown dt a").click(function() {
			$(".dropdown dd ul").toggle();
		});

		$(".dropdown dd ul li a").click(function() {
			var text = $(this).html();
			$(".dropdown dt a span").html(text);
			$(".dropdown dd ul").hide();
			$("#cod_jugador").val(getSelectedValue("sample"));
		});

		function getSelectedValue(id) {
			return $("#" + id).find("dt a span.value").html();
		}

		$(document).bind('click', function(e) {
			var $clicked = $(e.target);
			if (!$clicked.parents().hasClass("dropdown"))
				$(".dropdown dd ul").hide();
		});

		$(".dropdown img.flag").toggleClass("flagvisibility");