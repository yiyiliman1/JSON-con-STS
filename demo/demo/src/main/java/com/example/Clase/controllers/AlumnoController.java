package com.example.Clase.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Clase.models.Alumno;
import com.example.Clase.repositorio.AlumnoRepository;

@RestController // Indica que esta clase es un controlador REST 
public class AlumnoController {

    // Inyección de dependencia del repositorio
    AlumnoRepository repositorio;
    AlumnoController(AlumnoRepository repositorio){
        this.repositorio = repositorio;
    } 

    @GetMapping("/api/crearAlumno") // Endpoint para obtener la lista de alumnos
    public List<Alumno> obtenerAlumnos() {
        return repositorio.findAll();
    }

    @GetMapping("/api/alumnos/{id}") // Endpoint para obtener un alumno por su ID
    public ResponseEntity<Alumno> obtenerAlumno(@PathVariable Long id) {
        Optional<Alumno> opt = repositorio.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(opt.get());
        }
    }

    @CrossOrigin("http://192.168.1.148:5500") // Permitir solicitudes CORS desde un origen específico
    @PostMapping("/api/alumnos") // Endpoint para guardar un nuevo alumno
    public ResponseEntity<Alumno> guardarAlumno(@RequestBody Alumno alumno) {
        if(alumno.getId() != null) { // Validación para evitar IDs predefinidos
            return ResponseEntity.badRequest().build();
        }
        repositorio.save(alumno); // Guardar el nuevo alumno en la base de datos
        return ResponseEntity.ok(alumno);
    }
}
