'use strict';

angular.module('mediatic.ajoutMedia', ['ngRoute'])

.controller('AjoutMediaCtrl', ['MediaService', '$rootScope', function(MediaService, $rootScope) {

  var ctrl = this;
  ctrl.form={};
  

	if($rootScope.form.media != {}){
		ctrl.form.auteur = $rootScope.form.media.auteur;
		ctrl.form.titre = $rootScope.form.media.titre;
		ctrl.form.type = $rootScope.form.media.type;
		$rootScope.form.media = {};
	}

	ctrl.envoi = function(){
		MediaService.ajoutMedia(ctrl.form);
	}


}]);