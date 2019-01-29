package ProblemasJDBC;

import java.sql.*;
import java.util.Scanner;

public class ConectarMysql3 {

	public static void main(String[] args) {
		
		/*
		 3-Realiza un programa que busque los departamentos de una localidad. El 
		programa solicitará el nombre de una localidad al usuario y devolverá los 
		departamentos asociados a dicha localidad y los empleados de dicho 
		departamentos.*/
		System.out.println("introduce una localidad: ");
		Scanner primero=new Scanner(System.in);
		String loc=primero.nextLine();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/ejemplo","maria","");
			Statement sentencia =conexion.createStatement();
			String sql = "select depart.dnombre, emple.apellido from emple, depart where depart.dept_no=emple.dept_no and loc=\""+loc+"\"";
			ResultSet result = sentencia.executeQuery(sql);
			while (result.next()){
				System.out.printf("%s, %s, %n",
						result.getString("depart.dnombre"),
						result.getString("emple.apellido"));
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
	}
}
