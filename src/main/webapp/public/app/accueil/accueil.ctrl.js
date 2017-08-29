'use strict';

angular.module('mediatic.accueil', ['ngRoute'])

.controller('AccueilCtrl', ['$scope', 'AccueilService', '$rootScope', function
($scope, AccueilService, $rootScope) {
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
    $scope.nonRendu = [];
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

    if ($rootScope.droit>0){
        $('#globalDiv').show();
        $('#mediaNonRendu').show();
    }
        




     $scope.recuperationNonRendu = function(element){
        AccueilService.getEmpruntByMedia(element.id).then(function (result){
            var date = new Date();
            result.data.forEach(function(e) {
                if (e.dateRetourEffective == null){
                    element.emprunterPar=  e.adherent.prenom+' '+e.adherent.nom;
                    element.retourPrevu = e.dateRetourPrevu;
                    var tmp = e.dateRetourPrevu.split("-");
                    var retourPrevu = new Date(tmp[0], tmp[1] - 1, tmp[2]);
                    if(retourPrevu < date){
                        $scope.nonRendu.push(element);
                    }
                }
            }, this);
        })
    }


    
    $scope.majMed = function(){
        AccueilService.getData().then(function(res){
            $scope.donnees = res.data;
            $scope.donnees.forEach(function (element) {
                if (element.type == "LIVRE")
                    element.type = "book"
                else if (element.type == "CD")
                    element.type = "music"
                else
                    element.type = "film"
                $scope.recuperationNonRendu(element)
            })
        })
    }

    if ($rootScope.droit>0)
    $scope.majMed();





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
            AccueilService.getDataByWordAndType($scope.textSearch, typeCheck).then(function (res) {
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
            
            AccueilService.getResultAdh($scope.textSearch, $scope.radioBox.selected).then(function (res) {
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

                        AccueilService.getEmpruntByMedia(elem.id).then(function (result) {

                        })
                    })
                })


        }


    }


    $scope.orderByMe = function (order) {
                    $scope.reverse = ($scope.myOrder === order) ? !$scope.reverse : true;
                    $scope.myOrder = order;
                }

    if($rootScope.droit>0)
        $scope.search();

}]);