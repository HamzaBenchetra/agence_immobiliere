(function($){
  $(function(){
       $('select').material_select();
       $('.dropdown-button').dropdown({
      inDuration: 300,
      outDuration: 225,
      constrainWidth: true, // Does not change width of dropdown to that of the activator
      hover: true, // Activate on hover
      gutter: 0, // Spacing from edge
      belowOrigin: false, // Displays dropdown below the button
      alignment: 'left', // Displays dropdown with edge aligned to the left of button
      stopPropagation: false // Stops event propagation
    }
  );
        $('.dropdown-button').dropdown('open');
        $('.dropdown-button').dropdown('close');
        $('.collapsible').collapsible();

    $('.button-collapse').sideNav();
    $('.parallax').parallax();
   $('input#card_number, textarea#adress').characterCounter();
  }); // end of document ready
})(jQuery); // end of jQuery name space