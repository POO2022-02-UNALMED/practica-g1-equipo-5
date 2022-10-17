package gestorAplicacion;
public class Pago {
    private long monto;
    private int id;
    private String fecha;
    private Cuenta cuenta;

    public Pago(int monto,int id,String fecha, Cuenta cuenta){
        this.monto = monto;
        this.id = id;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    /* Este metodo calcula la diferencia del monto a la hora de pagar una multa
    * separa casos dependiendo si es mayor menor o igual
    * retorna un mensaje dependiendo del caso
    * */
    public String realizarPago(Multa multa){

        multa.mora(this);
        if (!cuenta.isEstado()) {return "su cuenta ha sido bloqueada por reatraso del pago en mora";} //en caso de que el metodo anterior haya dado false evitar problemas de consola

        if (multa.getMonto() < this.monto){
            long devolucion = (this.monto-multa.getMonto());
            multa.eliminarMulta();
            return "su multa fue pagada on exito. Esta es su devolucion: " + devolucion;
        } else if (multa.getMonto() == this.monto) {
            multa.eliminarMulta();
            return "su multa fue pagada con exito";
        } else {
            multa.setMonto(this.monto-multa.getMonto());
            return "Este es su nuevo monto: "+ multa.getMonto();
        }
        // no se si poner que retorne algo para posteriores metodos
    }

    //setters getters

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {this.fecha = fecha;}

    public Cuenta getCuenta() {return cuenta;}

    public void setCuenta(Cuenta cuenta) {this.cuenta = cuenta;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public long getMonto() {return monto;}
    public void setMonto(long monto) {this.monto = monto;}
}
