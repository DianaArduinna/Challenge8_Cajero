package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Cliente;
import modelo.CuentaCorriente;
import modelo.Producto;
import modelo.TarjetaDeCredito;

public class Main1 {

	static ArrayList<Cliente> clientes = new ArrayList<>();
	static ArrayList<Producto> productos = new ArrayList<>();
	static CuentaCorriente cuenta;
	static TarjetaDeCredito cuentatc;

	public static void main(String[] args) {

		lista();

		System.out.println("******* Bienvenido a SafeBank *********");
		System.out.println("---------------------------------------");
		Cliente cliente = claveVerifica(productos); // metodo de verificacion de cliente

		System.out.println();
		if (cliente != null) {
			menuPrincipal(cliente);
		}
		System.out.println();

	}

	// *********************** Metodos ***************************

	// ----------------------Metodo Lista--------------------------
	public static void lista() {
		// Acá tienes el método que va completando los arreglos de Cliente y Producto

		clientes.add(new Cliente("Marcelo", "Morales", "73830332", "02/10/1956", "Daniel Silva", "+5695667875",
				"Sucursal Santiago"));
		clientes.add(new Cliente("Carmen", "Rojas", "173871008", "05/12/1989", "Maria Mora", "+5695667875",
				"Sucursal Providencia"));
		clientes.add(new Cliente("Victor", "Oses", "195874567", "30/10/1996", "Daniel Silva", "+5695667875",
				"Sucursal Santiago"));

		// cc (Cliente cliente, String clave, double saldo, double deuda, String
		// idProducto)
		productos.add(new CuentaCorriente(clientes.get(0), "0332", 250000, 15000, "00-7387033"));
		// tc (Cliente cliente, String clave, double saldo, double deuda, String
		// idProducto, double saldoMaximo)
		productos.add(new TarjetaDeCredito(clientes.get(0), "0332", 300000, 100000, "01-7387033", 400000));
		productos.add(new CuentaCorriente(clientes.get(1), "1008", 250000, 15000, "00-17387100"));
		productos.add(new TarjetaDeCredito(clientes.get(1), "1008", 300000, 100000, "01-17387100", 400000));
		productos.add(new CuentaCorriente(clientes.get(2), "4567", 750000, 15000, "00-19587456"));
		productos.add(new TarjetaDeCredito(clientes.get(2), "4567", 300000, 100000, "01-19587456", 400000));

	}

	// ----------------------Metodo Verificacion Rut y
	// Clave--------------------------
	// Arreglo verificacion de clave
	static Scanner sc = new Scanner(System.in);

	public static Cliente claveVerifica(ArrayList<Producto> productos) {

		Scanner sc = new Scanner(System.in); // mantiene el error debido al cierre, pero si se cierra se cae el menu
		System.out.println("Ingrese rut sin puntos ni guion : ");
		String rut = sc.nextLine();
		System.out.println("Ingrese clave : ");
		String clave = sc.nextLine();

		boolean entra = false;
		Cliente cliente = null;

		/*
		 * Revisa producto por producto tomando la informacion de cliente y comparando
		 * el rut con el rut ingresado
		 */
		for (Producto producto : productos) {
			if (producto.getCliente().getRut().equals(rut)) {// funciona
				if (producto.checkPassword(clave)) {
					entra = true;
					cliente = producto.getCliente();
				}
			}
		}
		if (entra) {
			System.out.println("* Acceso Permitido *");
		} else {
			System.out.println("Rut o clave incorrecta. Intente nuevamente");
		}

		// sc.close(); no esta cerrado debido a que da error en menu
		return cliente;

	}

	// ------------------ Menu Principal -----------------------------

	static void menuPrincipal(Cliente cliente) { // metodo
		System.out.println("---------------------------------------");
		System.out.println("****************SafeBank***************");// agregar el nombre de la persona y edad
		System.out.println("---------------------------------------");
		System.out.println("Bienvenido " + cliente.getNombre() + " " + cliente.getApellido());
		System.out.println("Edad : " + cliente.calcularEdad() + " años");
		System.out.println("---------------------------------------");

		// boolean salir = false;

		String opcion = ""; // Guardar la opcion del usuario

		// while (!salir) {
		System.out.println();
		System.out.println("1. Cuenta Corriente ");
		System.out.println("2. Tarjeta de Credito ");
		System.out.println("3. Mi Ejecutivo");
		System.out.println("4. Salir");
		System.out.println();

		try {
			Scanner sn = new Scanner(System.in);
			System.out.println("Que desea hacer? Seleccione una opcion ");
			while (opcion.equals("")) {
				opcion = sn.nextLine();
			}

			// sn.close(); comentado por la misma razon anterior. error
			switch (opcion) {
			case "1": // ingresa a menu cuenta corriente
				menuCuentaC(cliente);
				break;
			case "2": // ingresa a menu tarjeta de credito
				menuTarCredito(cliente);
				break;
			case "3":
				// muestra datos del ejecutivo desde cliente por medio de toString y vuelve al
				// menu principal
				System.out.println(cliente.toString());
				menuPrincipal(cliente);

				break;
			case "4":
				System.out.println("***************************************");
				System.out.println("******* Gracias, vuelva pronto. *******");
				System.out.println("***************************************");
				break;
			default:
				System.out.println("Seleccione una opcion valida");
				menuPrincipal(cliente);

			}
		} catch (InputMismatchException e) {
			System.out.println("Debe selecionar una opcion valida");
			menuPrincipal(cliente);
			// }
		}

	}// end method

	// --------------- Menu Cuenta Corriente -----------------------------

	static void menuCuentaC(Cliente cliente) { // metodo
		System.out.println("---------------------------------------");
		System.out.println("----------- Cuenta Corriente ----------");
		System.out.println("---------------------------------------");

		/*
		 * Busca producto por producto, compara que sea el mismo cliente y luego obtiene
		 * los datos de esa cuenta
		 */
		/*
		 * CuentaCorriente cuenta; --> instancia comentada por probabilidades de no
		 * lectura esta escrito sobre el main por razones de acceso global
		 */
		for (Producto producto : productos) {
			if (producto.getCliente() == cliente && producto.getClass().equals(CuentaCorriente.class)) {
				cuenta = (CuentaCorriente) producto;
				cuenta.mostrarSaldoDeuda(); // accede a los metodos de la clase CuentaCorriente
			}
		}
		cliente.infocliente(); // accede a la clase cliente y muestra sus datos

		Scanner sr = new Scanner(System.in);
		int opcioncc; // Guardar la opcion del usuario
		System.out.println();
		System.out.println("1. Volver al Menu Principal ");
		System.out.println("2. Retirar mi dinero ");
		System.out.println("3. Pagar mensualidad ");
		System.out.println("4. Abonar a mi cuenta");
		System.out.println("");
		try {
			System.out.println("");
			System.out.println();
			opcioncc = sr.nextInt();
			switch (opcioncc) {
			case 1:
				menuPrincipal(cliente); // vuelve a menu principal
				break;
			case 2:
				cuenta.retirar(); // ingresa a clase cuenta corriente y acciona metodo retirar dinero
				menuCuentaC(cliente); // cuando finaliza vuelve al menu cc
				break;
			case 3:
				cuenta.pagoMensual(); // ingresa a clase cuenta corriente y acciona metodo pago mensualidad cuenta
				menuCuentaC(cliente);
				break;
			case 4:
				cuenta.deposit(); // ingresa a clase Cuenta Corriente y acciona metodo deposito de dinero
				menuPrincipal(cliente);
				break;

			default:
				System.out.println("Seleccione una opcion valida");
				menuCuentaC(cliente);
			}
		} catch (InputMismatchException e) {
			System.out.println("Debe selecionar una opcion valida");
			menuCuentaC(cliente);
		}

		// sr.close();
	}// end method

	// --------------- Menu Tarjeta de Credito -----------------------------
	static void menuTarCredito(Cliente cliente) { // metodo
		System.out.println("---------------------------------------");
		System.out.println("---------- Tarjeta de Credito ---------");
		System.out.println("---------------------------------------");

		for (Producto producto : productos) {
			if (producto.getCliente() == cliente && producto.getClass().equals(TarjetaDeCredito.class)) {
				cuentatc = (TarjetaDeCredito) producto;
				cuentatc.mostrarSaldoDeuda(); // ingresa a los datos de saldo y deuda en TC
			}
		}
		cliente.infocliente();

		Scanner sm = new Scanner(System.in);
		int opciontc; // Guardar la opcion del usuario

		System.out.println();
		System.out.println("1. Volver al Menu Principal ");
		System.out.println("2. Pagar mi deuda ");
		try {
			System.out.println("");
			System.out.println();
			opciontc = sm.nextInt();
			switch (opciontc) {
			case 1:
				menuPrincipal(cliente); // vuelve a menu principal
				break;
			case 2:
				cuentatc.pagoDeuda(); // Ingresa a clase TarjetadeCredito y acciona metodo pago deuda
				menuPrincipal(cliente);
				break;

			default:
				System.out.println("Seleccione una opcion valida");
				menuTarCredito(cliente);
			}
		} catch (InputMismatchException e) {
			System.out.println("Debe selecionar una opcion valida");

		}
		// sm.close();
	}// end method

}
