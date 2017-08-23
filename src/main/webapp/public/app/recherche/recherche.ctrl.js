'use strict';

angular.module('mediatic.recherche', ['ngRoute'])

    .controller('RechercheCtrl', ['$scope', '$location', 'RechercheService', '$rootScope', '$filter', function
    ($scope, $location, RechercheService, $rootScope, $filter) {

        $scope.textSearch;
        $scope.pageU = "adherent";
        $scope.pageF = "file";
        $scope.m = "m";
        $scope.a = "a";
        $scope.formEmprunt = {};
        $scope.myOrder = 'titre';
        $scope.reverse = false;
        $scope.emprunte = [];
        $scope.radioBox = { 'selected': "nom" };
        $scope.checkBox = {
            'book': false,
            'music': false,
            'film': false
        }

        RechercheService.prendMonCtrl($scope);

        if (!$rootScope.login)
            $location.path("/accueil")


        $('#sel').on('changed.bs.select', function () {
            $(".divHiddenMedia").hide();
            $(".divHiddenadherent").hide();
            var index = document.getElementById("sel").selectedIndex;
            var options = document.getElementById("sel").options;

            if (options[index].text == "Médias") {
                console.log($('#sel').selectpicker().val())
                $("#radioAdhe").hide();
                $("#checkMedia").fadeIn();
                $("#tabAdherent").hide();
                $("#tabMedia").fadeIn();
            } else {
                console.log($('#sel').selectpicker().val())
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
            if (type == "m") {
                RechercheService.getData().then(function (res) {
                    res.data.forEach(function (elem) {
                        if (elem.id == id) {

                            $rootScope.form.media.id = elem.id
                            $rootScope.form.media.auteur = elem.auteur
                            $rootScope.form.media.titre = elem.titre
                            $rootScope.form.media.type = elem.type
                        }
                    })
                    $location.path('/ajoutMedia');

                })
            } else {
                RechercheService.getAdhById(id).then(function (res) {
                    res.data.forEach(function (elem) {
                        if (elem.id == id) {
                            $rootScope.form.adherent.nom = elem.nom;
                            $rootScope.form.adherent.prenom = elem.prenom;
                            var tmp = elem.dateNaissance.split("/");
                            $rootScope.form.adherent.dateNaissance = new Date(tmp[0], tmp[1] - 1, tmp[2]);
                            $rootScope.form.adherent.age = elem.age;
                            $rootScope.form.adherent.email = elem.email;
                            tmp = elem.dateCotisation.split("/");
                            $rootScope.form.adherent.dateCotisation = new Date(tmp[0], tmp[1] - 1, tmp[2]);
                            $rootScope.form.adherent.montantCotisation = elem.montantCotisation;
                            $rootScope.form.adherent.dateFinCotisation = elem.dateFinCotisation;
                            $rootScope.form.adherent.rue = elem.rue;
                            $rootScope.form.adherent.codePostale = elem.codePostale;
                            $rootScope.form.adherent.ville = elem.ville;
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
            $scope.donnees.forEach(function (element) {
                if (element.type == "LIVRE")
                    element.type = "book"
                else if (element.type == "CD")
                    element.type = "music"
                else
                    element.type = "film"
            })

        })

        RechercheService.getAdh().then(function (res) {
            $scope.adh = res.data
        })

        $scope.hideTr = function () {
            $('.collapse').collapse("hide");
            if ($('#sel').selectpicker().val() == "m") {
                $scope.emprunte = [];
                /* $(".divHiddenMedia").toggle({ effect: "scale", direction: "horizontal" }); */
                $(".divHiddenMedia").animate({ height: "toggle" }, 100);


            } else {
                $scope.emprunte = [];
                /* $(".divHiddenadherent").toggle({ effect: "scale", direction: "horizontal" }); */
                $(".divHiddenadherent").animate({ height: "toggle" }, 100);
            }
            $("div#globalDiv").removeClass("blur");
        }


        /*    RechercheService.getEmprunt().then(function (res) {
               $scope.emp = res.data
           }) */


        $scope.showTr = function (id) {
            if ($('#sel').selectpicker().val() == "m") {

                RechercheService.getData().then(function (res) {

                    res.data.forEach(function (element) {
                        if (element.id == id) {
                            $scope.media = element;
                            /* $scope.formEmprunt.media = element; */
                            if ($scope.media.type == "LIVRE")
                                $scope.typeMedia = "book"
                            else if ($scope.media.type == "CD")
                                $scope.typeMedia = "music"
                            else
                                $scope.typeMedia = "film"

                            RechercheService.getEmprunt().then(function (res) {
                                res.data.forEach(function (e) {
                                    if (e.media_id == element.id) {
                                        RechercheService.getData().forEach(function (elem) {
                                            if (elem.id == e.adherent_id)
                                                $scope.emprunte.push(elem);
                                        })

                                    }

                                })
                            })

                        }
                    })

                })

                /* $(".divHiddenMedia").toggle({ effect: "scale", direction: "horizontal" }); */
                $(".divHiddenMedia").animate({ height: "toggle" }, 300);
            } else {
                RechercheService.getAdh().then(function (res) {
                    res.data.forEach(function (adhe) {
                        if (adhe.id == id) {
                            $scope.adherent = adhe
                            /* $scope.formEmprunt.adherent = element */
                            RechercheService.getEmpruntByAdh(adhe.id).then(function (result) {
                                console.log(result.data)
                                result.data.forEach(function (elem) {
                                    $scope.emprunte.push(elem.media);
                                })


                            })

                        }
                    })

                })

                /*  $(".divHiddenadherent").toggle({ effect: "scale", direction: "horizontal" }); */
                $(".divHiddenadherent").animate({ height: "toggle" }, 300);

            }
            /*  $("body").css({ "height" : ($(window).height() - 1) + 'px',  "overflow-y":"scroll"}); */
            $("div#globalDiv").addClass("blur");
        }

        $scope.envoi = function (ad) {
            var EDate = $filter('date')($scope.date, 'yyyy-MM-dd')
            $scope.formEmprunt.date = EDate;
            $scope.formEmprunt.adherent = ad;
            RechercheService.ajoutEmprunt($scope.formEmprunt);

        }


        $("#tabAdherent").hide();


        $scope.orderByMe = function (order) {

            $scope.reverse = ($scope.myOrder === order) ? !$scope.reverse : true;
            $scope.myOrder = order;
        }


    }]);    