'use strict';

angular.module('mediatic.ajoutMedia', ['ngRoute'])

.controller('AjoutMediaCtrl', ['MediaService', '$rootScope','$location','$scope', function(MediaService, $rootScope, $location, $scope) {

  var ctrl = this;
  ctrl.form={};
  

	if($rootScope.form.media != {}){
		ctrl.form.auteur = $rootScope.form.media.auteur;
		ctrl.form.titre = $rootScope.form.media.titre;
		ctrl.form.type = $rootScope.form.media.type;
		$rootScope.form.media = {};
	}

	ctrl.envoi = function(){

		var premiereLettreTitre = capitalizeFirstLetter($scope.titre);
		ctrl.form.titre = premiereLettreTitre;

		var premiereLettreAuteur = capitalizeFirstLetter($scope.auteur);
        ctrl.form.auteur = premiereLettreAuteur;

		MediaService.ajoutMedia(ctrl.form);

	}

	 function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}


}]);