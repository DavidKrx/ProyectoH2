package aed.h2.proyecto;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class H2 {
	Scanner sc = new Scanner(System.in);

	Connection conect;
	Statement st;
	ResultSet rst = null;

	public H2() throws ClassNotFoundException {

		try {
			Class.forName("org.h2.Driver");
			conect = DriverManager.getConnection(
					"jdbc:h2:C:\\Users\\david\\eclipse-workspace\\ProyectoH2\\lib\\databaseH2", "sa", "");
			// conect=DriverManager.getConnection("jdbc:h2:C:\\Users\\Usuario\\eclipse-workspace2\\ProyectoH2\\lib\\databaseH2","sa","");
			st = conect.createStatement();
			// System.out.println("Conectó");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	void visualizarSala() {
		try {

			rst = st.executeQuery("SELECT * FROM CINE.SALA");
			while (rst.next()) {
				System.out.println("ID: " + rst.getInt("ID") + "\t" + "IdPelicula: " + rst.getInt("IDPelicula") + "\t"
						+ "Hora: " + rst.getString("Hora") + "\t" + "3D:" + rst.getBoolean("TRESD"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	void inserSala() {
		try {

			PreparedStatement a = conect
					.prepareStatement("INSERT INTO CINE.SALA (IDPelicula, Hora, TRESD)VALUES('2','20:20:20','0');");
			a.executeUpdate();
			System.out.println("se insertó");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	void modSala() {
		visualizarSala();
		System.out.println("Id a modificar");
		int a = sc.nextInt();
		System.out.println("IdPelicula a modificar");
		int b = sc.nextInt();
		System.out.println("Hora a modificar eliga una de estas 1: 16:00:00 2: 18:00:00 3: 20:00:00");
		int c = sc.nextInt();

		System.out.println("3D a modificar");
		boolean d = sc.nextBoolean();

		try {
			Time j = null;
			if (c == 1) {
				j = new Time(16, 00, 00);
			} else {
				if (c == 2) {
					j = new Time(18, 00, 00);
				} else {
					if (c == 3) {
						j = new Time(20, 00, 00);
					}
				}
			}
			PreparedStatement ax = conect
					.prepareStatement("UPDATE CINE.SALA SET IDPelicula=?, Hora=?, TRESD=? where ID=" + a);
			ax.setInt(1, b);
			ax.setTime(2, j);
			ax.setBoolean(3, d);

			ax.executeUpdate();
			System.out.println("se ha modificado" + "\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			Thread.sleep(2000);
			visualizarSala();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void borrarSala() {
		System.out.println("Id a borrar");
		String a = sc.nextLine();
		try {

			PreparedStatement ax = conect.prepareStatement("DELETE FROM CINE.SALA Where ID=?");
			ax.setString(1, a);
			ax.executeUpdate();
			System.out.println("se borro");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {

			Thread.sleep(2000);
			visualizarSala();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	void visualizarPeliculas() {
		try {

			rst = st.executeQuery("SELECT * FROM CINE.PELICULAS");
			while (rst.next()) {
				System.out.println("IDpeli: " + rst.getInt("IDPelicula") + "\t" + "Titulo: " + rst.getString("Titulo")
						+ "\t" + "Genero: " + rst.getString("Genero") + "\t" + "Rango de edad:"
						+ rst.getInt("RangoEdad") + " años");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	void inserPeliculas() {
		try {
			PreparedStatement a = conect.prepareStatement(
					"INSERT INTO CINE.PELICULAS (Titulo, Genero, Rangoedad)VALUES('Cielo2','Misterio2','18');");
			a.executeUpdate();
			System.out.println("se insertó");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void modPeliculas() {
		visualizarPeliculas();
		System.out.println("Id a modificar");
		String a = sc.nextLine();
		System.out.println("Titulo a modificar");
		String b = sc.nextLine();
		System.out.println("Genero a modificar");
		String c = sc.nextLine();
		System.out.println("Rangoedad a modificar");
		String d = sc.nextLine();

		try {
			PreparedStatement ax = conect.prepareStatement(
					"UPDATE CINE.PELICULAS SET Titulo=?, Genero=?, Rangoedad=? where IDPelicula=" + a);
			ax.setString(1, b);
			ax.setString(2, c);
			ax.setString(3, d);
			ax.executeUpdate();
			System.out.println("se ha modificado" + "\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			visualizarPeliculas();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void borrarPeliculas() {
		System.out.println("Id a borrar");
		String a = sc.nextLine();
		try {
			PreparedStatement ax = conect.prepareStatement("DELETE FROM CINE.PELICULAS Where IDPelicula=?");
			ax.setString(1, a);
			ax.executeUpdate();
			System.out.println("se borro");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(2000);
			visualizarPeliculas();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void cerrar() {
		try {
			conect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
