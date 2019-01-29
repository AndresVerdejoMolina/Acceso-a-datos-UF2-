package ProblemasJDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCII_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Genera un programa que devuelva la clave primaria de la tabla 
		departamentos y la clave ajena que apunta a la tabla departamentos. NOTA: 
		revisa que estén creadas las claves; tanto la primaria como la foránea*/
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection 
					("jdbc:mysql://localhost:3306/ejemplo","maria","");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.printf("Nombre: %s %n", url);
			System.out.printf("Nombre: %s %n", usuario);
			//Primary key de la tabla depart
			resul = dbmd.getPrimaryKeys("ejemplo", null, "depart");
			while (resul.next()){
				String key = resul.getString("COLUMN_NAME");
				System.out.printf("Primary Key(depart): %s", key + "\n");
			}
			//Claves foraneas importadas a esta tabla
			resul = dbmd.getImportedKeys("ejemplo", null, "emple");
			while (resul.next()){
				String key = resul.getString("FKCOLUMN_NAME");
				System.out.printf("Foreign Key(emple): %s", key);
			}
			conexion.close();
		}
		
	catch (ClassNotFoundException cn) {cn.printStackTrace();}
	catch (SQLException e) {e.printStackTrace();}
	}
}
