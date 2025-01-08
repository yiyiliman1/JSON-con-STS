package com.example.Clase.repositorio;

import org.springframework.data.jpa.repository.JpaRepository; // Importación de JpaRepository
import org.springframework.stereotype.Repository; // Importación de Repository para marcar como componente Spring

import com.example.Clase.models.Alumno; // Importación del modelo Alumno

@Repository // Marca esta interfaz como un repositorio de Spring para gestión de datos
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
    // Extiende JpaRepository, proporcionando métodos CRUD para la entidad Alumno
    // No es necesario escribir métodos básicos como save(), findById(), findAll() ya que los proporciona JpaRepository
}
