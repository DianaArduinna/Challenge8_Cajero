package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

	// Atributos

	private String nombre;
	private String apellido;
	private String rut;
	private String fechaDeNacimiento;
	private String nombreEjecutivo;
	private String telefonoEjecutivo;
	private String direccionEjecutivo;

// Constructor

	public Cliente(String nombre, String apellido, String rut, String fechaDeNacimiento, String nombreEjecutivo,
			String telefonoEjecutivo, String direccionEjecutivo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nombreEjecutivo = nombreEjecutivo;
		this.telefonoEjecutivo = telefonoEjecutivo;
		this.direccionEjecutivo = direccionEjecutivo;
	}

	// Getter and Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNombreEjecutivo() {
		return nombreEjecutivo;
	}

	public void setNombreEjecutivo(String nombreEjecutivo) {
		this.nombreEjecutivo = nombreEjecutivo;
	}

	public String getTelefonoEjecutivo() {
		return telefonoEjecutivo;
	}

	public void setTelefonoEjecutivo(String telefonoEjecutivo) {
		this.telefonoEjecutivo = telefonoEjecutivo;
	}

	public String getDireccionEjecutivo() {
		return direccionEjecutivo;
	}

	public void setDireccionEjecutivo(String direccionEjecutivo) {
		this.direccionEjecutivo = direccionEjecutivo;
	}

	// ---------------------Metodos--------------------------------

	// metodo para mostrar info cliente

	public void infocliente() {
		System.out.println("---------------------------------------");
		System.out.println("Rut cliente      :" + this.rut);
		System.out.println("Estimado " + this.nombre + " Que desea hacer?");
		System.out.println("---------------------------------------");
	}

	// ---- Metodo que calcula edad del cliente ------
	public int calcularEdad() {

		LocalDate obj = LocalDate.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // esto sirve para formatear

		String fechaActual = obj.format(myFormatObj);

		String anioActual = fechaActual.substring(6, 10);
		String yOb = this.fechaDeNacimiento.substring(6, 10);
		String mActual = fechaActual.substring(3, 5);
		String mNacimiento = this.fechaDeNacimiento.substring(3, 5);

		int anios = Integer.parseInt(anioActual) - Integer.parseInt(yOb);
		int meses = Integer.parseInt(mActual) - Integer.parseInt(mNacimiento);

		int edad;
		if (meses > 0) {
			edad = anios;
		} else {
			edad = anios - 1;
		}
		return edad;
	}

// Usado para poder mostrar los datos del Ejecutivo	solo seleccionando esos datos
	@Override
	public String toString() {

		return "------------ Datos Ejecutivo ----------\n" + "\nNombre Ejecutivo = " + nombreEjecutivo + "\nTelefono = "
				+ telefonoEjecutivo + "\nDireccion =" + direccionEjecutivo + "\n" + "\nVolviendo al menu principal...";
	}

}
