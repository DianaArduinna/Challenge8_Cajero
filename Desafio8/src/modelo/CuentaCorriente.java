package modelo;

import java.util.Scanner;

public class CuentaCorriente extends Producto {

	// ----------------- Constructor ----------------------

	// Constructor heredado del super producto
	public CuentaCorriente(Cliente cliente, String clave, double saldo, double deuda, String idProducto) {
		super(cliente, clave, saldo, deuda, idProducto);

	}

	// --------------------- Metodos --------------------------
	static Scanner sc = new Scanner(System.in); // Scanner statico para evitar errores de sc.close y para que sea
												// accedido de forma general

	public void mostrarSaldoDeuda() { // Metodo para mostrar el saldo, la deuda y el id
		System.out.println("Numero de cuenta   : " + getIdentificador());
		System.out.println("Saldo actual       : $" + getSaldo());
		System.out.println("Mensualidad a pagar: $" + getDeuda()); // mensualidad que se debe pagar no deuda como tal
	}

	public void deposit() { // creado para abonar dinero de la cuenta
		System.out.print("Ingrese la cantidad a abonar : ");
		double abono = sc.nextDouble();
		System.out.println("Se han abonado " + abono + " a su cuenta.");
		saldo = this.saldo + abono;
		System.out.println("Su saldo actual es : $" + saldo);
		System.out.println();
		setSaldo(saldo);

	}

	public void retirar() {
		System.out.printf("Ingrese la cantidad a retirar : $");
		// Scanner sc = new Scanner(System.in);
		double retiro = sc.nextDouble();
		if (retiro >= 0.00 && retiro <= this.saldo) { // Comprueba que no exceda el maximo de la cuenta al momento de
														// retirar
			saldo = this.saldo - retiro;
			setSaldo(saldo);
			System.out.println("Dinero retirado con exito.");
			System.out.println("Su saldo actual es : $" + saldo);
			System.out.println();
		} else {
			System.out.println("Excede el máximo\n");
			System.out.println();
		}
	}

	public void pagoMensual() { // para pagar la mensualidad de cc

		System.out.println("El monto de su cargo mensual es : $" + getDeuda());
		System.out.print("El pago se descontara de su cuenta.\nDesea realizar el pago s/n");
		System.out.println();
		String pagocliente = sc.next();
		if (pagocliente.equals("s")) {
			saldo = saldo - deuda; // resta el dinero del saldo
			setSaldo(saldo);
			double deudacero = deuda - deuda; // deja el monto mensualidad en cero
			setDeuda(deudacero);
			System.out.println("Mensualidad pagada exitosamente\nSu saldo actual es :" + saldo);
			System.out.println();
			System.out.println("Redirigiendo a menu\n");
			System.out.println();
		} else {
			System.out.println("Redirigiendo a menu\n");
			System.out.println();

		}

	}

}
