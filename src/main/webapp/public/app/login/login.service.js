(function() {
    'use strict';

    angular
        .module('mediatic')
        .factory('LoginService', LoginService)
        .run(function (LoginService) {
            LoginService.addAuthorization();
        });


    LoginService.$inject = ['$window', '$localStorage', '$rootScope', '$http'];
    function LoginService($window, $localStorage, $rootScope, $http) {

        var service = {
            storeUser: storeUser,
            addAuthorization: addAuthorization
        };

        return service;

        function storeUser(user) {
            var message = $http({
                method: 'GET',
                url: 'http://localhost:8080/private/login/'+user.login+'/'+user.password,
            }).then(function successCallback(response) {
                if(response.data==""){
                    $window.location.reload();
                }
                else{
                    $localStorage.$reset();
                    $localStorage.$default(user);
                    $rootScope.login = $localStorage.$default().login;
                    addAuthorization();
                    $window.location.reload();
                }
                // this callback will be called asynchronously
                // when the response is available
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
        }

        function addAuthorization() {
            $rootScope.login = $localStorage.$default().login;
            var password = $localStorage.$default().password;
            if ($rootScope.login && password) {
                var token = btoa($rootScope.login + ':' + password);
                $http.defaults.headers.common.Authorization = 'Basic ' + token
            }
        }




        this.exposedFn = exposedFn;
        
        ////////////////

        function exposedFn() { }
        }
})();