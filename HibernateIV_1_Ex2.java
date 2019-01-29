import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.ObjectNotFoundException;

import primero.Depart;
import primero.Emple;
import primero.HibernateUtil;

public class HibernateIV_2 {

	public static void main(String[] args) {
    /*
    *Obtén los datos del departamento 10 y el APELLIDO y SALARIO de sus
empleados. Ayuda: para obtener los empleados usamos el método
getEmples() de la clase Depart y usamos un Iterator (java.util.Iterator) para
recorrer la lista de empleados.
    */
		// TODO Auto-generated method stub
		//En primer lugar se obtiene la sesión creada por el Singleton
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Creamos un nuevo objeto Emple/Depart y damos valor a sus atributos
		Emple emple = new Emple();
		Depart depart = new Depart();
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			depart = (Depart) session.load(Depart.class, 10);
			 
			 Set<Emple> listaemp = depart.getEmples();
			 Iterator<Emple> it = listaemp.iterator();
			 while(it.hasNext()) {
				 emple = (Emple) it.next();
				 System.out.printf("%s, %d%n", emple.getApellido(), emple.getSalario());
			 }
			
		}catch (ObjectNotFoundException o) {
			System.out.println("no hay.");
		}
		session.save(emple);
		tx.commit();
		session.close();
		System.exit(0);
	}

}
