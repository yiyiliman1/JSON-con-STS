package com.example.Clase.models; // Paquete donde se encuentra esta clase

import jakarta.persistence.Entity; // Importación para marcar la clase como entidad de JPA
import jakarta.persistence.GeneratedValue; // Para la generación automática de IDs
import jakarta.persistence.GenerationType; // Estrategias de generación de IDs
import jakarta.persistence.Id; // Para marcar la clave primaria

@Entity // Marca esta clase como una entidad JPA que se mapeará a una tabla en la base de datos
public class Alumno {

    @Id // Marca el campo 'id' como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La base de datos generará automáticamente el valor del ID
    Long id; // Campo que almacena el identificador único del alumno

    // Campos para almacenar la información del alumno
    String nombre; 
    String apellido;
    String carrera;

    // Constructor vacío necesario para JPA
    public Alumno() {
        super();
    }

    // Constructor con parámetros para inicializar los atributos
    // porque es un requisito fundamental para que la biblioteca pueda funcionar correctamente al mapear entidades a tablas de bases de datos.
    public Alumno(Long id, String nombre, String apellido, String carrera) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    // Métodos Getter y Setter para acceder y modificar los atributos

    public Long getId() { // Devuelve el ID del alumno
        return id;
    }

    public void setId(Long id) { // Establece el ID del alumno
        this.id = id;
    }

    public String getNombre() { // Devuelve el nombre del alumno
        return nombre;
    }

    public void setNombre(String nombre) { // Establece el nombre del alumno
        this.nombre = nombre;
    }

    public String getApellido() { // Devuelve el apellido del alumno
        return apellido;
    }

    public void setApellido(String apellido) { // Establece el apellido del alumno
        this.apellido = apellido;
    }

    public String getCarrera() { // Devuelve la carrera del alumno
        return carrera;
    }

    public void setCarrera(String carrera) { // Establece la carrera del alumno
        this.carrera = carrera;
    }
}