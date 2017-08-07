'use strict';

angular.module('mediatic.recherche', ['ngRoute'])

    .controller('RechercheCtrl', ['$scope', '$location', 'RechercheService',function ($scope, $location, RechercheService) {

        $('#sel').on('changed.bs.select', function () {
            console.log($('#sel').selectpicker().val())
            var index = document.getElementById("sel").selectedIndex;
            var options = document.getElementById("sel").options;
            if (options[index].text == "Médias") {
                $("#radioAdhe").hide();
                $("#checkMedia").fadeIn();
                $("#tabAdherent").hide();
                $("#tabMedia").fadeIn();
            } else {
                console.log("adherent");
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

        $scope.textSearch;
        $scope.search = function () { }
        $scope.pageU = "user";
        $scope.pageF = "file";
        $scope.media = "m";
        $scope.adh = "a";
        $scope.changePage = function (e) {
            if (e == $scope.pageU)
                $location.path('/ajoutAdherent');
            else
                $location.path('/ajoutMedia');
        }

        $scope.show = function (e) {
            if ($('#sel').selectpicker().val() == e)
                return true;
            else
                return false;
        }

        RechercheService.getData().then(function(res){
            console.log(res.data)
            $scope.donnees = res.data;
          
            console.log($scope.donnees)
        })

        $scope.showTr = function(){
        /*    $scope.donnees.forEach(function(element) {
                if(element.data.media.id == id)
                    $scope.media= element.data.media   
           });
 */
            /* console.log(id) */
            if ($(".divHiddenMedia").is(":hidden")) {
                $(".divHiddenMedia").fadeIn("slow")
                /* $(".divHiddenMedia").slideDown("slow"); */
            } else {
                $(".divHiddenMedia").hide("slow")
                /* $(".divHiddenMedia").slideUp("fast"); */
            }
        }

        //drawTab();
        /* $("#radioAdhe").hide();*/
        $("#tabAdherent").hide();
        //$(".rowHidden").hide();
        //$("div.divHidden1").hide();

        $('.rowTab').click(function () {
            //console.log("test");
            if ($(".divHiddenMedia").is(":hidden")) {
                $(".trHiddenMedia").fadeIn("slow")
                $(".divHiddenMedia").slideDown("slow");
            } else {
                $(".trHiddenMedia").hide("fast")
                $(".divHiddenMedia").slideUp("fast");
            }

            if ($(".divHiddenUser").is(":hidden")) {
                $(".trHiddenUser").fadeIn("slow")
                $(".divHiddenUser").slideDown("slow");
            } else {
                $(".trHiddenUser").hide("fast")
                $(".divHiddenUser").slideUp("fast");
            }
        });



    }]);