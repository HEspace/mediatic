'adherent strict';

angular.module('mediatic.recherche')
    .service('RechercheService', ['$http', '$window', '$timeout', function ($http, $window, $timeout) {

        this.getData = function () {
            return $http.get('http://localhost:8080/api/media/find')
        }

        this.getDataById = function (id) {
            return $http.get('http://localhost:8080/api/media/find/id/' + id)
        }

        this.getDataByWordAndType = function (chaine, type) {
            if (chaine == undefined || chaine == "")
                return $http.get('http://localhost:8080/api/media/find')
            if (type == "")
                return $http.get('http://localhost:8080/api/media//find/chaine/' + chaine)
            else
                return $http.get('http://localhost:8080/api/media//find/chaine/' + chaine + type)
        }

        this.getAdh = function () {
            return $http.get('http://localhost:8080/api/adherent/find')

        }

         this.getResultAdhById = function (id) {
             console.log($http.get('http://localhost:8080/api/adherent/find/id/' + id))
            return $http.get('http://localhost:8080/api/adherent/find/id/' + id)

        }

        this.getAdhById = function (id) {
            return $http.get('http://localhost:8080/api/adherent/findOne/id/' + id)

        }

        this.getAdhByNom = function (chaine) {
            console.log($http.get('http://localhost:8080/api/adherent/find/chaine/' + chaine))
              return $http.get('http://localhost:8080/api/adherent/find/chaine/' + chaine)
        }



        this.getEmpruntByAdh = function (id) {
            return $http.get('http://localhost:8080/api/emprunt/adherent/' + id)
        }

        this.getEmpruntByMedia = function (id) {

            return $http.get('http://localhost:8080/api/emprunt/media/' + id)
        }

        this.getEmprunt = function () {
            return $http.get('http://localhost:8080/api/emprunt')
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

