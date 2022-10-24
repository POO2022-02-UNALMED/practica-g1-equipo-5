package gestorAplicacion.transacciones;

//import gestorAplicacion.Transferencia;
import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;

public  class Movimiento {
	private String tipoMovimiento;
	private String fecha;
	private Cuenta cuenta;

	public static  void consultarTransferencias () {
		Transferencia.Movimientos();
		}


	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}		
	}


