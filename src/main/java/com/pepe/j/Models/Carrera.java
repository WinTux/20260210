package com.pepe.j.Models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Carrera", schema="pregrado")
public class Carrera implements Serializable{
	@Id
	private int CarreraID;
	@Column(name="Nombre", nullable= false)
	private String Nombre;
	private String Edificio;
	public int getCarreraID() {
		return CarreraID;
	}
	public void setCarreraID(int carreraID) {
		CarreraID = carreraID;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEdificio() {
		return Edificio;
	}
	public void setEdificio(String edificio) {
		Edificio = edificio;
	}
	
}
