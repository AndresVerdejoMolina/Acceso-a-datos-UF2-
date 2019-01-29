import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Depart;
import primero.Emple;
import primero.HibernateUtil;

public class HibernateIV_3 {

	public static void main(String[] args) {
  /*
  *Para modificar un objeto, igual que para borrarlo, primero hemos de cargarlo,
a continuación realizamos la modificaciones y, por último, utilizamos el
método update(). Realiza un programa que modifique el salario y el
departamento del empleado 7369, sumando 1000 al salario y asignándole el
departamento 30
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
			emple = (Emple) session.load(Emple.class, 7369);
			depart.setDeptNo(30);
			emple.setDepart(depart);
			emple.setSalario(emple.getSalario()+1000);
			session.update(emple);
			tx.commit();
			session.close();			
		}catch (ObjectNotFoundException o) {
			System.out.println("no hay.");
		}
	}

}
