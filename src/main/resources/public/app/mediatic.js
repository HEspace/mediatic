'use strict';

// Declare app level module which depends on views, and components
angular.module('mediatic', [
  'ngRoute',
  'ngMessages',
  'ngResource',
  'ui.grid',
  'ngStorage',
  'mediatic.recherche',
  'mediatic.accueil',
  'mediatic.ajoutMedia',
  'mediatic.ajoutAdherent',
  'mediatic.login',
  'mediatic.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/accueil'});
  
  $routeProvider.when('/accueil', {
	    templateUrl: 'accueil/accueil.html',
		controller: 'AccueilCtrl',
		controllerAs: 'ctrl'
	  });
  
  $routeProvider.when('/recherche', {
	    templateUrl: 'recherche/recherche.html',
	    controller: 'RechercheCtrl',
		controllerAs: 'ctrl'
	  });
  
  $routeProvider.when('/ajoutMedia', {
	    templateUrl: 'ajoutMedia/ajoutMedia.html',
	    controller: 'AjoutMediaCtrl',
		controllerAs: 'ctrl'
	  });
  
  $routeProvider.when('/ajoutAdherent', {
	    templateUrl: 'ajoutAdherent/ajoutAdherent.html',
	    controller: 'AjoutAdherentCtrl',
		controllerAs: 'ctrl'
	  });
}])

.run(function($rootScope) {
	$rootScope.cherche = "";
	$rootScope.form = {};
	$rootScope.form.media = {};
	$rootScope.form.adherent = {};
})
.controller('MediaticCtrl', ['$scope', '$rootScope', '$location', '$localStorage', 'LoginService', function($scope, $rootScope, $location, $localStorage, LoginService){

	var ctrl = this;

	$('#menuCollection').hide();
	$('#divlogin').slideUp();
	$('#sideMenu').slideUp();

	$scope.rechercher = function(){
		$rootScope.recherche = $scope.recherche ;
		console.log("test");
		console.log($rootScope.recherche);
		$location.path('/recherche');
	}

	if (window.innerWidth > 768)
		$('#boutonside').css('display','none');
	else
		$('#boutonside').css('display','block');

	$scope.toggleWrap = function(){
		$('.wrap').slideToggle(400);
	}

	ctrl.login = function () {
      //LoginService.storeUser(ctrl.user);
      //$location.path('acc');
    }


	$scope.openNav = function() {
		console.log("test");
		document.getElementById("idsidenav").style.width = "250px";
		document.getElementById("boutonside").style.marginLeft = "250px";
		$('#boutonside').css('display','none');
		setTimeout(function(){
			$('#divlogin').slideDown();
			$('#sideMenu').slideDown();
		}, 400)
	}

	$scope.closeNav = function() {
		$('#divlogin').slideUp();
		$('#sideMenu').slideUp();
		setTimeout(function(){
			document.getElementById("idsidenav").style.width = "0";
			document.getElementById("boutonside").style.marginLeft= "0";
			$('#boutonside').css('display','block');
		}, 400)
	}



	$scope.inverserCollectionMenu = function(){
		if ($("#menuCollection").is(":visible")){
			$('#menuCollection').slideUp();
			
		}
		else
			$('#menuCollection').slideDown();
	}


	window.addEventListener('resize', function(event){
		if (window.innerWidth > 768)
			$('#boutonside').css('display','none');
		else
			$('#boutonside').css('display','block');
	});

	var myNavBar = {
	    flagAdd: true,
	    elements: [],
	    init: function (elements) {
	        this.elements = elements;
	    },
	    add : function() {
	        if(this.flagAdd) {
	            for(var i=0; i < this.elements.length; i++) {
	                document.getElementById(this.elements[i]).className += " fixed-theme";
	            }
	            this.flagAdd = false;
	        }
	    },
	    remove: function() {
	        for(var i=0; i < this.elements.length; i++) {
	            document.getElementById(this.elements[i]).className =
	                    document.getElementById(this.elements[i]).className.replace( /(?:^|\s)fixed-theme(?!\S)/g , '' );
	        }
	        this.flagAdd = true;
	    }
	};
	myNavBar.init(  [
	    "header",
	    "header-container",
	    "brand"
	]);
	function offSetManager(){

	    var yOffset = 0;
	    var currYOffSet = window.pageYOffset;

	    if(yOffset < currYOffSet) {
	        myNavBar.add();
	    }
	    else if(currYOffSet == yOffset){
	        myNavBar.remove();
	    }

	}
	window.onscroll = function(e) {
	    offSetManager();
	}
	offSetManager();
}]);
