package com.pepe.j.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Estudiante", schema="pregrado")
public class Estudiante {
	@Id
	private int Matricula;
	private String Nombre;
	private String Apellido;
	private LocalDate FechaNacimiento;
	private String Password;
	private String Email;
	private Boolean Estado;
	@ManyToOne(fetch=FetchType.LAZY)
	private Carrera carr;
}
