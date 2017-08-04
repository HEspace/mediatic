'use strict';

angular.module('mediatic.ajoutAdherent', ['ngRoute'])


.controller('AjoutAdherentCtrl', [function() {
  
function jourDepuis(date) {
	var temps = (new Date()).getTime()-date.getTime();
	return (temps/1000/60/60/24).toFixed(0);
}
}]);