import java.util.Date;

import org.hibernate.*;
import primero.Depart;
import primero.Emple;
import primero.HibernateUtil;

public class HibernateIV_1 {

	public static void main(String[] args){
    /*
    *Visualiza el apellido y el salario del empleado con número: 7369
    */
		//En primer lugar se obtiene la sesión creada por el Singleton
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Creamos un nuevo objeto Emple/Depart y damos valor a sus atributos
		Emple emple = new Emple();
		Depart depart = new Depart();
		//Abrimos sesión e iniciamos una transacción
		Date now = new Date();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		emple= (Emple) session.load(Emple.class, 7369);
		if(depart==null){
			System.out.println("No hay empleados con esta id.");
		}else {
			System.out.print("Estos son los empleados que tienen id=7369;");
			System.out.println("Apellido " + emple.getApellido() + ", Salario " + emple.getSalario());
			
		}
		
		/*Guardamos en la base de datos y comprometemos la información*/
		session.save(emple);
		tx.commit();
		session.close();
		System.exit(0);
	}
}
