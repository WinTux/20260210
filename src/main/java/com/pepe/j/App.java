package com.pepe.j;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pepe.j.Models.Asignatura;
import com.pepe.j.Models.Carrera;
import com.pepe.j.Models.Docente;
import com.pepe.j.Models.Estudiante;
import com.pepe.j.Models.Inscripcion;

public class App {
  public static void main(String[] args) {
    
    // Crear una carrera
    //crearCarrera();
	// Crear un estudiante
	//crearEstudiante();
	// Crear un docente
	//crearDocente();
	// Crear una asignatura
	//crearAsignatura();
	// Crear una inscripcion
	crearInscripcion();
  }

  private static void crearInscripcion() {
	  System.out.println("*** Conexión a la DDBB ***");
	  Transaction tx = null;
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  System.out.println("*** Creando inscripción ***");
	  Inscripcion i = new Inscripcion();
	  i.setFechaInscripcion(LocalDate.of(2026, 2, 20));
	  i.setCalificacion(BigDecimal.valueOf(8.5));
	  Estudiante estudianteDeInscripcion;
	  Asignatura asignaturaDeInscripcion;
	  try {
		  tx = session.beginTransaction();
		  int id = 7080000;
		  
		  Query queryEst = session.createQuery("select e from Estudiante e where e.Matricula = :cid");
		  queryEst.setParameter("cid", id);
		  estudianteDeInscripcion = (Estudiante) queryEst.getSingleResult();
		  
		  String siglaAsig = "INF131" ;
		  Query queryAsig = session.createQuery("select a from Asignatura a where a.Sigla = :sig");
		  queryAsig.setParameter("sig", siglaAsig);
		  asignaturaDeInscripcion = (Asignatura) queryAsig.getSingleResult();
		  
		  i.setEst(estudianteDeInscripcion);
		  i.setAsig(asignaturaDeInscripcion);
		  session.persist(i);
		  tx.commit();
	  }catch(HibernateException e) {
		  e.printStackTrace();
		  if(tx!=null)
			  tx.rollback();
	  }finally {
		  session.close();
	  }
}

  private static void crearAsignatura() {
	  System.out.println("*** Conexión a la DDBB ***");
	  Transaction tx = null;
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  System.out.println("*** Creando asignatura ***");
	  Asignatura asig = new Asignatura();
	  asig.setSigla("INF131");
	  asig.setDescripcion("Se ver estructuras típicas para lenguajes POO");
	  asig.setTitulo("Estructuras de datos");
	  asig.setCreditos(20);
	  Carrera carreraDeAsig = null;
	  try {
		  tx = session.beginTransaction();
		  int id = 777;
		  Query query = session.createQuery("select c from Carrera c where c.CarreraID = :cid");
		  query.setParameter("cid", id);
		  carreraDeAsig = (Carrera) query.getSingleResult();
		  asig.setCarrerita(carreraDeAsig);
		  session.persist(asig);
		  tx.commit();
	  }catch(HibernateException e) {
		  e.printStackTrace();
		  if(tx!=null)
			  tx.rollback();
	  }finally {
		  session.close();
	  }
}

  private static void crearDocente() {
	  System.out.println("*** Conexión a la DDBB ***");
	  Transaction tx = null;
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  System.out.println("*** Creando docente ***");
	  Docente doc = new Docente();
	  doc.setNombre("Sofía");
	  doc.setApellido("Rocha");
	  doc.setPassword("776655");
	  doc.setEmail("sofi.doc@universidadeducomser.com");
	  doc.setSitioWeb("https://github.com/sofisofi");
	  Carrera carreraDeDoc = null;
	  try {
		  tx = session.beginTransaction();
		  int id = 777;
		  Query query = session.createQuery("select c from Carrera c where c.CarreraID = :cid");
		  query.setParameter("cid", id);
		  carreraDeDoc = (Carrera) query.getSingleResult();
		  doc.setCarr(carreraDeDoc);
		  session.persist(doc);
		  tx.commit();
	  }catch(HibernateException e) {
		  e.printStackTrace();
		  if(tx!=null)
			  tx.rollback();
	  }finally {
		  session.close();
	  }
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
