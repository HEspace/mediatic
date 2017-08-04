'use strict';

angular.module('mediatic.ajoutAdherent', ['ngRoute'])


.controller('AjoutAdherentCtrl', ['$scope', '$location',function($scope, $location) {

  console.log($location.path());

   $scope.submit = function(){
    $location.path('../accueil/accueil.html');
    }

  



  
function jourDepuis(date) {
	var temps = (new Date()).getTime()-date.getTime();
	return (temps/1000/60/60/24).toFixed(0);
}
}]);