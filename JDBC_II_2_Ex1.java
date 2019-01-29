package ProblemasJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCIIPART2_1 {

	public static void main(String[] args) {
		/*
		 * Realiza un programa en Java que suba el salario a los empleados de un 
			departamento. El programa recibirá el número de departamento y el 
			incremento.
		 */
		System.out.println("cuanto quieres que ganen los empleados: ");
		Scanner primero=new Scanner(System.in);
		int money=primero.nextInt();
		
		System.out.println("y su departamento: ");
		Scanner segundo=new Scanner(System.in);
		String depart=segundo.nextLine();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/ejemplo","maria","");
			Statement sentencia =conexion.createStatement();
			String sql = "update emple set salario=salario + \""+money+"\" where dept_no =\""+depart+"\"";
			int result = sentencia.executeUpdate(sql);
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
	}
}
