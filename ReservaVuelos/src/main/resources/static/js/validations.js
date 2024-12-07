document.addEventListener("DOMContentLoaded", () => {
    const passengersButton = document.getElementById("passengers-button");
    const passengersMenu = document.getElementById("passengers-menu");

    // Alternar el menú desplegable al hacer clic en el botón
    passengersButton.addEventListener("click", (event) => {
        event.preventDefault(); // Evitar recargas innecesarias
        const isExpanded = passengersButton.getAttribute("aria-expanded") === "true";
        passengersButton.setAttribute("aria-expanded", !isExpanded);
        passengersMenu.hidden = isExpanded ? true : false;
    });

    // Cerrar el menú si haces clic fuera de él
    document.addEventListener("click", (event) => {
        if (!passengersButton.contains(event.target) && !passengersMenu.contains(event.target)) {
            passengersMenu.hidden = true;
            passengersButton.setAttribute("aria-expanded", "false");
        }
    });
});
