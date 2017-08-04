'use strict';

angular.module('mediatic.ajoutMedia', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ajoutMedia', {
    templateUrl: 'ajoutMedia/ajoutMedia.html',
    controller: 'AjoutMediaCtrl'
  });
}])

.controller('AjoutMediaCtrl', [function() {

}]);