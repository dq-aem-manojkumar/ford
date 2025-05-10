document.addEventListener('DOMContentLoaded', function() {
    const wrappers = document.querySelectorAll('.ford-carousel-v2-wrapper');
  
    wrappers.forEach(wrapper => {
      const track = wrapper.querySelector('.ford-carousel-v2-track');
      const leftArrow = wrapper.querySelector('.v2-carousel-arrow.left');
      const rightArrow = wrapper.querySelector('.v2-carousel-arrow.right');
  
      let cards = track.children;
      const visibleCards = 2;  // Show 2 cards at a time
      let currentIndex = 0;
  
      const isAuthorMode = window.location.href.includes('editor.html');
  
      function reverseChildren(parent) {
        const children = Array.from(parent.children);
        for (let i = children.length - 1; i >= 0; i--) {
          parent.appendChild(children[i]);
        }
      }
  
      function updateCarousel() {
        cards = track.children;
        if (!isAuthorMode) {
          const cardWidth = cards[0].offsetWidth + 20;  // Adjust for spacing between cards
          const newTransform = -(currentIndex * cardWidth);
          track.style.transform = `translateX(${newTransform}px)`;
        } else {
          track.style.transform = `translateX(0px)`;
        }
      }
  
      if (!isAuthorMode) {
        rightArrow.addEventListener('click', () => {
          if (currentIndex < cards.length - visibleCards) {
            currentIndex += visibleCards;  // Move 2 cards at a time
            updateCarousel();
          }
        });
  
        leftArrow.addEventListener('click', () => {
          if (currentIndex > 0) {
            currentIndex -= visibleCards;  // Move 2 cards at a time
            updateCarousel();
          }
        });
      } else {
        leftArrow.style.display = 'none';
        rightArrow.style.display = 'none';
        reverseChildren(track);
      }
  
      window.addEventListener('resize', updateCarousel);
      updateCarousel();
    });
  });
  