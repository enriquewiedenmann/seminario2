/**
 * jTinder initialization
 */
$("#tinderslide").jTinder({
	// dislike callback
    onDislike: function (item) {
	    // set the status text
       // $('#status').html('Dislike image ' + (item.index()+1));

        console.log(item);
        console.log(item.index());
        console.log(item.text());

        $('#status').append('<hr>' + item.text() + ' No');
   
        if (item.index() == 0) {
        	console.log('Se dio la condicion');
        	$('.wrap').hide();
        	$('.actions').hide();
        }
    },
	// like callback
    onLike: function (item) {
	    // set the status text
       // $('#status').html('Like image ' + (item.index()+1));
    $('#status').append('<hr>' + item.text() + ' Si');
    
if (item.index() == 0) {
        	console.log('Se dio la condicion');
        	$('.wrap').hide();
        	$('.actions').hide();
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