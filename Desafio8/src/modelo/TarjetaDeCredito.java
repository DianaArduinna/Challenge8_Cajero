package modelo;

import java.util.Scanner;

public class TarjetaDeCredito extends Producto {

	// ------------------ Atributos -----------------------
	private double saldoMaximo;

	// ----------------- Constructor ----------------------

	public TarjetaDeCredito(Cliente cliente, String clave, double saldo, double deuda, String idProducto,
			double saldoMaximo) {
		super(cliente, clave, saldo, deuda, idProducto);
		this.saldoMaximo = saldoMaximo;
	}

	// --------------------- Metodos --------------------------

	static Scanner sc = new Scanner(System.in);

	public void mostrarSaldoDeuda() { // solo muestra y override de clase producto
		System.out.println("Numero de cuenta : " + getIdentificador());
		System.out.println("Saldo actual TC  : $" + getSaldo());
		System.out.println("Monto utilizado  : $" + getDeuda());
		System.out.println("Monto total TC   : $" + getSaldoMaximo());

	}

	public void pagoDeuda() {

		System.out.println("Usted ha utilizado " + getDeuda());
		double pagar = 5 * getDeuda() / 100; // 5% de la deuda
		System.out.println("El monto a pagar es : $" + pagar);
		System.out.println("Desea realizar el pago s/n");
		String pagocl = sc.next();

		if (pagocl.equals("s")) {
			saldo = deuda - pagar;
			System.out.println("Pago exitoso.");
			setSaldo(saldo); // setea el nuevo valor
			System.out.println("Su nuevo saldo es : $" + saldo);

		} else {
			System.out.println("Recuerde pagar en otra oportunidad.");
		}
	}

	// ---------------- Getters and Setters --------------------

	public double getSaldoMaximo() {
		return saldoMaximo;
	}

	public void setSaldoMaximo(double saldoMaximo) {
		this.saldoMaximo = saldoMaximo;
	}

}
