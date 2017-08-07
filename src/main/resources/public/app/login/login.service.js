(function() {
    'use strict';

    angular
        .module('mediatic')
        .service('LoginService', LoginService);

    LoginService.$inject = [];
    function LoginService() {
        this.exposedFn = exposedFn;
        
        ////////////////

        function exposedFn() { }
        }
})();