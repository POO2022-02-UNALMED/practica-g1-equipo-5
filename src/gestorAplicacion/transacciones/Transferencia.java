package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.Cuenta;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class Transferencia implements Serializable {
	private static int id;
	public static ArrayList <Transferencia> listatr=new ArrayList<>();
	public ArrayList<String> lista= new ArrayList<>();

	public Transferencia (){
		listatr.add(this);

	}	
	public String enviarDinero(Cuenta cuentaOrigen, Cuenta cuentaFinal, int valor) {
		if (cuentaOrigen.getSaldoDisponible() < valor || cuentaOrigen.isEstado()==false) {
			return"No puede hacer la transferencia";
		}
			else {
				cuentaOrigen.disminuirSaldo(valor);
				cuentaFinal.aumentarSaldo(valor);
			setId(getId()+1);
			String fecha= new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			String cta1= String.valueOf(cuentaOrigen.getNumero());
			String cta2= String.valueOf(cuentaFinal.getNumero());
			String val1= String.valueOf(cuentaOrigen.getSaldoTotal());
			String vt= String.valueOf(valor);
			int id1=getId();
			String id11=String.valueOf(id1);
			lista.add(id11);
			lista.add(fecha);
			lista.add(cta1);
			lista.add(cta2);
			lista.add(vt);
			lista.add(val1);

		}
		return verTransferencia();
	}
	public  String verTransferencia() {

		return  "Id transferencia: " + lista.get(0)+
				" Fecha: "+ lista.get(1)+
				" Cuenta origen: "+ lista.get(2) +
				" Cuenta destino: " + lista.get(3) +
				" Valor: " + lista.get(4) +
				" Saldo disponible: " + lista.get(5);
	}
	public static void Movimientos(){
		for (int i=0; i<listatr.size();i++){
			System.out.println(listatr.get(i).verTransferencia());
	}}


	public static int getId() {return  id;}
	public static void setId(int id) {Transferencia.id = id;}

}
