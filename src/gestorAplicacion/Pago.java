package gestorAplicacion;

public class Pago {
    private int monto;
    private int id;
    private String fecha;
    private Cuenta cuenta;

    public Pago(int monto,int id,String fecha, Cuenta cuenta){
        this.monto = monto;
        this.id = id;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    //setters getters

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {this.fecha = fecha;}

    public Cuenta getCuenta() {return cuenta;}

    public void setCuenta(Cuenta cuenta) {this.cuenta = cuenta;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getMonto() {return monto;}

    public void setMonto(int monto) {this.monto = monto;}
}
