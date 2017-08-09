'use strict';

angular.module('mediatic.recherche', ['ngRoute'])

    .controller('RechercheCtrl', ['$scope', '$location', 'RechercheService', '$rootScope', '$filter', function
    ($scope, $location, RechercheService, $rootScope, $filter) {

        $scope.textSearch;
        $scope.pageU = "user";
        $scope.pageF = "file";
        $scope.m = "m";
        $scope.a = "a";
        $scope.formEmprunt = {};
        $scope.myOrder = 'titre';
        $scope.reverse = false;
        $scope.radioBox = {'selected': "nom" };
        $scope.checkBox = {
            'book': false,
            'music': false,
            'film': false
        }
        $scope.emprunte = [];


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
            if (type == "m") {
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
            } else {
                RechercheService.getData().then(function (res) {
                    res.data.adherent.forEach(function (elem) {
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
        })

        $scope.hideTr = function () {
            $('.collapse').collapse("hide");
            if ($('#sel').selectpicker().val() == "m") {
                $scope.emprunte = [];
                 /* $(".divHiddenMedia").toggle({ effect: "scale", direction: "horizontal" }); */ 
                 $(".divHiddenMedia").animate({height: "toggle"}, 100);
                 
               
            } else {
                $scope.emprunte = [];
                /* $(".divHiddenUser").toggle({ effect: "scale", direction: "horizontal" }); */
                $(".divHiddenUser").animate({height: "toggle"}, 100);
            }
            $("div#globalDiv").removeClass("blur");
        }


        $scope.showTr = function (id) {
            if ($('#sel').selectpicker().val() == "m") {
                RechercheService.getData().then(function (res) {

                    res.data.media.forEach(function (element) {
                        if (element.id == id) {
                            $scope.media = element;
                            $scope.formEmprunt.media = element;
                            if ($scope.media.type == "book")
                                $scope.type = "Livre"
                            else if ($scope.media.type == "music")
                                $scope.type = "CD"
                            else
                                $scope.type = "DVD"
                            
                            res.data.emprunt.forEach(function (e) {
                                if(e.media.id == element.id){
                                    $scope.emprunte.push(e.user);
                                }
                                                                  
                            })
                            
                        }
                    })

                })

                /* $(".divHiddenMedia").toggle({ effect: "scale", direction: "horizontal" }); */
                 $(".divHiddenMedia").animate({height: "toggle"}, 300);
            } else {
                RechercheService.getData().then(function (res) {
                    res.data.adherent.forEach(function (element) {
                        if (element.id == id) {
                            $scope.user = element
                            $scope.formEmprunt.user = element

                            res.data.emprunt.forEach(function (e) {
                                if(e.user.id == element.id){
                                    $scope.emprunte.push(e.media);
                                }
                                                                  
                            })
                        }
                    })

                })

               /*  $(".divHiddenUser").toggle({ effect: "scale", direction: "horizontal" }); */
                $(".divHiddenUser").animate({height: "toggle"}, 300);

            }
            /*  $("body").css({ "height" : ($(window).height() - 1) + 'px',  "overflow-y":"scroll"}); */
            $("div#globalDiv").addClass("blur");
        }

        $scope.envoi = function () {
            var EDate = $filter('date')($scope.date, 'dd-MM-yyyy')
            $scope.formEmprunt.date = EDate;
            RechercheService.ajoutEmprunt($scope.formEmprunt);

        }


        $("#tabAdherent").hide();


        $scope.orderByMe = function(order){
            
            $scope.reverse = ($scope.myOrder === order) ? !$scope.reverse : true;
            $scope.myOrder = order;
        }


    }]);    