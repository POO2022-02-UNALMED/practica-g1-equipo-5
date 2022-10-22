package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.Cuenta;

public class Pago {
    private long monto;
    private int id;
    private String fecha;
    private Cuenta cuenta;
    private Multa multa;

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
    public String realizarPagoMulta(Multa multa){
        if (!cuenta.tieneMultta()) return "Usted no cuenta con multas actualmente";

        multa.mora(this);

        if (!cuenta.isEstado()) return "su cuenta está bloqueada"; //en caso de que el metodo anterior haya dado false evitar problemas de consola

        if (cuenta.getSaldoDisponible()< monto) return "Saldo insuficiente";

        if (multa.getMonto() == this.monto) {
            multa.eliminarMulta(this.cuenta,this.monto);
            return "su multa fue pagada con exito" +
                    "Este es su nuevo Saldo: "+ multa.getCuenta().getSaldoDisponible();
        } else {
            multa.setMonto(this.monto-multa.getMonto());
            return "Este es su nuevo monto: "+ multa.getMonto();
        }
        // no se si poner que retorne algo para posteriores metodos
    }

    /* Este metodo realiza el pago de prestamo a travez de la consulta del
    * estado saldo y prestamo de cuenta y la consulta de cuotas fechas de pago y los dias de mora de prestamo
    * para al final calcular el nuevo saldo y el estado del prestamo
    * */
    public String RealizarPagoPrestamo(){ //opcion 1 para pagar un prestamo (pago total del prestamo)

        multa.mora(this,cuenta);

        if(!cuenta.isEstado()) return "Su cuenta está bloqueada";

        if(cuenta.getPrestamo()==null) return "Usted no cuenta con deudas pendientes";

        if (cuenta.getPrestamo().getValorPrestamo() <= cuenta.getSaldoDisponible()){

            cuenta.getPrestamo().saldarPrestamo();
            return "Su deuda ha sido saldada" +
                    "\nNuevo saldo: " + cuenta.getSaldoDisponible();

        } else{
            return "Saldo insuficiente";
        }

    }
    /* Este metodo realiza el pago de prestamo a travez de la consulta del
     * estado saldo y prestamo de cuenta y la consulta de cuotas fechas de pago y los dias de mora de prestamo
     * para al final calcular el nuevo saldo y el estado del prestamo
     * */
    public String RealizarPagoPrestamo(int cuotas){ //opcion 2 para pagar un prestamo. pago por x cuotas. dato (int cuotas) introducido por consola. se debe limitar que sea desde 1 hasta 24

        multa.mora(this,cuenta);

        if(!cuenta.isEstado())return "Su cuenta está bloqueada";

        if(cuenta.getPrestamo()==null) return "Usted no cuenta con deudas pendientes";

        if (cuotas > cuenta.getPrestamo().cuotasDePago) return "Valor de cuotas es exedente";

        if (cuenta.getPrestamo().getValorCuota()*cuotas > cuenta.getSaldoDisponible()) return "Saldo insuficiente";

        if (cuotas == cuenta.getPrestamo().cuotasDePago){

            cuenta.getPrestamo().saldarPrestamo();
            return "Su deuda ha sido saldada" +
                    "\nNuevo saldo: " + cuenta.getSaldoDisponible();

        } else {
            cuenta.getPrestamo().saldarCuota(cuotas);
            return "Nuevo saldo: " + cuenta.getSaldoDisponible() +
                    "\nDeuda actual: " + cuenta.getDeuda() +
                    "\nTe Faltan "+ cuenta.getPrestamo().cuotasDePago + "cuotas";
        }

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
