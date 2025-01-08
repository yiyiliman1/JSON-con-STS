let boton = document.getElementById("btnRegistrar");

boton.addEventListener("click", evento => {
    evento.preventDefault();
    registroAlumno();
});

// Fallo aqui: En tu controlador, la ruta es /api/alumnos (con "alumnos" en plural)
let registroAlumno = async()=>{

    let campos = {
        nombre: document.getElementById("nombre").value,
        apellido: document.getElementById("apellido").value,
        carrera: document.getElementById("carrera").value // asi se guarda la variable
    };

    const peticion = await fetch("http://localhost:8080/api/alumnos",  
    {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
         },
         body: JSON.stringify(campos)
    });
}
