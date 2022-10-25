package gestorAplicacion.usuario;


import baseDatos.Deserializador;
import gestorAplicacion.transacciones.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Cliente implements Serializable,Movimiento {
    private String nombre;
    public Cuenta cuenta;
    public static ArrayList<Cuenta> listaCuentas=new ArrayList<>();
    private int cedula;
    public Transferencia transferencia;
    Random random = new Random();

    public Cliente(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        for (int i=0;i<random.nextInt(2,3);i++) {
            listaCuentas.add(new CuentaAhorro(this, random.nextInt(9000000)));
            listaCuentas.add(new CuentaCorriente(this, random.nextInt(9000000)));
        }
    }

    public static Cuenta buscarCuenta(int id){
        for (Cuenta cuenta : listaCuentas) {
            if (id == listaCuentas.get(listaCuentas.indexOf(cuenta)).getId()) {
                return cuenta;
            }
        }
        return null;
    }
    public static Cuenta listarCuentas(){
        for (Cuenta cuenta : listaCuentas) {
            return cuenta;
        }
        return null;
    }
    public static Bolsillo buscarBolsillo(int id,int idbolsillo){

        Cuenta cuenta = buscarCuenta(id);
        return  cuenta.getMisBolsillos().get(idbolsillo);

        }

    public static Multa buscarMulta(int id,int idMulta){

        CuentaAhorro cuenta = (CuentaAhorro) buscarCuenta(id);
        return cuenta.getMultas().get(idMulta);

    }
    public static Prestamo buscarPrestamo(int id,int idPrestamo){

        CuentaAhorro cuenta = (CuentaAhorro) buscarCuenta(id);
        return cuenta.getPrestamos().get(idPrestamo);

    }


    public String hacerTransferencia (int id,int id1, int valor){
        Cuenta c1 = this.buscarCuenta(id);
        Cuenta c2 = this.buscarCuenta(id1);
        Transferencia tr= new Transferencia ();
        return tr.enviarDinero(c1,c2,valor);
    }

    public void solicitarPrestamo(int valor,String tipoPrestamo,int id){
        if (valor>=Prestamo.topeMin && valor<= Prestamo.topeMax)
            ((CuentaAhorro) buscarCuenta(id)).getPrestamos().add(new Prestamo(valor, ((CuentaAhorro) buscarCuenta(id)), tipoPrestamo));
    }

    public void generarAhorro(int valor,int categoria,int id){
        buscarCuenta(id).getMisBolsillos().add(Bolsillo.crearBolsillo(valor,buscarCuenta(id),categoria));

    }
    public String cargarAhorro(int valor,int idCuenta,int idBolsillo){
        return buscarBolsillo(idCuenta,idBolsillo).cargarBolsillo(valor);
    }

    public String cargarAhorro(int idCuenta,int idBolsillo){
        return buscarBolsillo(idCuenta,idBolsillo).cargarBolsillo();
    }

    public String descargarAhorro(int idCuenta, int IdBolsillo){
        return buscarBolsillo(idCuenta, IdBolsillo).descargarBolsillo();
    }

    public String descargarAhorro(int valor,int idCuenta, int IdBolsillo){
        return buscarBolsillo(idCuenta, IdBolsillo).descargarBolsillo(valor);
    }

    public String hacerPagoPrestamo(int idCuenta, int idPrestamo, int cuota){ //arreglar para arrojar el prestamo numeroDePrestamo
        Pago pago = new Pago((int)(buscarPrestamo(idCuenta,idPrestamo).getValorCuota() * cuota),buscarCuenta(idCuenta),buscarPrestamo(idCuenta,idPrestamo),"Prestamo");
        return pago.RealizarPagoPrestamo(cuota);
    }

    public String hacerPagoPrestamo( int idCuenta, int idPrestamo){ //arreglar para arrojar el prestamo numeroDePrestamo
        Pago pago = new Pago(buscarPrestamo(idCuenta,idPrestamo).getValorPrestamo(),buscarCuenta(idCuenta),buscarPrestamo(idCuenta, idPrestamo),"Prestamo");
        return pago.RealizarPagoPrestamo();
    }

    public String hacerPagoMulta(int idCuenta, int idMulta, int monto){ //arreglar para arrojar el prestamo numeroDeMulta

        Pago pago = new Pago(monto,buscarCuenta(idCuenta),buscarMulta(idCuenta,idMulta),"Multa");

        return pago.realizarPagoMulta(Cliente.buscarMulta(idCuenta,idMulta), monto);
    }

    public String hacerPagoMulta(int idCuenta, int idMulta){ //arreglar para arrojar el prestamo numeroDeMulta

        Pago pago = new Pago( (int) Cliente.buscarMulta(idCuenta,idMulta).getMonto(),buscarCuenta(idCuenta),buscarMulta(idCuenta, idMulta),"Multa");

        return pago.realizarPagoMulta(Cliente.buscarMulta(idCuenta,idMulta));
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public static ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public static void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        Cliente.listaCuentas = listaCuentas;
    }


    public String movimientoTransferencia() {
        for (int i = 0; i < transferencia.listatr.size(); i++) {
            return transferencia.listatr.get(i).verTransferencia();
        }
        return "No tienes movimientos asociados";
    }
    public String movimientoPago() {
        for (Pago pagos : Pago.getPagos()){
        return pagos.getPagos().toString();
        }
    return null;
    }

}
