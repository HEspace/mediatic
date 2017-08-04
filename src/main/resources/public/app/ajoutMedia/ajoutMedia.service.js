(function() {
    'use strict';

    angular
        .module('mediatic')
        .service('MediaService', MediaService);

    MediaService.$inject = ['$http'];
    function MediaService($http) {
        this.exposedFn = exposedFn;
        
        this.ajoutMedia = function(form){
            $http({
                method: 'POST',
                url: 'http://localhost:3000/media',
                data: form
            }).then(function successCallback(response) {
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