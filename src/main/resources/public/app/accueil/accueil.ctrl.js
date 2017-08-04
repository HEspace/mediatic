'use strict';

angular.module('mediatic.accueil', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/accueil', {
    templateUrl: 'accueil/accueil.html',
    controller: 'AccueilCtrl'
  });
}])
.controller('AccueilCtrl', [function() {

}]);