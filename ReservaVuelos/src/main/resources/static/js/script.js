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

// Cambiar el slider cada 3 segundos
setInterval(showNextSlide, 8000);


