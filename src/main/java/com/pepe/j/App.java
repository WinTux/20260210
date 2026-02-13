package com.pepe.j;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pepe.j.Models.Carrera;
import com.pepe.j.Models.Estudiante;

public class App {
  public static void main(String[] args) {
    
    // Crear una carrera
    //crearCarrera();
	crearEstudiante();
  }

  private static void crearEstudiante() {
	  System.out.println("*** Conexión a la DDBB ***");
	  Transaction tx = null;
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  System.out.println("*** Creando estudiante ***");
	  Estudiante est = new Estudiante();
	  est.setMatricula(7080000);
	  est.setNombre("Pepe");
	  est.setApellido("Perales");
	  LocalDate localDate = LocalDate.of(1998, 12, 31);
	  est.setFechaNacimiento(localDate);//Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
	  est.setPassword("123456");
	  est.setEmail("pepe.pe@gmail.com");
	  est.setEstado(true);
	  Carrera carreraDeEst = null;
	  try {
		  tx = session.beginTransaction();
		  int id = 777;
		  Query query = session.createQuery("select c from Carrera c where c.CarreraID = :cid");
		  query.setParameter("cid", id);
		  carreraDeEst = (Carrera) query.getSingleResult();
		  est.setCarr(carreraDeEst);
		  session.persist(est);
		  tx.commit();
	  }catch(HibernateException e) {
		  e.printStackTrace();
		  if(tx!=null)
			  tx.rollback();
	  }finally {
		  session.close();
	  }
}

  private static void crearCarrera() {
	  System.out.println("*** Conexión a la DDBB ***");
	  Transaction tx = null;
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  System.out.println("*** Creando carrera ***");
	  Carrera c = new Carrera();
	  //c.setCarreraID(777);
	  c.setNombre("Odontología");
	  //c.setEdificio("Bloque A");
	  try {
		  tx = session.beginTransaction();
		  session.persist(c);// INSERT INTO Carrera () VALUES ();
		  tx.commit();
	  }catch(HibernateException e) {
		  e.printStackTrace();
		  if(tx!=null)
			  tx.rollback();
	  }finally {
		  session.close();
	  }
	  
  }
}
