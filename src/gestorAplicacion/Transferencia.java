package gestorAplicacion;

import java.util.ArrayList;




public class Transferencia {
	private int valor;
	static ArrayList<Integer> lista =new ArrayList<>();
	private int id=0;
	private Cuenta cuentaOrigen;
	private Cuenta cuentaFinal;

	public void enviarDinero(Cuenta cuentaOrigen,Cuenta cuentaFinal, int valor) {
		id= id+1;
		lista.add(id);
		if (cuentaOrigen.getSaldo() < valor) {
			System.out.println("No tiene suficiente dinero para transferir");
		}
			else {
				cuentaOrigen.disminuirSaldo(valor);
				cuentaFinal.aumentarSaldo(valor);	
		}	
		}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	public Cuenta getCuentaFinal() {
		return cuentaFinal;
	}
	public void setCuentaFinal(Cuenta cuentaFinal) {
		this.cuentaFinal = cuentaFinal;
	}
}

