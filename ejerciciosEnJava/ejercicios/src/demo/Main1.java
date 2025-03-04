package demo;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		Scanner sc;
		Integer opcionDada;
		Integer numeroDeCuentaIngresado;

		Boolean bandFuncionamiento;
		Cajero cajero = new Cajero();

		bandFuncionamiento = true;
		sc = new Scanner(System.in);

		System.out.println("\t\tPROGRAMA CAJERO");

		while (bandFuncionamiento) {

			System.out.println("""

					1. Hacer deposito,
					2. Retirar saldo,
					3. Ver la información de las cuentas,
					4. Salir.

					""");
			opcionDada = sc.nextInt();
			if (opcionDada == 1 || opcionDada == 2) {

				System.out.println("Ingrese el # de cuenta para realizar la accion!!!");
				cajero.mostrarLasCuentas();
				System.out.println();
				numeroDeCuentaIngresado = sc.nextInt();

				System.out.print("Ingrese el dinero a ");

				if (opcionDada == 1) {

					System.out.print("depositar: ");
					cajero.hacerDeposito(numeroDeCuentaIngresado - 1, sc.nextInt());

				} else {
					System.out.print("retirar: ");
					cajero.hacerRetiro(numeroDeCuentaIngresado - 1, sc.nextInt());
				}
			} 

			if(opcionDada == 3){
				System.out.println("""
						/* Información de las cuentas
						""");
				cajero.mostrarLasCuentas();
			}
			if(opcionDada == 4){

				bandFuncionamiento = false;
			}
		}

		sc.close();
	}
}

class Cajero {

	private CuentaBancaria arrCuentas[] = new CuentaBancaria[] {

			new CuentaBancaria("Pedro Alvarez"), new CuentaBancaria("Ernesto Saldoval"),
			new CuentaBancaria("Enrique Iglesias"), new CuentaBancaria("Josefina Montes"),
			new CuentaBancaria("Antonio Lopez"), new CuentaBancaria("Juan Castro"), new CuentaBancaria("Sara Jimenez"),
			new CuentaBancaria("Paula Gomez"), new CuentaBancaria("Ricardo Fernandez"),
			new CuentaBancaria("Fernando Torres"), };

	public void hacerRetiro(Integer idx, Integer dineroRetiro) {
		System.out.println("""
				/* Retiro
				""");
		if (idx >= 0 && idx < arrCuentas.length) {
			
			CuentaBancaria cuenta=arrCuentas[idx];
			System.out.print("Buenos Días ");System.out.print(cuenta.getTitular());System.out.println("!!!");
			
			cuenta.retirarSaldo(dineroRetiro);
		} else {
			System.out.println("No existe ese número de cuenta");
		}
	}

	public void hacerDeposito(Integer idx, Integer dineroDeposito) {

		System.out.println("""
				/* Deposito
				""");
		if (idx >= 0 && idx < arrCuentas.length) {
			
			CuentaBancaria cuenta=arrCuentas[idx];
			System.out.print("Buenos Días ");System.out.print(cuenta.getTitular());System.out.println("!!!");
			cuenta.depositarSaldo(dineroDeposito);
		} else {
			System.out.println("No existe ese número de cuenta");
		}
	}

	public void mostrarLasCuentas() {

		for (int i = 0; i < arrCuentas.length; i++) {

			System.out.println(arrCuentas[i]);
		}
	}

}

class CuentaBancaria {

	private String titular = "";
	private Integer saldo = 0;
	private Integer numero = 0;
	private static Integer cantidadCuentas = 0;

	public CuentaBancaria(String owner) {

		this.titular = owner;

		this.numero = ++cantidadCuentas;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void depositarSaldo(Integer saldo) {
		this.saldo += saldo;
		System.out.println("el dinero se ha depositado correctamente!!!");
		System.out.println("SALDO: "+this.saldo);
	}

	public void retirarSaldo(Integer saldo) {

		if ((this.saldo - saldo) < 0) {

			System.out.println("No hay fondos suficientes");
		} else {

			this.saldo -= saldo;
			System.out.println("Retiro exitoso");
			System.out.println("SALDO: "+this.saldo);
		}
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String toString() {
		return "CuentaBancaria numero#" + numero + " [titular=" + titular + ", saldo=" + saldo + "]";
	}
}