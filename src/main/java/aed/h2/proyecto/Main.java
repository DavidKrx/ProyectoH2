package aed.h2.proyecto;

public class Main {

	public static void main(String[] args) {

		try {
			//Coneccion conexion =new Coneccion();
			//conexion.probar();
			//conexion.inser();
			//conexion.mod();
			//conexion.borrar();
			H2 salsa=new H2();
			//salsa.probar();
			//salsa.inser();
			//salsa.mod();
			salsa.borrar();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}
