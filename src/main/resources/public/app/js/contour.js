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
	$('#menuCollection').hide();
	$('#divlogin').slideUp();
    $('#sideMenu').slideUp();
});

window.onresize = function() {
}

window.addEventListener('resize', function(event){
	if (window.innerWidth > 768)
		//console.log(window.innerWidth);
		$('#boutonside').css('display','none');
	else
		$('#boutonside').css('display','block');
});
	  
$(document).ready(function(){
	if (window.innerWidth > 768)
		$('#boutonside').css('display','none');
	else
		$('#boutonside').css('display','block');
});

function foo(x){
	function bar(x){
		console.log("J :",i)
	}
	var i = 2;
	bar(5);
}

console.log(foo(3));
/**
 * Import du code
 */
$(document).ready(function(){
	var myNavBar = {
	    flagAdd: true,
	    elements: [],
	    init: function (elements) {
	        this.elements = elements;
	    },
	    add : function() {
	        if(this.flagAdd) {
	            for(var i=0; i < this.elements.length; i++) {
	                document.getElementById(this.elements[i]).className += " fixed-theme";
	            }
	            this.flagAdd = false;
	        }
	    },
	    remove: function() {
	        for(var i=0; i < this.elements.length; i++) {
	            document.getElementById(this.elements[i]).className =
	                    document.getElementById(this.elements[i]).className.replace( /(?:^|\s)fixed-theme(?!\S)/g , '' );
	        }
	        this.flagAdd = true;
	    }
	};
	myNavBar.init(  [
	    "header",
	    "header-container",
	    "brand"
	]);
	function offSetManager(){

	    var yOffset = 0;
	    var currYOffSet = window.pageYOffset;

	    if(yOffset < currYOffSet) {
	        myNavBar.add();
	    }
	    else if(currYOffSet == yOffset){
	        myNavBar.remove();
	    }

	}
	window.onscroll = function(e) {
	    offSetManager();
	}
	offSetManager();
});

$(document).ready(function() {
	  $('#boutonlogin').click(function() {
	    $('.wrap').slideToggle(400);
	  });
	});