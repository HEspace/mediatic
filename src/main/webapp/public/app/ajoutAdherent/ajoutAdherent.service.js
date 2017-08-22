(function() {
    'use strict';

    angular
        .module('mediatic')
        .service('AdherentService', AdherentService);

    AdherentService.$inject = ['$http','$window','$location'];
    function AdherentService($http, $window, $location) {
        this.exposedFn = exposedFn;
        
        this.ajoutAdh = function(form){
            $http({
                method: 'POST',
                url: 'http://localhost:8080/api/adherent',
                data: form
            }).then(function successCallback(response) {
                $location.path("/recherche");
                // this callback will be called asynchronously
                // when the response is available
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
        }
        ////////////////

        function exposedFn() { }
        }
})();