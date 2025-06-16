let currentPage = 1;
const pageSize = 1; // Limit = 1

function renderProducts(products) {
    const container = document.getElementById("product-list");
    container.innerHTML = "";

    if (products.length === 0) {
        container.innerHTML = "<p>No products in stock.</p>";
        return;
    }

    products.forEach(product => {
        const card = document.createElement("div");
        card.className = "product-card";
        card.innerHTML = `
            <a href="${product.path}">${product.productName}</a>
            <h3>${product.productDescription || ""}</h3>
            <p>Category: ${product.category}</p>
            <p>Price: ₹${product.price}</p>
            <p>In Stock: ${product.availability}</p>
            ${product.image ? `<img src="${product.image}" alt="${product.productName}">` : ""}
        `;
        container.appendChild(card);
    });

    // Enable or disable Previous/Next buttons
    document.getElementById("prevPage").disabled = currentPage === 1;
    document.getElementById("nextPage").disabled = products.length < pageSize;
    document.getElementById("pageNumber").textContent = `Page ${currentPage}`;
}

function fetchFilteredProducts(category, minPrice, maxPrice, availability, offset = 0, limit = 1) {
    const params = new URLSearchParams();

    if (category) params.append("category", category);
    if (minPrice) params.append("minPrice", minPrice);
    if (maxPrice) params.append("maxPrice", maxPrice);
    if (availability) params.append("availability", availability);

    params.append("offset", offset);
    params.append("limit", limit);

    fetch(`/bin/product-filter?${params.toString()}`)
        .then(response => response.json())
        .then(data => renderProducts(data))
        .catch(error => console.error("Failed to fetch products:", error));
}

document.addEventListener("DOMContentLoaded", () => {
    const categoryInput = document.getElementById("categorySelect");
    const minInput = document.getElementById("minPrice");
    const maxInput = document.getElementById("maxPrice");
    const availabilityInput = document.getElementById("availabilitySelect");

    function loadPage(page) {
        const offset = (page - 1) * pageSize;
        fetchFilteredProducts(
            categoryInput.value,
            minInput.value,
            maxInput.value,
            availabilityInput.value,
            offset,
            pageSize
        );
    }

    document.getElementById("applyFilters").addEventListener("click", () => {
        currentPage = 1;
        loadPage(currentPage);
    });

    document.getElementById("nextPage").addEventListener("click", () => {
        currentPage++;
        loadPage(currentPage);
    });

    document.getElementById("prevPage").addEventListener("click", () => {
        if (currentPage > 1) {
            currentPage--;
            loadPage(currentPage);
        }
    });

    // Initial load
    loadPage(currentPage);
});
