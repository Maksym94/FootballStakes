/**
 * 
 */
function show_hide_no_img(id)
{
        var klappText = document.getElementById('s' + id);
        var klappBild = document.getElementById('pic' + id);

        if (klappText.style.display == 'none') {
                  klappText.style.display = 'block';
                  // klappBild.src = 'images/blank.gif';
        }
        else {
                  klappText.style.display = 'none';
                  // klappBild.src = 'images/blank.gif';
        }
}

function show_hide(id)
{
        var klappText = document.getElementById('s' + id);
        var klappBild = document.getElementById('pic' + id);
		
        if (klappText.style.display == 'none') {
                  klappText.style.display = 'block';
                  klappBild.src = '/FootballStakes/resources/pictures/minus.gif';
				  if(klappBild.id == 'picstickedtor'){
				  klappBild.src = 'pic/hide_stickbox.png';
				  }
                  klappBild.title = 'Hide';
        } else {
                  klappText.style.display = 'none';
                  klappBild.src = '/FootballStakes/resources/pictures/plus.gif';
				  if(klappBild.id == 'picstickedtor'){
				  klappBild.src = 'pic/show_stickbox.png';
				  }
                  klappBild.title = 'Show';
        }
}

