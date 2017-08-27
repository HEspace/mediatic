'use strict';

angular.module('mediatic.accueil', ['ngRoute'])

.controller('AccueilCtrl', ['$scope', function($scope) {


    $scope.ajoutEmprunterParEtDate = function(element){
        RechercheService.getEmpruntByMedia(element.id).then(function (result) {
            result.data.forEach(function(e) {
                if(e.dateRetourEffective>e.dateRetourPrevu){
                    element.emprunterPar = e.adherent.prenom+' '+e.adherent.nom;
                    element.retourPrevu = e.dateRetourPrevu;
                }
            }, this);
        })
    }

}]);