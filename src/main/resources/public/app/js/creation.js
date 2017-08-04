/**
 * 
 */

/*
$(document).ready(function(){
	if (document.getElementById("dateNaissance")== option.getAttribute("value")){
		
	f =	function jourDepuis(document.getElementById("dateNaissance"));
	f.elements["age"].value = 'montexte';
		
		
	}
	else
		return 0;
	
});
*/

function jourDepuis(date) {
	var temps = (new Date()).getTime()-date.getTime();
	return (temps/1000/60/60/24).toFixed(0);
}