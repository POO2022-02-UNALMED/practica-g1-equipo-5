package gestorAplicacion;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;


public class Multa {
    private int plazoPago;
    private boolean estado;
    private long monto;
    private Cuenta cuenta;
    private int tiempoMulta;
    private String fecha;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public Multa(int plazoPago, boolean estado, long monto, Cuenta cuenta, int tiempoMulta, String fecha){
        this.plazoPago = plazoPago;
        this.estado = estado;
        this.monto = monto;
        this.cuenta = cuenta;
        this.tiempoMulta = tiempoMulta;
        this.fecha = fecha;
    }

    public void eliminarMulta(){
        //se me olvido como hacer lo del garbaje collector :v
    }

    /* Metodo usado para calcular el monto por mora despues de no haber cumplido el
    *   plazoPago. Si la cantidadd de dias despues de haber pasado Plazo pago
    *   es mayor a 90 se Bloquea la targeta pasando Estado:boolean de cuenta a false
    * */
    public void mora(Pago pago){
        long fechaMulta = formato.parse(this.fecha, new ParsePosition(0)).getTime();
        long fechaPago = formato.parse(pago.getFecha(), new ParsePosition(0)).getTime();
        int discriminante = (int) (fechaPago-fechaMulta);
        if (discriminante > this.plazoPago){
            int diasMora = discriminante-this.plazoPago;
            this.setMonto((long) (this.monto*Math.pow(1.01,diasMora))); //aplicar un mora del 1% por dia de mora
            if (diasMora > 90){                 // esto deberia de compararse por ultima fecha de pago y no por los dias de mora
                pago.getCuenta().setEstado(false);
            }
        }
    }
    
    //Setters getters
    public Cuenta getCuenta() {return cuenta;}

    public void setCuenta(Cuenta cuenta) {this.cuenta = cuenta;}

    public long getMonto() {return monto;}

    public void setMonto(long monto) {this.monto = monto;}

    public int getPlazoPago() {return plazoPago;}

    public void setPlazoPago(int plazoPago) {this.plazoPago = plazoPago;}

    public boolean isEstado() {return estado;}

    public void setEstado(boolean estado) {this.estado = estado;}

    public int getTiempoMulta() {return tiempoMulta;}

    public void setTiempoMulta(int tiempoMulta) {this.tiempoMulta = tiempoMulta;}

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {this.fecha = fecha;}
}
