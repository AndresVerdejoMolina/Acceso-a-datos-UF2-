import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Emple;
import primero.HibernateUtil;

public class HibernateV_2 {

	public static void main(String[] args) {
  //Visualiza los datos del señor “ARROYO”
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple where apellido='ARROYO'");
		List <Emple> lista =q.list();
		Iterator <Emple> iter = lista.iterator();
		while (iter.hasNext()){
			Emple emp = (Emple) iter.next();
			System.out.printf("%d ,%s, %s, %d, %d, %d%n", emp.getEmpNo(), emp.getApellido(), emp.getOficio(), emp.getDir(), emp.getSalario(), emp.getComision());
		}
		session.close();
		System.exit(0);
	}
}
