(function() {
    'use strict';

    angular
        .module('mediatic.collection', ['ngRoute'])
        .controller('CollectionCtrl', CollectionCtrl);

    CollectionCtrl.$inject = ['$scope', '$rootScope', 'CollectionService','$timeout'];
    function CollectionCtrl($scope, $rootScope, CollectionService, $timeout) {
        var ctrl = this;
        var url ='';
        
        if($rootScope.type == 0){
            ctrl.titre = 'Collection de Livres';
            url = '/api/media/type/livre';
        }
        else if($rootScope.type == 1){
            ctrl.titre = 'Collection de CD';
            url = '/api/media/type/cd';
        }
        else if($rootScope.type == 2){
            ctrl.titre = 'Collection de DVD';
            url = '/api/media/type/dvd';
        }
        
        CollectionService.recup(url).then(function successCallback(res){
            $scope.tab = res.data;

            $scope.tab.forEach(function(e) {
                delete e.type;
            }, this);

        });
        
        activate();

        ////////////////

        function activate() { }
    }
})();