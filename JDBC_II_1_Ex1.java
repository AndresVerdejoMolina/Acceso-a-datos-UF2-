package ProblemasJDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCII_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			System.out.printf("Nombre: %s %n", nombre);
			System.out.printf("Nombre: %s %n", driver);
			System.out.printf("Nombre: %s %n", url);
			System.out.printf("Nombre: %s %n", usuario);
			resul = dbmd.getTables(null,"ejemplo",null,null);
			while (resul.next()){
				String catalogo = resul.getString(1);
				String esquema = resul.getString(2);
				String tabla = resul.getString(3);
				String tipo = resul.getString(4);
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo,catalogo, esquema, tabla);
			}
			conexion.close();
		}
	catch (ClassNotFoundException cn) {cn.printStackTrace();}
	catch (SQLException e) {e.printStackTrace();}
	}
}
