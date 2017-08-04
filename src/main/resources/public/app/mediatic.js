'use strict';

// Declare app level module which depends on views, and components
angular.module('mediatic', [
  'ngRoute',
  'mediatic.recherche',
  'mediatic.accueil',
  'mediatic.ajoutMedia',
  'mediatic.ajoutAdherent',
  'mediatic.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/view1'});
  
  $routeProvider.when('/accueil', {
	    templateUrl: 'accueil/accueil.html',
	    controller: 'accueilCtrl'
	  });
  
  $routeProvider.when('/recherche', {
	    templateUrl: 'recherche/recherche.html',
	    controller: 'rechercheCtrl'
	  });
  
  $routeProvider.when('/ajoutMedia', {
	    templateUrl: 'ajoutMedia/ajoutMedia.html',
	    controller: 'ajoutMediaCtrl'
	  });
  
  $routeProvider.when('/ajoutAdherent', {
	    templateUrl: 'ajoutAdherent/ajoutAdherent.html',
	    controller: 'ajoutAdherentCtrl'
	  });
}]);
