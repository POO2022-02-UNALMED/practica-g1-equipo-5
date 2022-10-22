package gestorAplicacion.transacciones;


import gestorAplicacion.usuario.Cuenta;

public abstract class Movimiento {
	private String tipoMovimiento;
	private String fecha;
	private Cuenta cuenta;
	private static int id;
	private int valor;
	
	public abstract void consultarMovimientos (int id);

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Movimiento.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
				
				
	}

