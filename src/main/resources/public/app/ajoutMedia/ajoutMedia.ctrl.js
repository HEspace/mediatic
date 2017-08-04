'use strict';

angular.module('mediatic.ajoutMedia', ['ngRoute'])

.controller('AjoutMediaCtrl', ['MediaService', function(MediaService) {

  var ctrl = this;
  ctrl.form={};

	ctrl.envoi = function(){
		MediaService.ajoutMedia(ctrl.form);
	}



function jourDepuis(date) {
	var temps = (new Date()).getTime()-date.getTime();
	return (temps/1000/60/60/24).toFixed(0);
}


}]);