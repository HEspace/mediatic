'use strict';

angular.module('mediatic.ajoutAdherent', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ajoutAdherent', {
    templateUrl: 'ajoutAdherent/ajoutAdherent.html',
    controller: 'AjoutAdherentCtrl'
  });
}])

.controller('AjoutAdherentCtrl', [function() {

}]);