'use strict';

angular.module('mediatic.ajoutAdherent', ['ngRoute'])


.controller('AjoutAdherentCtrl', ['$scope', '$location',function($scope, $location) {

  console.log($location.path());

   $scope.submit = function(){
    $location.path('../accueil/accueil.html');
    }

    /* $scope.dateNaissance = new Date("01/01/2000"); */
    /* $scope.age = 0; */

// Retourne l'age qui est envoyé dans le input Age
    $scope.$watch('dateNaissance',function(newValue, oldvalue){
      var date = new Date(newValue);
      $scope.age = calculate_age(date.getMonth(),date.getDay(),date.getFullYear());
      console.log(date);
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

$scope.$watch('dateCotisation',function(newValue, oldvalue){
      var date = new Date(newValue);
      var year = date.getFullYear();
      var month = date.getMonth();
      var day = date.getDate();
      var datePlusUnAn = new Date(year + 1, month, day)
      $scope.dateFinCotisation = datePlusUnAn;
      console.log("La date + 1 an est : "+parseInt(datePlusUnAn));
    });




  
/* 
    var temps = (new Date()).getTime()-date.getTime();
    console.log(typeof(temps), temps);
    var temps2 = (temps/3600/24/365).toFixed(0);
    console.log(typeof(temps2), temps2); */
}]);