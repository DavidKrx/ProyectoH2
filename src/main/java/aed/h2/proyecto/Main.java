package aed.h2.proyecto;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static boolean salirInicio = false;
	public static void main(String[] args) {
		
		while (salirInicio == false) {
			menuInicial();
		}if(salirInicio == true) {
		}	}
	
	private static void menuInicial() {
		H2 base = null;
		
	try {
	base = new H2();	
	System.out.println("\n 1: Visualizar peliculas \n 2: Visualizar salas \n 3: Insertar peliculas \n 4: Insertar Salas \n 5: Borrar peliculas \n 6: Borrar salas \n 7: Modificar peliculas \n 8: Modificar sala \n 9: Salir \n Decide que quiere realizar:");	
				String b=sc.nextLine();
			
				switch (b) {
				
				case "1":
					base.visualizarPeliculas();
					
					break;
				case "2":
					base.visualizarSala();
				
					break;
				case "3":
					base.inserPeliculas();
				
					break;
				case "4":
					base.inserSala();
				
					break;
				case "5":
					base.borrarPeliculas();
				
					break;
				case "6":
					base.borrarSala();
				
					break;
				case "7":
					base.modPeliculas();
				
					break;
				case "8":
						base.modSala();
				
					break;
				case "9":
					salirInicio=true;
					base.cerrar();
					System.exit(0);
					break;
				default:
					base.cerrar();
					break;
				}} catch (ClassNotFoundException e) {
					e.printStackTrace();		
	}}}
