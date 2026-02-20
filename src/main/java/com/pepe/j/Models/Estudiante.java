package com.pepe.j.Models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Estudiante", schema="pregrado")
public class Estudiante {
	@Id
	private int Matricula;
	private String Nombre;
	@Column(name="Apellido", nullable = false, length=100)
	private String Apellido;
	private LocalDate FechaNacimiento;
	private String Password;
	private String Email;
	private Boolean Estado;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CarreraID")
	private Carrera carr;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="est", targetEntity=Inscripcion.class)
	private Set<Inscripcion> inscripciones;
	public Set<Inscripcion> getInscripciones() {
		return inscripciones;
	}
	public void setInscripciones(Set<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	public int getMatricula() {
		return Matricula;
	}
	public void setMatricula(int matricula) {
		Matricula = matricula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Boolean getEstado() {
		return Estado;
	}
	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	public void setCarr(Carrera carr) {
		this.carr = carr;
	}
	
}
