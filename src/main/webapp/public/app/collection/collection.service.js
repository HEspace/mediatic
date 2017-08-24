(function() {
    'use strict';

    angular
        .module('mediatic')
        .service('CollectionService', CollectionService);

    CollectionService.$inject = ['$http','$window', '$location'];
    function CollectionService($http, $window, $location) {
        this.exposedFn = exposedFn;

        this.recup = function(chaine){
            return $http.get(chaine);
        }


        ////////////////

        function exposedFn() { }
        }
})();