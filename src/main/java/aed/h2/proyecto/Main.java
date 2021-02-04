package aed.h2.proyecto;

public class Main {

	public static void main(String[] args) {

		try {
			Coneccion conexion =new Coneccion();
			//conexion.probar();
			//conexion.inser();
			//conexion.mod();
			conexion.borrar();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}
