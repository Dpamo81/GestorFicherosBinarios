import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
//	Declaracion de variables.
		int opcion = 0;
		int np = 0;
		int i = 0;
		String ruta ="";
		String nombre ="";
		String apellido ="";
		String ciudad="";
		String nacionalidad="";
		int edad =0;
		
		Scanner edd = new Scanner(System.in);
		
		do {
			System.out.println("**************************************");
			System.out.println("***   GESTOR DE ARCHIVOS BINARIOS  ***");
			System.out.println("**************************************");
			System.out.println("**************************************");
			System.out.println("");
			System.out.println("");
			System.out.println("   1.- Alamcenar Personas.");
			System.out.println("   2.- Leer todo el archivo binario.");
			System.out.println("   0.- Salir.");
			opcion = edd.nextInt();
			edd.nextLine();
//			Almacenamos persona.
			if (opcion==1) {
				System.out.println("Introduzca ruta y nombre de archivo.");
				ruta = edd.nextLine();
				File f = new File(ruta);
//				Comprovamos si el archivo existe.
				if (!f.exists()) {
					System.out.println("introduzca el numero de personas que desee añadir.");
					np = edd.nextInt();
					edd.nextLine();
					for (i = 0 ; i<= np ; i++) {
						System.out.println("Introduzca el nombre de la persona: ");
						nombre = edd.nextLine();
						System.out.println("Introduzca el apellido de la persona: ");
						apellido = edd.nextLine();
						System.out.println("Introduzca la ciudad de la persona: ");
						ciudad = edd.nextLine();
						System.out.println("Introduzca la nacionalidad de la persona: ");
						nacionalidad = edd.nextLine();
						System.out.println("Introduzca la edad de la persona: ");
						edad = edd.nextInt();
						edd.nextLine();
//						Creamos un objeto persona.						
						Persona p1 = new Persona(nombre,apellido,ciudad,nacionalidad,edad);
//						creamos un objeto para abrir el archivo en modo escritura.
						FileOutputStream fos = new FileOutputStream(f,true);
//						Creamos un objeto para introducir lo leido en el objeto.
						ObjectOutputStream oos = new ObjectOutputStream(fos);
//						Introducimos en el objeto los datos de p1.
						oos.writeObject(p1);
//						Cerramos los objetos.						
						oos.close();
						fos.close();
						i++;			
					}
				}else {
					System.err.println("No se ha podido crear el archivo.");
				}			
			}else if(opcion ==2) {
				System.out.println("***   Lectura de archivos   ***");
				System.out.println("Elija una opción:");
				System.out.println("   1.-Leer todo el archivo.");
				System.out.println("   2.-Buscar persona.");
				opcion=edd.nextInt();
				edd.nextLine();
//				Leer todo el archivo.			
				if(opcion==1) {
					System.out.println("Introduzca el nombre del archivo a leer.");
					edd.nextLine();
					ruta=edd.nextLine();
//					Creamos un objeto file.
					File f = new File(ruta);
//					Creamos un objeto para abrir el archivo en modo lectura lectura.
					FileInputStream fis = new FileInputStream(f);
//					Creamos un objeto para leer el archivo.
					ObjectInputStream ois = new ObjectInputStream(fis);
//					Creamos un objeto persona.
					Persona p1 = null;
//					Creamos un bucle para leer los datos.
					while(fis.available()>0) {
//						Leemos una persona y la introducimos en el objeto.
						p1=(Persona)ois.readObject();
//						Mostramos resultados por pantalla.
						System.out.println(p1.print());
					}
//					Cerramos los objetos.
					ois.close();
					fis.close();
//				Opcion de buscar en binario.
				}else if(opcion==2) {
					String n="";
					System.out.println("Introduca el nombre del archivo.");
					ruta= edd.nextLine();
					System.out.println("Intorduzca el nombre a buscar");
					n = edd.nextLine();
					File f = new File(ruta);
//					Comprovamos si existe.
					if (f.exists()) {
//						Creamos un objeto para abrir el archivo en modo lectura lectura.
						FileInputStream fis = new FileInputStream(f);
//						Creamos un objeto para leer el archivo.
						ObjectInputStream ois = new ObjectInputStream(fis);
//						Creamos un objeto persona.
						Persona p1 = null;
//						Leemos una persona y la introducimos en el objeto.
						while(fis.available()>0) {
							p1=(Persona)ois.readObject();
//							Comparamos lo que leemos con el nombre a buscar y lo imprimimos por pantalla
							if(p1.getNombre().equalsIgnoreCase(n)) {
								System.out.println(p1.print());
							}
						}
//						Cerramos los objetos.
						fis.close();
						ois.close();
					}else {
						System.err.println("Archivo no existe.");
					}
				}
			}
		}while (opcion!=0);		
	}
}
