(function() {
    'use strict';

    angular
        .module('mediatic')
        .service('MediaService', MediaService);

    MediaService.$inject = ['$http','$window', '$location'];
    function MediaService($http, $window, $location) {
        this.exposedFn = exposedFn;
        
        this.ajoutMedia = function(form){
            if (form.type == "book")
                form.type = "LIVRE";
            if (form.type == "media")
                form.type = "CD";
            if (form.type == "film")
                form.type = "DVD";
            $http({
                method: 'POST',
                url: 'http://localhost:8080/api/media',
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