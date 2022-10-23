package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.Cuenta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Transferencia {
	private String fecha;
	public Cuenta cuenta;
	private static  int id;
	public static ArrayList <ArrayList<String>> listaM=new ArrayList<>();
	public Transferencia (){
	}	
	public void enviarDinero(Cuenta cuentaOrigen, Cuenta cuentaFinal, int valor) {
		
		if (cuentaOrigen.getSaldoDisponible() < valor || cuentaOrigen.isEstado()== false) {
			System.out.println("No puede hacer la transferencia");
		}
			else {
				String  fecha= new SimpleDateFormat("ddMMyyyy").format(new Date());
				
				ArrayList<String> lista =new ArrayList<>();
				setId(getId()+1);	
				cuentaOrigen.disminuirSaldo(valor);
				cuentaFinal.aumentarSaldo(valor);
				String cta1= String.valueOf(cuentaOrigen.getNumero());
				String cta2= String.valueOf(cuentaFinal.getNumero());
				String val1= String.valueOf(cuentaOrigen.getSaldoDisponible());
				String vt= String.valueOf(valor);
				int id1=getId();
				String id11=String.valueOf(id1);
				lista.add("id: " + id11);
				lista.add("fecha: "+fecha);
				lista.add("cuenta origen: "+cta1);
				lista.add("cuenta destino: "+cta2);
				lista.add("Cantidad tranferir: "+vt);
				lista.add("total cuenta: "+val1);
				listaM.add(lista);
					
		}	
	}
	public static void consultarMovimientos() {
		System.out.println(listaM);
	}
	
	public static int getId() {return  id;}
	public static  void setId(int id) {Transferencia.id = id;}
	public String getFecha() {return fecha;}
	public void setFecha(String fecha) {this.fecha = fecha;}
	

}	
