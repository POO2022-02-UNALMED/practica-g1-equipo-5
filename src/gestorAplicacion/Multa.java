package gestorAplicacion;

public class Multa {
    private int plazoPago;
    private boolean estado;
    private double monto;
    private Cuenta cuenta;
    private int tiempoMulta;

    public Multa(int plazoPago, boolean estado, double monto, Cuenta cuenta, int tiempoMulta){
        this.plazoPago = plazoPago;
        this.estado = estado;
        this.monto = monto;
        this.cuenta = cuenta;
        this.tiempoMulta = tiempoMulta;
    }
    
    //Setters getters

    public Cuenta getCuenta() {return cuenta;}

    public void setCuenta(Cuenta cuenta) {this.cuenta = cuenta;}

    public double getMonto() {return monto;}

    public void setMonto(double monto) {this.monto = monto;}

    public int getPlazoPago() {return plazoPago;}

    public void setPlazoPago(int plazoPago) {this.plazoPago = plazoPago;}

    public boolean isEstado() {return estado;}

    public void setEstado(boolean estado) {this.estado = estado;}

    public int getTiempoMulta() {return tiempoMulta;}

    public void setTiempoMulta(int tiempoMulta) {this.tiempoMulta = tiempoMulta;}
}
