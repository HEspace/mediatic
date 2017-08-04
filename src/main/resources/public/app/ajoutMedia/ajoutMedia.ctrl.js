'use strict';

angular.module('mediatic.ajoutMedia', ['ngRoute'])



.controller('AjoutMediaCtrl', [function() {

  
function jourDepuis(date) {
	var temps = (new Date()).getTime()-date.getTime();
	return (temps/1000/60/60/24).toFixed(0);
}
}]);