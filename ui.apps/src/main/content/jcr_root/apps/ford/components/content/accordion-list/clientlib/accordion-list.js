

document.addEventListener("DOMContentLoaded", function () {
  const accordionTitles = document.querySelectorAll(".accordion-title");

  accordionTitles.forEach((title) => {
    title.addEventListener("click", () => {
      const currentItem = title.closest(".accordion-item");

   
      document.querySelectorAll(".accordion-item").forEach((item) => {
        if (item !== currentItem) {
          item.classList.remove("open");
          item.querySelector(".accordion-title").classList.remove("active");
          item.querySelector(".accordion-toggle-icon").textContent = "+";
        }
      });

      const isOpen = currentItem.classList.contains("open");
      currentItem.classList.toggle("open");

      const icon = currentItem.querySelector(".accordion-toggle-icon");
      icon.textContent = isOpen ? "+" : "-";
      title.classList.toggle("active", !isOpen);
    });
  });
});
