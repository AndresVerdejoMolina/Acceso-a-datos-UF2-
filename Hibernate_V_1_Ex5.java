import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.HibernateUtil;
public class HibernateV_5 {

	public static void main(String[] args) {
		/*
		 * Muestra el salario medio y el número de empleados por departamento
		 */
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("select avg(e.salario), count(apellido) from Emple e group by e.depart");
		List <?> lista =q.list();
		Iterator <?> iter = lista.iterator();
		Object[] listaObj;
		while (iter.hasNext()){
			listaObj = (Object[]) iter.next();
			System.out.println(listaObj[0] + " - " + listaObj[1]);
		}
		session.close();
		System.exit(0);
	}
}
