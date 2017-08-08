'use strict';

angular.module('mediatic.ajoutAdherent', ['ngRoute'])


.controller('AjoutAdherentCtrl', ['$scope', '$location', 'AdherentService','$filter', '$rootScope', function($scope, $location, AdherentService, $filter, $rootScope) {



  var ctrl = this;
    $scope.form={};
    if ($rootScope.form.adherent != {} )
        {
            $scope.form.nom = $rootScope.form.adherent.nom;
            $scope.form.prenom = $rootScope.form.adherent.prenom;
            $scope.dateNaissance = $rootScope.form.adherent.dateNaissance;
            $scope.form.age = $rootScope.form.adherent.age;
            $scope.form.email = $rootScope.form.adherent.email;
            $scope.dateCotisation = $rootScope.form.adherent.dateCotisation;
            $scope.form.montantCotisation = $rootScope.form.adherent.montantCotisation;
            $scope.dateFinCotisation = $rootScope.form.adherent.dateFinCotisation;
            $scope.form.rue = $rootScope.form.adherent.rue;
            $scope.form.codePostale = $rootScope.form.adherent.codePostale;
            $scope.form.ville = $rootScope.form.adherent.ville;
            $rootScope.form.adherent = {};
        }
    
	ctrl.envoi = function(){
        var dateDeNaissanceJson = $filter('date')($scope.dateNaissance, 'dd/MM/yyyy');
        $scope.form.dateNaissance = dateDeNaissanceJson;

        var dateDePaiementJson = $filter('date')($scope.dateCotisation, 'dd/MM/yyyy');
        $scope.form.dateCotisation = dateDePaiementJson;

        var dateDeFinAbonnementJson = $filter('date')($scope.dateFinCotisation, 'dd/MM/yyyy');
        $scope.form.dateFinCotisation = dateDeFinAbonnementJson;
        
        AdherentService.ajoutAdh($scope.form);
	}


    
// Retourne l'age qui est envoyé dans le input Age
    $scope.$watch('dateNaissance',function(newValue, oldvalue){
      var date = new Date(newValue);
      $scope.form.age = calculate_age(date.getMonth(),date.getDay(),date.getFullYear());
      
    });
   

function calculate_age(birth_month,birth_day,birth_year)
{
    var today_date = new Date();
    var today_year = today_date.getFullYear();
    var today_month = today_date.getMonth();
    var  today_day = today_date.getDate();
    var age = today_year - birth_year;
    if ( today_month < (birth_month - 1))
    {
        age--;
    }
    if (((birth_month - 1) == today_month) && (today_day < birth_day))
    {
        age--;
    }
    return age;
}

// Retourne la date de fin d'abonnement en fonction de la date de paiement de la cotisation
$scope.form.date
$scope.$watch('dateCotisation',function(newValue, oldvalue){
      var date = new Date(newValue);
      var year = date.getFullYear();
      var month = date.getMonth();
      var day = date.getDate();
      var datePlusUnAn = new Date(year + 1, month, day)
      $scope.dateFinCotisation = datePlusUnAn;
    });

}]);