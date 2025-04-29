document.addEventListener('DOMContentLoaded', function() {
    const wrappers = document.querySelectorAll('.ford-carousel-wrapper');

    wrappers.forEach(wrapper => {
        const track = wrapper.querySelector('.ford-carousel-track');
        const leftArrow = wrapper.querySelector('.carousel-arrow.left');
        const rightArrow = wrapper.querySelector('.carousel-arrow.right');
        
        let cards = track.children;
        const visibleCards = 3;
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
                const cardWidth = cards[0].offsetWidth + 20;
                const newTransform = -(currentIndex * cardWidth);
                track.style.transform = `translateX(${newTransform}px)`;
            } else {
                track.style.transform = `translateX(0px)`;
            }
        }

        if (!isAuthorMode) {
            rightArrow.addEventListener('click', () => {
                if (currentIndex < cards.length - visibleCards) {
                    currentIndex++;
                    updateCarousel();
                }
            });

            leftArrow.addEventListener('click', () => {
                if (currentIndex > 0) {
                    currentIndex--;
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
