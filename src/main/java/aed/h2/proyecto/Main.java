package aed.h2.proyecto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Coneccion conexion =new Coneccion();
			conexion.probar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
