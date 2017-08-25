'use strict';

// Declare app level module which depends on views, and components
angular.module('mediatic', [
  'ngRoute',
  'ngMessages',
 'ngResource',
  'ngStorage',
  'ui.grid',
  'mediatic.recherche',
  'mediatic.accueil',
  'mediatic.collection',
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
	$routeProvider.when('/collection', {
	    templateUrl: 'collection/collection.html',
	    controller: 'CollectionCtrl',
		controllerAs: 'ctrl'
	});
}])
.run(function($rootScope) {
	$rootScope.cherche = "";
	$rootScope.form = {};
	$rootScope.form.media = {};
	$rootScope.form.adherent = {};
})
.controller('MediaticCtrl', ['$http', '$timeout', '$window', '$scope', '$rootScope', '$location', '$localStorage', 'LoginService','RechercheService' , function($http, $timeout, $window, $scope, $rootScope, $location, $localStorage, LoginService, RechercheService){
	var message = $http({
		method: 'GET',
		url: 'http://localhost:8080/api/login/user'
	}).then(function successCallback(response) {
		$rootScope.login = response.data.name;
		if(response.data.authorities)
			$rootScope.droit = response.data.authorities.length;
		else
			$rootScope.droit = 0;
		console.log($rootScope.droit);
		$('#menuCollection').hide();
		$('#sideMenu').slideUp();
	
		if($rootScope.login){
			$location.path('/recherche');
		}
		else{
			$location.path('/accueil');
		}

		$scope.changementContour();
		offSetManager();

		// this callback will be called asynchronously
		// when the response is available
	}, function errorCallback(response) {
		// called asynchronously if an error occurs
		// or server returns response with an error status.
	});

	var ctrl = this;
	ctrl.user = {};

	

	$scope.rechercher = function(){
		$location.path('/recherche');
		RechercheService.recherche($scope.recherche) ;
		$scope.recherche = '';
	}

	if (window.innerWidth > 768)
		$('#boutonside').css('display','none');
	else
		$('#boutonside').css('display','block');

	$scope.logout = function(){
		$rootScope.login ='';
		$http.get('http://localhost:8080/logout')
      	$window.location.reload();
	}

	$scope.login = function () {
		$scope.invalid = '';
		LoginService.storeUser(ctrl.user);
		$timeout(function(){
			$scope.invalid = "Utilisateur non Valide";
		},300);
	}
	
	$scope.changementContour = function(){
		if($rootScope.login){
			$scope.bonjour="Bonjour "+ $rootScope.login+" !" ;
			$('#boutonlogin').css('display','none');
			$('#formLogin').css('display','none');
			$('#boutonlogout').css('display','inline');
			$('.log').css('display','inline');
			$('.nonlog').css('display','none');
		}
		else{
			$scope.bonjour='';
			$('#boutonlogin').css('display','inline');
			$('#formLogin').css('display','block');
			$('#boutonlogout').css('display','none');
			$('.log').css('display','none');
			$('.nonlog').css('display','inline');
		}
	}

	$scope.collectLivre = function(){
		$rootScope.type = 0;
		$location.path('/recherche');
		$timeout(function(){
			$location.path('/collection');
		}, 0);
		$('#divlogin').slideUp();
		$('#sideMenu').slideUp();
		setTimeout(function(){
			document.getElementById("idsidenav").style.width = "0";
			document.getElementById("boutonside").style.marginLeft= "0";
		}, 400)
	}

	$scope.collectCd = function(){
		$rootScope.type = 1;
		$location.path('/recherche');
		$timeout(function(){
			$location.path('/collection');
		}, 0);
		$('#divlogin').slideUp();
		$('#sideMenu').slideUp();
		setTimeout(function(){
			document.getElementById("idsidenav").style.width = "0";
			document.getElementById("boutonside").style.marginLeft= "0";
		}, 400)
	}


	$scope.collectDvd = function(){
		$rootScope.type = 2;
		$location.path('/recherche');
		$timeout(function(){
			$location.path('/collection');
		}, 0);
		$('#divlogin').slideUp();
		$('#sideMenu').slideUp();
		setTimeout(function(){
			document.getElementById("idsidenav").style.width = "0";
			document.getElementById("boutonside").style.marginLeft= "0";
		}, 400)
	}

	$scope.openNav = function() {
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
		
		if($rootScope.login)
			$('.portable').css("display","run-in");
		else
			$('.portable').css("display","none");
	    if(yOffset < currYOffSet) {
			myNavBar.add();
			$('#boutonside').css("color","white");
			$('.portable').css("color","white");
			$('.portable').css("padding-top","23px");
	    }
	    else if(currYOffSet == yOffset){
			myNavBar.remove();
			$('#boutonside').css("color","black");
			$('.portable').css("color","black");
			$('.portable').css("padding-top","0px");
	    }

	}
	window.onscroll = function(e) {
	    offSetManager();
	}
	
}]);
