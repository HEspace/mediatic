(function() {
    'use strict';

    angular
        .module('mediatic.login', ['ngRoute'])
        .controller('LoginCtrl', loginCtrl);

    loginCtrl.$inject = [];
    function loginCtrl() {
        var vm = this;
        

        activate();

        ////////////////

        function activate() { }
    }
})();