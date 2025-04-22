document.addEventListener("DOMContentLoaded", () => {
  const searchIcon = document.getElementById("searchIcon");
  const searchInput = document.getElementById("searchInput");

  if (searchIcon && searchInput) {
    searchIcon.addEventListener("click", (e) => {
      e.preventDefault();
      searchInput.classList.toggle("show");
      if (searchInput.classList.contains("show")) {
        searchInput.focus();
      }
    });
  }
});



