'adherent strict';

angular.module('mediatic.recherche')
    .service('RechercheService', ['$http', '$window', '$timeout', function ($http, $window, $timeout) {

        this.getData = function () {
            return $http.get('/api/media/find')
        }

        this.getDataById = function (id) {
            return $http.get('/api/media/find/id/' + id)
        }

        this.getDataByWordAndType = function (chaine, type) {
            if (chaine == undefined || chaine == "")
                return $http.get('/api/media/find')
            if (type == "")
                return $http.get('/api/media//find/chaine/' + chaine)
            else
                return $http.get('/api/media/find/chaine/' + chaine + type)
        }

        this.getAdh = function () {
            return $http.get('/api/adherent/find')

        }

         this.getResultAdh = function (chaine, type) {
             if(chaine == "" || chaine == undefined)
                return $http.get('/api/adherent/find')
            if(type == "nom" && chaine != "")
                return $http.get('/api/adherent/find/chaine/' + chaine)
            else
                return $http.get('/api/adherent/find/id/' + chaine)

        }

        this.getAdhById = function (id) {
            return $http.get('/api/adherent/findOne/id/' + id)

        }

        this.getAdhByNom = function (chaine) {
              
        }



        this.getEmpruntByAdh = function (id) {
            return $http.get('/api/emprunt/adherent/' + id)
        }

        this.getEmpruntByMedia = function (id) {

            return $http.get('/api/emprunt/media/' + id)
        }

        this.getEmprunt = function () {
            return $http.get('/api/emprunt')
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
            if (form.media.type == 'book')
                form.media.type = 'LIVRE';
            if (form.media.type == 'film')
                form.media.type = 'DVD';
            if (form.media.type == 'music')
                form.media.type = 'CD'; 
            $http({
                method: 'POST',
                url: '/api/emprunt/create',
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

