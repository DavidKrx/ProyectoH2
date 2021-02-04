package aed.h2.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Coneccion {
	Scanner sc=new Scanner(System.in);
	
	Connection conect;
	Statement st;
	ResultSet rst =null;
	
	public Coneccion() throws ClassNotFoundException{
	
			try {
				Class.forName("org.h2.Driver");
				conect=DriverManager.getConnection("jdbc:h2:C:\\Users\\david\\eclipse-workspace\\ProyectoH2\\lib\\databaseH2","sa","");
				//conect=DriverManager.getConnection("jdbc:h2:C:\\Users\\Usuario\\eclipse-workspace2\\ProyectoH2\\lib\\databaseH2","sa","");
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
				System.out.println("IDpeli: "+rst.getInt("IDPelicula")+"\t"+"Titulo: "+rst.getString("Titulo")+"\t"+"Genero: "+rst.getString("Genero")
				+"\t"+"Rango de edad:"+rst.getInt("RangoEdad")+ " años");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void inser() {
		try {
			//rst=st.prepare(,5);
			PreparedStatement a= conect.prepareStatement("INSERT INTO CINE.PELICULAS (Titulo, Genero, Rangoedad)VALUES('Cielo2','Misterio2','18');");
			a.executeUpdate();
			System.out.println("se insertó");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void mod() {
		probar();
		System.out.println("Id a modificar");
		String a=sc.nextLine();
		System.out.println("Titulo a modificar");
		String b=sc.nextLine();
		System.out.println("Genero a modificar");
		String c=sc.nextLine();
		System.out.println("Rangoedad a modificar");
		String d=sc.nextLine();

		try {
			//rst=st.prepare(,5);
			
			PreparedStatement ax= conect.prepareStatement("UPDATE CINE.PELICULAS SET Titulo=?, Genero=?, Rangoedad=? where IDPelicula="+a);
			ax.setString(1, b);
			ax.setString(2, c);
			ax.setString(3, d);

			ax.executeUpdate();
			System.out.println("se ha modificado"+"\n");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			Thread.sleep(2000);
			probar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void borrar() {
		System.out.println("Id a borrar");
		String a=sc.nextLine();
		try {
			
			PreparedStatement ax= conect.prepareStatement("DELETE FROM CINE.PELICULAS Where IDPelicula=?");
			ax.setString(1, a);
			ax.executeUpdate();
			System.out.println("se borro");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			Thread.sleep(2000);
			probar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
