package com.pepe.j.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Inscripcion {
	private int InscripcionID;
	private LocalDate FechaInscripcion;
	private BigDecimal Calificacion;
	private Asignatura asig;
	private Estudiante est;
	public int getInscripcionID() {
		return InscripcionID;
	}
	public void setInscripcionID(int inscripcionID) {
		InscripcionID = inscripcionID;
	}
	public LocalDate getFechaInscripcion() {
		return FechaInscripcion;
	}
	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		FechaInscripcion = fechaInscripcion;
	}
	public BigDecimal getCalificacion() {
		return Calificacion;
	}
	public void setCalificacion(BigDecimal calificacion) {
		Calificacion = calificacion;
	}
	public Asignatura getAsig() {
		return asig;
	}
	public void setAsig(Asignatura asig) {
		this.asig = asig;
	}
	public Estudiante getEst() {
		return est;
	}
	public void setEst(Estudiante est) {
		this.est = est;
	}
}
