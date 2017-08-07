'use strict';

angular.module('mediatic.recherche', ['ngRoute'])

    .controller('RechercheCtrl', ['$scope', '$location', 'RechercheService', '$rootScope', function ($scope, $location, RechercheService, $rootScope) {

        $scope.textSearch;
        $scope.pageU = "user";
        $scope.pageF = "file";
        $scope.m = "m";
        $scope.a = "a";
        $scope.formEmprunt = {};


        $('#sel').on('changed.bs.select', function () {
            $(".divHiddenMedia").hide();
            $(".divHiddenUser").hide();
            var index = document.getElementById("sel").selectedIndex;
            var options = document.getElementById("sel").options;
            if (options[index].text == "Médias") {
                $("#radioAdhe").hide();
                $("#checkMedia").fadeIn();
                $("#tabAdherent").hide();
                $("#tabMedia").fadeIn();
            } else {
                $("#checkMedia").hide();
                $("#radioAdhe").fadeIn();
                $("#tabAdherent").fadeIn();
                $("#tabMedia").hide();
            }
        })


        $('.selectpicker').selectpicker({
            style: 'btn-primary btn-lg',
            width: 'fit'
        });


        $scope.search = function () { }

        $scope.changePage = function (e) {
            if (e == $scope.pageU)
                $location.path('/ajoutAdherent');
            else {
                $location.path('/ajoutMedia');
            }
        }

        $scope.modifFiche = function (id, type) {
            if(type == "m"){
            RechercheService.getData().then(function (res) {
                res.data.media.forEach(function (elem) {
                    if (elem.id == id) {
                        $rootScope.form.media.auteur = elem.auteur
                        $rootScope.form.media.titre = elem.titre
                        $rootScope.form.media.type = elem.type
                    }
                })
                $location.path('/ajoutMedia');

            })
            }else{
                  RechercheService.getData().then(function (res) {
                res.data.adherent.forEach(function (elem) {
                    if (elem.id == id) {
                        $rootScope.form.media.auteur = elem.auteur
                        $rootScope.form.media.titre = elem.titre
                        $rootScope.form.media.type = elem.type
                    }
                })
                $location.path('/ajoutAdherent');

            })
            }

        }

        $scope.show = function (e) {
            if ($('#sel').selectpicker().val() == e)
                return true;
            else
                return false;
        }

        RechercheService.getData().then(function (res) {
            $scope.donnees = res.data;


        })

        $scope.hideTr = function () {
            if ($('#sel').selectpicker().val() == "m")
                $(".divHiddenMedia").toggle({ effect: "scale", direction: "horizontal" });
            else
                $(".divHiddenUser").toggle({ effect: "scale", direction: "horizontal" });
        }


        $scope.showTr = function (id) {
            if ($('#sel').selectpicker().val() == "m") {
                RechercheService.getData().then(function (res) {

                    res.data.media.forEach(function (element) {
                        if (element.id == id) {
                            $scope.media = element
                            if ($scope.media.type == "book")
                                $scope.type = "Livre"
                            else if ($scope.media.type == "music")
                                $scope.type = "CD"
                            else
                                $scope.type = "DVD"
                        }
                    })
                    $scope.formEmprunt.user = res.data.adherent[0].nom

                })

                $(".divHiddenMedia").toggle({ effect: "scale", direction: "horizontal" });
            } else {
                RechercheService.getData().then(function (res) {
                    res.data.adherent.forEach(function (element) {
                        if (element.id == id)
                            $scope.user = element
                    })

                })

                $(".divHiddenUser").toggle({ effect: "scale", direction: "horizontal" });

            }

        }

        $scope.envoi = function () {
            RechercheService.ajoutEmprunt($scope.formEmprunt);
        }

        $("#tabAdherent").hide();



    }]);