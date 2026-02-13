package com.pepe.j;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pepe.j.Models.Carrera;

public class App {
  public static void main(String[] args) {
    
    // Crear una carrera
    crearCarrera();
  }

  private static void crearCarrera() {
	  System.out.println("*** Conexión a la DDBB ***");
	  Transaction tx = null;
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  System.out.println("*** Creando carrera ***");
	  Carrera c = new Carrera();
	  c.setCarreraID(777);
	  c.setNombre("Ing. de Sistemas");
	  c.setEdificio("Bloque A");
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
