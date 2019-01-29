import primero.*;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Hibernate_II {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesión e iniciamos una transacción
		Date now = new Date();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en emple");
		//Creamos un nuevo objeto Emple y damos valor a sus atributos
		Emple emple = new Emple();
		Depart depart = new Depart();
		depart.setDeptNo((byte)10);
		emple.setEmpNo((byte) 62);
		emple.setApellido("CONTABILIDAD");
		emple.setOficio("GUADALAJARA");
		emple.setDir(74043);
		emple.setComision(2000);
		emple.setDepart(depart);
		emple.setEmpNo(8001);
		emple.setFechaAlt(now);
		emple.setSalario(2000);
		/*Guardamos en la base de datos y comprometemos la información*/
		session.save(emple);
		tx.commit();
		session.close();
		System.exit(0);
	}
}
