// Variables para los elementos del slider
let sliderItems = document.querySelectorAll('.slider-item');
let currentIndex = 0;

// Función para mostrar el siguiente slider
function showNextSlide() {
    // Quitar la clase 'active' del elemento actual
    sliderItems[currentIndex].classList.remove('active');

    // Incrementar el índice del slider
    currentIndex = (currentIndex + 1) % sliderItems.length;

    // Añadir la clase 'active' al siguiente elemento
    sliderItems[currentIndex].classList.add('active');
}

// Mostrar el primer slider
sliderItems[currentIndex].classList.add('active');


document.getElementById("form-search-1").addEventListener("submit", async (event) => {
    event.preventDefault(); // Prevenir el comportamiento predeterminado del formulario

    const origen = document.getElementById("origen").value;
    const destino = document.getElementById("destino").value;
    const fechaSalida = document.getElementById("salida").value;

    try {
        const response = await fetch(`/api/vuelo?origen=${origen}&destino=${destino}&fechaSalida=${fechaSalida}`);
        const vuelos = await response.json();
        console.log(vuelos); // Verifica la respuesta en la consola
    } catch (error) {
        console.error("Error al buscar vuelos:", error);
    }
});


