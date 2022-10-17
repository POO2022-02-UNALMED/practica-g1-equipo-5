package gestorAplicacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Transferencia extends Movimiento{
	
	HashMap<Integer,ArrayList<Integer>> mov= new HashMap<>	();
	Transferencia (){
	}
	public void consultarMovimientos (int id) {
		System.out.println(mov.get(id));
	}
	
	public void enviarDinero(Cuenta cuentaOrigen,Cuenta cuentaFinal, int valor) {
		
		if (cuentaOrigen.getSaldo() < valor) {
			System.out.println("No tiene suficiente dinero para transferir");
		}
			else {
				String  fecha= new SimpleDateFormat("ddMMyyyy").format(new Date());
				int fecha1= Integer.parseInt(fecha);
				ArrayList<Integer> lista =new ArrayList<>();
				setId(getId()+1);	
				cuentaOrigen.disminuirSaldo(valor);
				cuentaFinal.aumentarSaldo(valor);
				int cta1= cuentaOrigen.getNumero();
				int cta2= cuentaFinal.getNumero();
				int val1= cuentaOrigen.getSaldo();
				
				lista.add(cta1);
				lista.add(cta2);
				lista.add(valor);
				lista.add(val1);
				lista.add(fecha1);
				mov.put(this.getId(),lista );
					
		}	
	}
}

