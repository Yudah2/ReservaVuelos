document.getElementById('generate-passenger-forms').addEventListener('click', function () {
    const passengerFormsContainer = document.getElementById('passenger-forms');
    const template = document.getElementById('passenger-template'); // Seleccionar la plantilla

    // Pedir la cantidad de pasajeros de forma dinámica
    const numPassengers = parseInt(prompt('¿Cuántos pasajeros hay? (Ingresa un número entero)'), 10);

    if (isNaN(numPassengers) || numPassengers <= 0) {
        alert('Por favor, ingresa un número válido de pasajeros.');
        return;
    }

    // Limpiar formularios anteriores
    passengerFormsContainer.innerHTML = '';

    // Generar un formulario por cada pasajero
    for (let i = 0; i < numPassengers; i++) {
        const clone = template.content.cloneNode(true); // Clonar la plantilla
        const form = clone.querySelector('.passenger-form'); // Seleccionar el formulario clonado

        // Actualizar el título con el número de pasajero
        form.querySelector('h3').textContent = `Pasajero ${i + 1}`;

        // Configurar atributos únicos para los inputs dentro de cada formulario
        const nameInput = form.querySelector('input[name="passengers[0].persona.name"]');
        const lastnameInput = form.querySelector('input[name="passengers[0].persona.lastname"]');
        const categoriaSelect = form.querySelector('select[name="passengers[0].categoria"]');
        const genderInputs = form.querySelectorAll('input[name="passengers[0].gender"]');
        const ciInput = form.querySelector('input[name="passengers[0].persona.ci"]');
        const birthdayInput = form.querySelector('input[name="passengers[0].persona.birthday"]');

        // Actualizar el nombre de los inputs para cada pasajero
        nameInput.setAttribute('name', `passengers[${i}].persona.name`);
        lastnameInput.setAttribute('name', `passengers[${i}].persona.lastname`);
        categoriaSelect.setAttribute('name', `passengers[${i}].categoria`);
        genderInputs.forEach((input) => {
            input.setAttribute('name', `passengers[${i}].gender`);
        });
        ciInput.setAttribute('name', `passengers[${i}].persona.ci`);
        birthdayInput.setAttribute('name', `passengers[${i}].persona.birthday`);

        // Añadir el formulario al contenedor
        passengerFormsContainer.appendChild(clone);
    }
});


