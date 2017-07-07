/**
 * 
 */


function openNav() {
    document.getElementById("idsidenav").style.width = "250px";
    document.getElementById("boutonside").style.marginLeft = "250px";
    $('#boutonside').css('display','none');
    setTimeout(function(){
    	$('#divlogin').slideDown();
    	$('#sideMenu').slideDown();
    }, 400)
}

function closeNav() {
    $('#divlogin').slideUp();
    $('#sideMenu').slideUp();
    setTimeout(function(){
    	document.getElementById("idsidenav").style.width = "0";
    	document.getElementById("boutonside").style.marginLeft= "0";
    	$('#boutonside').css('display','block');
    }, 400)
}

function inverserCollectionMenu(){
	if ($("#menuCollection").is(":visible")){
		$('#menuCollection').slideUp();
		
	}
	else
		$('#menuCollection').slideDown();
}

$(document).ready(function() {
	closeNav();
	$('#menuCollection').hide();
});

window.onresize = function() {
	closeNav();
}