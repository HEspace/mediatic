'use strict';

angular.module('mediatic.recherche', ['ngRoute'])

    .controller('RechercheCtrl', ['$scope', '$location', 'RechercheService', '$rootScope', '$filter', '$timeout', function
    ($scope, $location, RechercheService, $rootScope, $filter, $timeout) {
        $("#buttonFile").hide();
        $("#buttonadherent").hide();
        $("#media").hide();
        $("#admin").hide();
        $scope.empruntBtn = 'Ajout Emprunt';
        $scope.textSearch;
        $scope.pageU = "adherent";
        $scope.pageF = "file";
        $scope.m = "m";
        $scope.a = "a";
        $scope.formEmprunt = {};
        $scope.myOrder = 'titre';
        $scope.reverse = false;
        $scope.cotisation = false;
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

        if ($rootScope.droit > 1) {
            $("#media").fadeIn();
            $("#buttonFile").fadeIn();
        }
        if ($rootScope.droit > 2) {
            $("#admin").fadeIn();
            $("#buttonadherent").fadeIn();
        }


        $('#sel').on('changed.bs.select', function () {
            $(".divHiddenMedia").hide();
            $(".divHiddenadherent").hide();
            var index = document.getElementById("sel").selectedIndex;
            var options = document.getElementById("sel").options;

            if (options[index].text == "Médias") {
                $scope.majMed();
                $("#radioAdhe").hide();
                $("#checkMedia").fadeIn();
                $("#tabAdherent").hide();
                $("#tabMedia").fadeIn();
            } else {
                $scope.majAdh();
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

                    $rootScope.form.adherent.id = id;
                    $rootScope.form.adherent.nom = res.data.nom;
                    $rootScope.form.adherent.prenom = res.data.prenom;
                    var tmp = res.data.dateNaissance.split("-");
                    $rootScope.form.adherent.dateNaissance = new Date(tmp[0], tmp[1] - 1, tmp[2]);
                    $rootScope.form.adherent.age = res.data.age;
                    $rootScope.form.adherent.email = res.data.email;
                    if (res.data.dateCotisation != null) {
                        tmp = res.data.dateCotisation.split("-");
                        $rootScope.form.adherent.dateCotisation = new Date(tmp[0], tmp[1] - 1, tmp[2]);
                    } else {
                        $rootScope.form.adherent.dateCotisation = undefined
                    }
                    $rootScope.form.adherent.montantCotisation = res.data.montantCotisation;
                    $rootScope.form.adherent.dateFinCotisation = res.data.dateFinCotisation;
                    $rootScope.form.adherent.rue = res.data.adress;
                    $rootScope.form.adherent.codePostale = res.data.cp;
                    $rootScope.form.adherent.ville = res.data.ville;
                    $rootScope.form.adherent.compteur = res.data.compteur;

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



        $scope.$watchGroup(['checkBox.book', 'checkBox.music', 'checkBox.film', 'textSearch', 'radioBox.selected'], function () {
            $scope.search();
        })


        $scope.search = function () {
            var typeCheck = "";
            if ($scope.checkBox['book'] == true)
                typeCheck += "/LIVRE"
            if ($scope.checkBox['music'] == true)
                typeCheck += "/CD"
            if ($scope.checkBox['film'] == true)
                typeCheck += "/DVD"
            if ($scope.checkBox['book'] == true && $scope.checkBox['music'] == true && $scope.checkBox['film'] == true)
                typeCheck = "";

            if ($('#sel').selectpicker().val() == "m") {
                RechercheService.getDataByWordAndType($scope.textSearch, typeCheck).then(function (res) {
                    $scope.donnees = res.data
                    $scope.donnees.forEach(function (element) {
                        if (element.type == "LIVRE")
                            element.type = "book"
                        else if (element.type == "CD")
                            element.type = "music"
                        else
                            element.type = "film"

                        $scope.ajoutEmprunterParEtDate(element);
                    })
                })

            } else {

                RechercheService.getResultAdh($scope.textSearch, $scope.radioBox.selected).then(function (res) {
                    $scope.adh = res.data
                    $scope.adh.forEach(function (elem) {
                        if (elem.dateCotisation != null) {
                            var d2 = new Date(elem.dateCotisation);
                            d2.setFullYear(d2.getFullYear() + 1)
                            if (d2.getTime() > Date.now())
                                elem.cotisation = true;
                        } else {
                            elem.cotisation = false;
                        }

                        RechercheService.getEmpruntByMedia(elem.id).then(function (result) {

                        })
                    })
                })


            }


        }

        $scope.majAdh = function () {
            RechercheService.getAdh().then(function (res) {
                $scope.adh = res.data
                $scope.adh.forEach(function (elem) {
                    if (elem.dateCotisation != null) {
                        var d2 = new Date(elem.dateCotisation);
                        d2.setFullYear(d2.getFullYear() + 1)
                        if (d2.getTime() > Date.now())
                            elem.cotisation = true;
                    } else {
                        elem.cotisation = false;
                    }

                })
            })
        }

        $scope.ajoutEmprunterParEtDate = function (element) {
            RechercheService.getEmpruntByMedia(element.id).then(function (result) {
                result.data.forEach(function (e) {
                    if (e.dateRetourEffective == null) {
                        element.emprunterPar = e.adherent.prenom + ' ' + e.adherent.nom;
                        element.retourPrevu = e.dateRetourPrevu;
                    }
                }, this);
            })
        }

        $scope.majMed = function () {
            RechercheService.getData().then(function (res) {
                $scope.donnees = res.data;
                $scope.donnees.forEach(function (element) {
                    if (element.type == "LIVRE")
                        element.type = "book"
                    else if (element.type == "CD")
                        element.type = "music"
                    else
                        element.type = "film"
                    $scope.ajoutEmprunterParEtDate(element)
                })
            })
        }
        $scope.majMed();
        $scope.majAdh();

        $scope.hideTr = function () {
            if ($("div#globalDiv").hasClass('blur')) {
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
        }



        /*    RechercheService.getEmprunt().then(function (res) {
               $scope.emp = res.data
           }) */


        $scope.showTr = function (id) {

            if ($('#sel').selectpicker().val() == "m") {

                RechercheService.getEmpruntByMedia(id).then(function (res) {
                    if (res.data.length != 0) {
                        res.data.forEach(function (element) {
                            if (element.dateRetourEffective == null)
                                $scope.empruntBtn = 'Media Restitué';
                            else
                                $scope.empruntBtn = 'Ajout Emprunt';
                        }, this);
                    }
                    else
                        $scope.empruntBtn = 'Ajout Emprunt';

                    if ($scope.empruntBtn == 'Ajout Emprunt') {
                        $('#restiOr').css('display', 'none');
                        $('#empruntOr').css('display', 'inline');
                    }
                    else {
                        $('#restiOr').css('display', 'inline');
                        $('#empruntOr').css('display', 'none');
                    }
                });
                var cpt = 0;
                var tabCpt = [];

                $scope.adh.forEach(function (elem) {
                    if (elem.dateCotisation != null) {
                        var tmp = elem.dateCotisation.split("-");
                        var dateCotisation = new Date(tmp[0], tmp[1] - 1, tmp[2]);
                        dateCotisation.setDate(dateCotisation.getDate() + 365);
                        var mnt = new Date();
                        if (mnt >= dateCotisation) {
                            tabCpt.push(cpt);
                        }
                    }
                    else {
                        tabCpt.push(cpt)
                    }
                    cpt++;
                });

                tabCpt.reverse();

                tabCpt.forEach(function (e) {
                    $scope.adh.splice(e, 1);
                });


                RechercheService.getDataById(id).then(function (res) {

                    $scope.media = res.data;
                    $scope.formEmprunt.media = res.data;
                    if ($scope.media.type == "LIVRE")
                        $scope.typeMedia = "book"
                    else if ($scope.media.type == "CD")
                        $scope.typeMedia = "music"
                    else
                        $scope.typeMedia = "film"

                    RechercheService.getEmpruntByMedia(res.data.id).then(function (res) {
                        res.data.forEach(function (e) {

                            $scope.emprunte.push(e.adherent)
                        })
                    })



                })

                /* $(".divHiddenMedia").toggle({ effect: "scale", direction: "horizontal" }); */
                $(".divHiddenMedia").animate({ height: "toggle" }, 300);
            } else {
                RechercheService.getAdhById(id).then(function (res) {
                    if (res.data.dateCotisation == null) {
                        $('#pasValid').css('display', 'none');
                    }
                    else {
                        var tmp = res.data.dateCotisation.split("-");
                        var dateCotisation = new Date(tmp[0], tmp[1] - 1, tmp[2]);
                        dateCotisation.setDate(dateCotisation.getDate() + 365);
                        var mnt = new Date();
                        if (mnt >= dateCotisation)
                            $('#pasValid').css('display', 'none');
                        else
                            $('#pasValid').css('display', 'inline');
                    }

                    var cpt = 0;
                    var tabCpt = [];
                    var tabId = [];

                    $scope.donnees.forEach(function (elem) {
                        RechercheService.getEmpruntByMedia(elem.id).then(function (res) {
                            res.data.forEach(function (element) {
                                if (element.dateRetourEffective == null) {
                                    tabId.push(element.media.id);
                                }
                            }, this);
                        })
                    });

                    $timeout(function () {
                        $scope.donnees.forEach(function (e) {
                            tabId.forEach(function (el) {
                                if (el == e.id)
                                    tabCpt.push(cpt);
                            }, this);
                            cpt++;
                        }, this);
                        tabCpt.reverse();
                        tabCpt.forEach(function (element) {
                            $scope.donnees.splice(element, 1);
                        }, this);
                    }, 0)

                    /* tabCpt.reverse();
                    tabCpt.forEach(function(e) {
                        $scope.donnees.splice(e,1);
                    }); */



                    $scope.adherent = res.data;
                    $scope.formEmprunt.adherent = res.data;

                    RechercheService.getEmpruntByAdh(res.data.id).then(function (result) {

                        result.data.forEach(function (e) {

                            $scope.emprunte.push(e.media);
                        })

                    })

                })

                /*  $(".divHiddenadherent").toggle({ effect: "scale", direction: "horizontal" }); */
                $(".divHiddenadherent").animate({ height: "toggle" }, 300);

            }
            /*  $("body").css({ "height" : ($(window).height() - 1) + 'px',  "overflow-y":"scroll"}); */
            $timeout(function () {
                $("div#globalDiv").addClass("blur");
            }, 100)

        }

        $scope.envoi = function () {
            if ($scope.empruntBtn == 'Ajout Emprunt') {
                var EDate = $filter('date')($scope.date, 'yyyy-MM-dd')
                $scope.formEmprunt.dateEmprunt = EDate;
                RechercheService.ajoutEmprunt($scope.formEmprunt);
            }
            else {
                RechercheService.getEmpruntByMedia($scope.formEmprunt.media.id).then(function (res) {
                    res.data.forEach(function (element) {
                        if (element.dateRetourEffective == null) {
                            element.dateRetourEffective = $filter('date')(new Date, 'yyyy-MM-dd');
                            RechercheService.ajoutEmprunt(element);
                        }
                    });
                });
            }

        }


        $("#tabAdherent").hide();


        $scope.orderByMe = function (order) {

            $scope.reverse = ($scope.myOrder === order) ? !$scope.reverse : true;
            $scope.myOrder = order;
        }

        $(document).ready(function(){
            $('div#globalDiv').on('click', function(){
                console.log("test")
                $scope.hideTr();
            });
        })

        $scope.search();
    }]);    