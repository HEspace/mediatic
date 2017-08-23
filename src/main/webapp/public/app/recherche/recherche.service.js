'adherent strict';

angular.module('mediatic.recherche')
    .service('RechercheService', ['$http', '$window', '$timeout', function ($http, $window, $timeout) {
        this.getData = function () {
            return $http.get('http://localhost:8080/api/media/find')
        }

        this.getAdh = function () {
            return $http.get('http://localhost:8080/api/adherent/find')

        }
        this.getEmprunt = function () {
            return $http.get('http://localhost:8080/api/emprunt/find')
        }

        this.recherche = function (chaine) {
            $timeout(function () {
                scope.textSearch = chaine;
            }, 0);
        }
        var scope = {};

        this.prendMonCtrl = function (scopeS) {
            scope = scopeS;
        }


        this.ajoutEmprunt = function (form) {
            if(form.media.type == 'book')
                form.media.type = 'LIVRE';
            if(form.media.type == 'film')
                form.media.type = 'DVD';
            if(form.media.type == 'music')
                form.media.type = 'CD';
            form.dateEmprunt = form.date;
            delete form.date;
            $http({
                method: 'POST',
                url: 'http://localhost:8080/api/emprunt/create',
                data: form
            }).then(function successCallback(response) {
                $window.location.reload();
                // this callback will be called asynchronously
                // when the response is available
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
        }

    }]);

