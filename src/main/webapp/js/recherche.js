/**
 * 
 */

/*
function search(){
	var word = document.getElementById('inputSearch').value;
	//console.log(word);
}

//Dessine tableau pour page recherche en fonction d'un fichier JSON
function drawTab(){
	$.getJSON("donnees.json", function(data){
		var tableau = '<div class="col-xs-offset-1 col-xs-10" id="tabMedia">' +
	                  '<table class="table table-hover"><thead class="theadSearch">' +
	                  '<tr><th>Type</th><th>Titre</th><th>Auteur</th><th>Emprunté par</th>'+
	                  '<th>Retour prévu</th></tr></thead><tbody>';
		var i = 1;
		$.each(data, function(x, val){
			console.log(val);
			for(var m in val){
				console.log(val[m].titre);
				tableau += '<tr class="rowTab'+i+'" onmouseover="$(this).css(\'cursor\', \'pointer\');" onclick="clickableTr()"><td><span class="glyphicon glyphicon-';
				if(val[m].type == "livre")
					tableau += "book";
				else if(val[m].type == "cd")
					tableau += "music";
				else
					tableau += "film";
				tableau += '"></span></td>';
	
				//Ajout td json
				tableau += '<td>' + val[m].titre + '</td><td>'+val[m].auteur+'</td><td>'+val[m].emprunte+'</td><td>'+val[m].date+'</td></tr>';
	
	
				//Ajout du détail
				tableau += '<tr class="trHidden' + i + '" style="display: none"><td colspan="5"><div class="divHidden'+i+'" style="display: none">';
				tableau += '<img src="http://www.dta-ingenierie.fr/img/logoDTA2.png" alt="DTA logo" height="150" width="150">';
				tableau += '<p>Test d\'affichage de la div hidden lors de l\'appuie d\'un td sur le tableau !</p>';
				tableau += '</div></td></tr>';
				
				i++;
			}
			tableau += '</tbody></table></div>';
			// console.log(tableau);
			$('#tabMedia').html(tableau);
		});
	});

}

function clickableTr() {
	if($(this).next('div').is(":hidden")){
		console.log('ok');
	}else{
		console.log('Pasok');
}
*/


//Fonction permettant l'affichage des radios/checkbox en fonction du choix médias ou adhérents
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
	getval(sel);
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