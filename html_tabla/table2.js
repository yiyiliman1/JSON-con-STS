window.onload = function(){
    listarAlumnos();
}

let listarAlumnos = async()=>{
    const peticion = await fetch("http://localhost:8080/api/alumnos",
        {
            method:'GET',
            headers:{
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            }
        });

    const alumnos = await peticion.json();

    let contenidoTabla = "";

    for(let alumno of alumnos) {
        let contenidoFila = `<tr>
        <td>${alumno.id}</td>
        <td>${alumno.nombre}</td>
        <td>${alumno.apellido}</td>
        <td>${alumno.carrera}</td>
        <td>
            <i class="material-icons button edit">edit</i>
            <i class="material-icons button delete">delete</i>
        </td>
        </tr>`

        contenidoTabla += contenidoFila;
    }
    document.querySelector("#tabla tbody").outerHTML = contenidoTabla;
}

let borrarAlumno = async(id)=> {
    const peticion = await fetch ("http://localhost:8080/api/alumnos" + id,
        {
            method: 'DELETE',
            headers: {
               'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            }
        });
    listarAlumnos();
}

let modificarAlumno = async(id)=> {
    const peticion = await fetch ("http://localhost:8080/api/alumnos" + id,
        {
            method: 'PUT',
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            }
        });
}