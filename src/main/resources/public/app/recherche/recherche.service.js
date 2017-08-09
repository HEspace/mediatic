'user strict';

angular.module('mediatic.recherche')
.service('RechercheService', ['$http','$window', '$timeout',function($http,$window,$timeout){
    this.getData = function(){
       return $http.get('donnees.json')
    }

    this.recherche = function(chaine){
        $timeout(function(){
             scope.textSearch = chaine;
		},0);
    }
    var scope={};

    this.prendMonCtrl = function(scopeS){
         scope  = scopeS;
    }

    this.ajoutEmprunt = function(form){
            $http({
                method: 'POST',
                url: 'http://localhost:3000/emprunt',
                data: form
            }).then(function successCallback(response) {
                $window.location.reload();
                // this callback will be called asynchronously
                // when the response is available
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
        }

}]);

