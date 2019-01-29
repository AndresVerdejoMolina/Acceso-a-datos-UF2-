import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.HibernateUtil;

public class HibernateV_4 {

	public static void main(String[] args) {
		/*
		 * Calcula el salario medio de todos los empleados. (Ayuda: busca en el manual
de HQL cómo utilizar las funciones de agregación. Verás que es lo mismo
que en SQL)
		 */
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("select avg(e.salario) from Emple e");
		List <Double> lista =q.list();
		Iterator <Double> iter = lista.iterator();
		while (iter.hasNext()){
			System.out.println("Salario avg: " + iter.next());
		}
		session.close();
		System.exit(0);
	}
}
