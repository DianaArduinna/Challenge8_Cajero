package modelo;

public class Producto {

	protected Cliente cliente;
	protected String clave;
	protected double saldo;
	protected double deuda;
	protected String idProducto;

	// Constructor
	public Producto(Cliente cliente, String clave, double saldo, double deuda, String idProducto) {
		this.cliente = cliente;
		this.clave = clave;
		this.saldo = saldo;
		this.deuda = deuda;
		this.idProducto = idProducto;

	}

	// Methods

	public void mostrarSaldoDeuda() { // solo muestra informacion en cc y tc

	}

	// metodo que revisa clave comparando la informacion ingresada con la alojada en
	// clave
	public boolean checkPassword(String clave) {
		return this.clave.equals(clave);
	}

	// Getters and Setter

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public String getIdentificador() {
		return idProducto;
	}

	public void setIdentificador(String identificador) {
		this.idProducto = identificador;
	}

}
