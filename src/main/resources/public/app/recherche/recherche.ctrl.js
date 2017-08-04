'use strict';

angular.module('mediatic.recherche', ['ngRoute'])

.controller('RechercheCtrl', [function(){

    function getval(sel){
	var index = document.getElementById("sel").selectedIndex;
	var options = document.getElementById("sel").options;
	if(options[index].text == "Médias"){
		$("#radioAdhe").hide();
		$("#checkMedia").fadeIn();
		$("#tabAdherent").hide();
		$("#tabMedia").fadeIn();
	}else{
		console.log("adherent");
		$("#checkMedia").hide();
		$("#radioAdhe").fadeIn();
		$("#tabAdherent").fadeIn();
		$("#tabMedia").hide();
	}
}


$(document).ready(function () {
	getval(document.getElementById("sel"));
	//drawTab();
	$("#radioAdhe").hide();
	$("#tabAdherent").hide();
	//$(".rowHidden").hide();
	//$("div.divHidden1").hide();

	$('.rowTab').click(function(){
		//console.log("test");
		if($(".divHiddenMedia").is(":hidden")){
			$(".trHiddenMedia").fadeIn("slow")
			$( ".divHiddenMedia" ).slideDown("slow");
		}else{
			$(".trHiddenMedia").hide("fast")
			$(".divHiddenMedia").slideUp("fast");
		}

		if($(".divHiddenUser").is(":hidden")){
			$(".trHiddenUser").fadeIn("slow")
			$( ".divHiddenUser" ).slideDown("slow");
		}else{
			$(".trHiddenUser").hide("fast")
			$(".divHiddenUser").slideUp("fast");
		}
	});

	$('.rowTab').hover(function () {
		$(this).css('cursor', 'pointer');
	});
});
}]);