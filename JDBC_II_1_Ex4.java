package ProblemasJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.plaf.FontUIResource;

public class JDBCII_4 {

	public static void main(String[] args) {
		/*
		 * Busca información sobre la interfaz 
		ResultSetMetaData
		 y realiza un 
		programa utilizando dicha interfaz que obtenga el número de columnas y el 
		tipo de columnas devueltos por la consulta “SELECT * FROM 
		DEPARTAMENTOS”*/
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/ejemplo","maria","");
			Statement sentencia =conexion.createStatement();
			String sql = "select * from depart";
			ResultSet result = sentencia.executeQuery(sql);
			ResultSetMetaData rsmd= result.getMetaData();
			int contador=rsmd.getColumnCount();
			System.out.println("Hay " + contador + " columnas.");
			for (int i = 1; i <= contador; i++) {
				String type= rsmd.getColumnTypeName(i);
				System.out.println("Columna nº " +i + " de tipo: " + type);
				
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
	}
}
