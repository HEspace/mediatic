(function() {
    'use strict';

    angular
        .module('mediatic.collection', ['ngRoute' , 'ui.grid'])
        .controller('CollectionCtrl', CollectionCtrl);

    CollectionCtrl.$inject = ['$scope', '$rootScope', 'CollectionService','$timeout'];
    function CollectionCtrl($scope, $rootScope, CollectionService, $timeout) {
        var ctrl = this;
        var url ='';
        
        if($rootScope.type == 0){
            ctrl.titre = 'Collection de Livres';
            url = 'http://localhost:8080/api/media/type/livre';
        }
        else if($rootScope.type == 1){
            ctrl.titre = 'Collection de CD';
            url = 'http://localhost:8080/api/media/type/cd';
        }
        else if($rootScope.type == 2){
            ctrl.titre = 'Collection de DVD';
            url = 'http://localhost:8080/api/media/type/dvd';
        }

        
        
        CollectionService.recup(url).then(function successCallback(res){
            $scope.tab = res.data;

            $scope.tab.forEach(function(e) {
                delete e.type;
            }, this);

            ctrl.apresRecup();
        });
        

        ctrl.apresRecup = function(){
            $scope.gridOptions = { 
                data: 'tab',
                enableSorting: true,
                showGroupPanel: true,
                jqueryUIDraggable: true
            };
        }

        activate();

        ////////////////

        function activate() { }
    }
})();