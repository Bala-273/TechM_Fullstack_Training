document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll(".custom-teaser .cta-button").forEach(button => {
        button.addEventListener("click", function() {
            let longDesc = this.nextElementSibling;
            longDesc.style.display = longDesc.style.display === "none" ? "block" : "none";
        });
    });
});
