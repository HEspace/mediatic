'use strict';
angular.module('mediatic.recherche', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/recherche', {
    templateUrl: 'recherche/recherche.html',
    controller: 'RechercheCtrl'
  });
}])
.controller('RechercheCtrl', [function(){

}]);