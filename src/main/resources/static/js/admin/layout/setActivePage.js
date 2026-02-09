document.addEventListener("DOMContentLoaded", function() {
    const menuItems = document.querySelectorAll(".menu a");

    menuItems.forEach(item => {
        if (window.location.pathname === item.getAttribute("href")) {
            item.closest("li").classList.add("active");
        }
    });
});