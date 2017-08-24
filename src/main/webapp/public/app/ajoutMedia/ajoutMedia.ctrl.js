'use strict';

angular.module('mediatic.ajoutMedia', ['ngRoute'])

.controller('AjoutMediaCtrl', ['MediaService', '$rootScope','$location','$scope', function(MediaService, $rootScope, $location, $scope) {

  var ctrl = this;
  ctrl.form={};
  

	if($rootScope.form.media != {}){
		ctrl.form.id = $rootScope.form.media.id;
		ctrl.form.auteur = $rootScope.form.media.auteur;
		ctrl.form.titre = $rootScope.form.media.titre;
		ctrl.form.type = $rootScope.form.media.type;

		$rootScope.form.media = {};
	}

	ctrl.envoi = function(){
		MediaService.ajoutMedia(ctrl.form);
	}

	$scope.$watch('ctrl.form',function(){
		if(ctrl.form.titre)
			ctrl.form.titre = capitalizeFirstLetter(ctrl.form.titre);
		if(ctrl.form.auteur)
			ctrl.form.auteur = capitalizeFirstLetter(ctrl.form.auteur);
	},true);

	function capitalizeFirstLetter(string) {
    	return string.charAt(0).toUpperCase() + string.slice(1);
}
	 if(!$rootScope.login){
        $location.path("/accueil");
    }


}]);