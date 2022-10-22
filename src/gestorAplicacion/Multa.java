package gestorAplicacion;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;


public class Multa {
    public static final int plazoPago = 30;
    private boolean estado;
    private long monto;
    private Cuenta cuenta;
    private int tiempoMulta;
    private String fecha;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public Multa(){
        this(null);
    }

    public Multa (Cuenta cuenta){
        this(true, 50000, cuenta,4,"24/10/2022");
    }

    public Multa( boolean estado, long monto, Cuenta cuenta, int tiempoMulta, String fecha){

        this.estado = estado;
        this.monto = monto;
        this.cuenta = cuenta;
        this.tiempoMulta = tiempoMulta;
        this.fecha = fecha;
    }

    public void eliminarMulta(Cuenta cuenta,long monto){
        cuenta.setMulta(null);
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible()-((int) monto));
    }

    public void multarCuenta(Cuenta cuenta){
        if (!cuenta.tieneMultta()){
        cuenta.setMulta(new Multa(cuenta));
        } else {
            cuenta.setEstado(false);
        }
    }

    /* Metodo usado para calcular el monto por mora despues de no haber cumplido el
    *   plazoPago. Si la cantidad de dias despues de haber pasado Plazopago
    *   es mayor a 90 se Bloquea la cuenta pasando Estado:boolean a false
    * */
    public void mora(Pago pago){
        long fechaMulta = formato.parse(this.fecha, new ParsePosition(0)).getTime(); // fecha a entero (en milisegundos desde 1970)
        long fechaPago = formato.parse(pago.getFecha(), new ParsePosition(0)).getTime();
        long discriminante =  (fechaPago-fechaMulta)/86400000;

        if (discriminante > plazoPago){
            long diasMora = discriminante- plazoPago;
            this.setMonto((long) (this.monto*Math.pow(1.01,diasMora))); //aplicar un mora del 1% por dia de mora

            if (diasMora > 90){                 // esto deberia de compararse por ultima fecha de pago y no por los dias de mora
                multarCuenta(pago.getCuenta());
            }
        }
    }
    /* Metodo usado para calcular el monto por mora despues de no haber cumplido el
     *   fechaPago del prestamo. Si la cantidad de dias despues de haber pasado fechaPago
     *   es mayor a 90 se multa la cuenta pasando Multa:boolean a true y generando una nueva multa
     * */
    public void mora(Pago pago,Cuenta cuenta){
        long fechaMulta = formato.parse(cuenta.getPrestamo().getFechaPago(), new ParsePosition(0)).getTime(); // fecha a entero (en milisegundos desde 1970)
        long fechaPago = formato.parse(pago.getFecha(), new ParsePosition(0)).getTime();
        long discriminante =  (fechaPago-fechaMulta)/86400000;

        if (discriminante > plazoPago) {
            long diasMora = discriminante - plazoPago;
            cuenta.setDeuda((int) (cuenta.getDeuda() * Math.pow(1.01, diasMora))); //aplicar un mora del 1% por dia de mora

            if (diasMora > 90){                 // esto deberia de compararse por ultima fecha de pago y no por los dias de mora
                multarCuenta(cuenta);
            }
        }
    }


    
    //Setters getters
    public Cuenta getCuenta() {return cuenta;}

    public void setCuenta(Cuenta cuenta) {this.cuenta = cuenta;}

    public long getMonto() {return monto;}

    public void setMonto(long monto) {this.monto = monto;}

    public boolean isEstado() {return estado;}

    public void setEstado(boolean estado) {this.estado = estado;}

    public int getTiempoMulta() {return tiempoMulta;}

    public void setTiempoMulta(int tiempoMulta) {this.tiempoMulta = tiempoMulta;}

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {this.fecha = fecha;}
}