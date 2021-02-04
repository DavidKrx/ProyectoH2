package aed.h2.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class H2 {
Scanner sc=new Scanner(System.in);
	
	Connection conect;
	Statement st;
	ResultSet rst =null;
	
	public H2() throws ClassNotFoundException{
	
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
			
			rst=st.executeQuery("SELECT * FROM CINE.SALA");
			while(rst.next()) {
				System.out.println("ID: "+rst.getInt("ID")+"\t"+"IdPelicula: "+rst.getInt("IDPelicula")+"\t"+"Hora: "+rst.getDate("Hora")
				+"\t"+"3D:"+rst.getBoolean("TRESD")+ " 3D");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void inser() {
		try {
			//rst=st.prepare(,5);
			PreparedStatement a= conect.prepareStatement("INSERT INTO CINE.SALAS (IDPelicula, Hora, TESD)VALUES('1','17-30-30','1');");
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
		int a=sc.nextInt();
		System.out.println("Titulo a modificar");
		int b=sc.nextInt();
		System.out.println("Genero a modificar");
		//Date c=sc.nextInt();
		System.out.println("Rangoedad a modificar");
		boolean d=sc.nextBoolean();

		try {
			//rst=st.prepare(,5);
			
			PreparedStatement ax= conect.prepareStatement("UPDATE CINE.PELICULAS SET IDPelicula=?, Hora=?, TRESD=? where ID="+a);
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
			
			PreparedStatement ax= conect.prepareStatement("DELETE FROM CINE.PELICULAS Where ID=?");
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
