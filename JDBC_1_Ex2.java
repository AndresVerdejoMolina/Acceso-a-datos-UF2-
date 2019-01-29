package ProblemasJDBC;

import java.sql.*;

public class ConectarMysql {

	public static void main(String[] args) {
		try{
			/*
			 * 2-Realiza otro programa Java utilizando la base de datos “ejemplo” que 
			visualice el APELLIDO del empleado con máximo salario, visualiza también 
			su SALARIO y el nombre del departamento. */
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/ejemplo","maria","");
			Statement sentencia =conexion.createStatement();
			String sql = "select emple.apellido, emple.salario, depart.dnombre from emple join depart using(dept_no) order by salario desc limit 1";
			ResultSet result = sentencia.executeQuery(sql);
			while (result.next()){
				System.out.printf("%s, %d, %s, %n",
						result.getString("emple.apellido"),
						result.getInt("emple.salario"),
						result.getString("depart.dnombre"));
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
	}
}
