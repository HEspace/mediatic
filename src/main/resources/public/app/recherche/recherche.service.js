'user strict';

angular.module('mediatic.recherche')
.service('RechercheService', ['$http',function($http){
    this.getData = function(){
        console.log($http.get('donnees.json'))
       return $http.get('donnees.json')
    }
}]);