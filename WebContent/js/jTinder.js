/**
 * jTinder initialization
 *
 */

function loadTinder(){ 
$("#tinderslide").jTinder({
	// dislike callback
    onDislike: function (item) {
	    // set the status text

    	guardarLike(item[0].id);
    //    $('#status').append('<hr>' + item.text() + ' No');
   
        if (item.index() == 0) {
        	console.log('Se dio la condicion');
        	$('#tinderslide').hide();
        	$('.actions').hide();
        	
        	$("#wrap").hide();
        	
        	
        }
    },
	// like callback
    onLike: function (item) {
	    // set the status text
    	console.log(item[0].id);
  //  $('#status').append('<hr>' + item.text() + ' Si');
    
    	if (item.index() == 0) {
    		
    		console.log('Se dio la condicion');
        	$('#tinderslide').hide();
        	$('.actions').hide();
        	$("#wrap").hide();

        }

    },
	animationRevertSpeed: 200,
	animationSpeed: 400,
	threshold: 1,
	likeSelector: '.like',
	dislikeSelector: '.dislike'
});

/**
 * Set button action to trigger jTinder like & dislike.
 */
$('.actions .like, .actions .dislike').click(function(e){
	e.preventDefault();
	$("#tinderslide").jTinder($(this).attr('class'));
});

$("#logo").hide();
}