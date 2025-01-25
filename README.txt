Problema, al iniciar la página tuve un problema:

"Access to fetch at 'http://localhost:8080/api/alumnos' from origin 'http://192.168.1.148:5500' has been blocked by CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource. If an opaque response serves your needs, set the request's mode to 'no-cors' to fetch the resource with CORS disabled."

La IA me sugirió que probase a entrar en las páginas: http://localhost:8080/api/crearAlumno y http://localhost:8080/api/alumnos.

El primero funcionaba pero el segundo no, me daba un error 405 diciendo lo siguiente: Method 'GET' is not supported.

Eso quiere decir que el método GET no estaba implementado. Lo que hice fue añadir el GET tanto en el Back-End y Front-End.

Front-End: let obtenerAlumno = async () => {
    const respuesta = await fetch("http://localhost:8080/api/alumnos",
        {
            method: "GET",
            headers: {
                "Accept" : "application/json"
            }
        }
    );
}

Back-End: @GetMapping("/api/alumnos") // Cambia la ruta del endpoint para que coincida
    public List<Alumno> obtenerAlumnos1() {
        return repositorio.findAll();
    }
