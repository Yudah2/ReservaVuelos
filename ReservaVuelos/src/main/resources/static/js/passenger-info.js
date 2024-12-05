document.getElementById('generate-passenger-forms').addEventListener('click', function () {
    const passengerFormsContainer = document.getElementById('passenger-forms');
    const template = document.getElementById('passenger-template'); // Seleccionar la plantilla

    // Solicitar la cantidad de pasajeros
    const numPassengers = prompt('¿Cuántos pasajeros hay?');
    passengerFormsContainer.innerHTML = ''; // Limpiar los formularios anteriores

    for (let i = 1; i <= numPassengers; i++) {
        const clone = template.content.cloneNode(true); // Clonar la plantilla
        const form = clone.querySelector('.passenger-form'); // Seleccionar el formulario clonado
        form.querySelector('h3').textContent = `Pasajero ${i}`; // Actualizar el título con el número de pasajero
        passengerFormsContainer.appendChild(clone); // Añadir al contenedor
    }
});
