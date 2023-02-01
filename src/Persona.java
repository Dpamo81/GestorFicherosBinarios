import java.io.Serializable;

public class Persona implements Serializable{
//	Atributos de la clase Persona.	
	protected String nombre;
	protected String apellido;
	protected String ciudad;
	protected String nacionalidad;
	protected int edad;
//	Constructor
	public Persona (String nombre, String apellido, String ciudad, String nacionalidad, int edad) {
		this.nombre= nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
	}
//	getters and setters.
	public String getNombre() {
		return nombre;
	}
	public void setNombre (String nombre) {
		this.nombre= nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void seetCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
//	Metodos	
	public String print() {
		String cadena = this.getNombre() +" "+ this.getApellido() +" "+ this.getCiudad() +" "+ this.getNacionalidad() +" "+ this.getEdad();
		return cadena;
	}
	
}
