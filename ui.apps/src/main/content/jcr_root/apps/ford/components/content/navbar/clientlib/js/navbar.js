document.addEventListener('DOMContentLoaded', function () {
  // Search dropdown logic
  const searchIcon = document.getElementById('searchIcon');
  const searchInput = document.getElementById('searchInput');
  
  if (searchIcon && searchInput) {
    searchIcon.addEventListener('click', function (e) {
      e.preventDefault();
      searchInput.classList.add('show');
      searchIcon.classList.add('hide');
      searchInput.focus();
    });
  
    document.addEventListener('click', function (e) {
      if (e.target !== searchInput && e.target !== searchIcon && !searchIcon.contains(e.target)) {
        searchInput.classList.remove('show');
        searchIcon.classList.remove('hide');
        searchInput.value = '';
      }
    });
  
    document.addEventListener('keydown', function (e) {
      if (e.key === 'Escape') {
        searchInput.classList.remove('show');
        searchIcon.classList.remove('hide');
        searchInput.value = '';
      }
    });
  }


  

  // User dropdown logic
  const userToggle = document.getElementById('userToggle');
  const userMenu = document.getElementById('userMenu');

  if (userToggle && userMenu) {
    userToggle.addEventListener('click', function (e) {
      e.preventDefault();
      userMenu.classList.toggle('show');
    });

    document.addEventListener('click', function (e) {
      if (!userToggle.contains(e.target) && !userMenu.contains(e.target)) {
        userMenu.classList.remove('show');
      }
    });
  }

// User globe logic
const globeToggle = document.getElementById('globeToggle');
const globeMenu = document.getElementById('globeMenu');

if (globeToggle && globeMenu) {
  globeToggle.addEventListener('click', function (e) {
    e.preventDefault();
    globeMenu.classList.toggle('show');
  });

  document.addEventListener('click', function (e) {
    if (!globeToggle.contains(e.target) && !globeMenu.contains(e.target)) {
      globeMenu.classList.remove('show');
    }
  });
}




const shopToggle=document.getElementById('shopToggle');
const shopMenu=document.getElementById('shopMenu');

if(shopToggle&&shopMenu)
{
  shopToggle.addEventListener('click',function(e){
    e.preventDefault();
    shopMenu.classList.toggle('show');
  });
  document.addEventListener('click',function(e){
    if(!shopToggle.contains(e.target)&&!shopMenu.contains(e.target))
    {
      shopMenu.classList.remove('show');
    }
  });
}

const supportToggle=document.getElementById('supportToggle');
const supportMenu=document.getElementById('supportMenu');

      supportToggle.addEventListener('click',function(e){
        e.preventDefault();
        supportMenu.classList.toggle('show');
      });
      document.addEventListener('click',function(e){
        if(!supportToggle.contains(e.target)&&!supportMenu.contains(e.target))
        {
          supportMenu.classList.remove('show');
        }
      });


});
