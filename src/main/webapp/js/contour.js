/**
 * 
 */


function openNav() {
    document.getElementById("idsidenav").style.width = "250px";
    document.getElementById("boutonside").style.marginLeft = "250px";
    $('#boutonside').css('display','none');
    $('#divlogin').show('slow');
}

function closeNav() {
    document.getElementById("idsidenav").style.width = "0";
    document.getElementById("boutonside").style.marginLeft= "0";
    $('#boutonside').css('display','block');
    $('#divlogin').hide();
}

function inverserCollectionMenu(){
	if ($("#menuCollection").is(":visible"))
		$('#menuCollection').hide();
	else
		$('#menuCollection').show('slow');
}

$(document).ready(function() {
	closeNav();
	$('#menuCollection').hide();
});

window.onresize = function() {
	closeNav();
}