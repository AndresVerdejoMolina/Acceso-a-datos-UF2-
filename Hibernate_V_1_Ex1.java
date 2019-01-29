import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Emple;
import primero.HibernateUtil;

public class HibernateV_1 {

	public static void main(String[] args) {
		/*Visualiza el apellido y salario de los empleados del departamento 20. (Ayuda:
		la consulta HQL necesaria es: “from Emple as e where e.depart.deptNo=20”)
		 */
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple as e where e.depart.deptNo=20");
		List <Emple> lista =q.list();
		Iterator <Emple> iter = lista.iterator();
		while (iter.hasNext()){
			Emple emp = (Emple) iter.next();
			System.out.printf("%s, %d%n", emp.getApellido(), emp.getSalario());
		}
		session.close();
		System.exit(0);
	}
}
