package aed.h2.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coneccion {

	Connection conect;
	Statement st;
	ResultSet rst =null;
	
	public Coneccion() throws ClassNotFoundException{
	
			try {
				Class.forName("org.h2.Driver");
				conect=DriverManager.getConnection("jdbc:h2:C:\\Users\\david\\eclipse-workspace\\ProyectoH2\\lib\\databaseH2","sa","");
				st=conect.createStatement();
				System.out.println("Conectó");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	void probar() {
		try {
			
			rst=st.executeQuery("SELECT * FROM CINE.PELICULAS");
			while(rst.next()) {
				System.out.println("IDpeli:"+rst.getInt("IDPelicula")+"\t"+"Titulo"+rst.getString("Titulo")+"\t"+"Genero"+rst.getString("Genero")
				+"\t"+"Rango de edad:"+rst.getInt("RangoEdad")+ " años");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void inser() {
		try {
			//rst=st.executeQuery("INSERT INTO CINE.PELICULAS (Titulo, Genero, Rangoedad)VALUES('Cielo','Misterio','18')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
