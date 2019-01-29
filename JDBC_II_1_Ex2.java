package ProblemasJDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCII_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Genera un programa en Java que muestre el nombre, el tipo, el tamaño y si 
		puede ser nulo o no, de las columnas de la tabla departamentos. */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/ejemplo","maria","");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.printf("Nombre: %s %n", url);
			System.out.printf("Nombre: %s %n", usuario);
			resul = dbmd.getColumns("ejemplo", null, "depart", null);
			while (resul.next()){
				String nom = resul.getString("COLUMN_NAME");
				String tipo = resul.getString("TYPE_NAME");
				int size = resul.getInt("COLUMN_SIZE");
				String isnull = resul.getString("IS_NULLABLE");
				System.out.printf("Nombre: %s - Tipo: %s, Tamaño: %s, Si adminte null: %s %n", nom,tipo, size, isnull);
			}
			conexion.close();
		}
	catch (ClassNotFoundException cn) {cn.printStackTrace();}
	catch (SQLException e) {e.printStackTrace();}
	}
}
