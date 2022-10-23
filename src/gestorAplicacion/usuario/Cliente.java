package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.transacciones.Prestamo;

import java.io.Serializable;
import java.util.ArrayList;


public class Cliente implements Serializable {
    public enum TipoCuenta {
        AHORROS, CORRIENTE;
    }
    private String nombre;
    public Cuenta cuenta;
    public static ArrayList<Cuenta> listaCuentas=new ArrayList<>();
    private TipoCuenta tipoCuenta;
    private int cedula;

    public static Cuenta buscarCuenta(int id){
        for (Cuenta cuenta : listaCuentas) {
            if (id == listaCuentas.get(listaCuentas.indexOf(cuenta)).getId()) {
                return cuenta;
            }
        }
        return null;
    }

    /*public static Bolsillo buscarBolsillo(int idCuenta){
        for (Bolsillo bolsillo : buscarCuenta(idCuenta).getMisBolsillos()) {
            if (id == listaCuentas.get(listaCuentas.indexOf(bolsillo)).getId()) {
                return bolsillo;
            }
        }
        return null;
    }*/

    public Cliente(String nombre, int cedula,int tipoCuenta) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipoCuenta = Cliente.TipoCuenta.values()[tipoCuenta];
        /*switch (tipoCuenta) {
            case (0) -> listaCuentas.add(new CuentaAhorro(this));
            case (1) -> listaCuentas.add(new CuentaCorriente(this));
        }*/
        listaCuentas.add(new CuentaAhorro(this));
        listaCuentas.add(new CuentaCorriente(this));
    }
    public int consultarSaldo(){
        return cuenta.getSaldoTotal();
    }
    public void retirarDinero(int valorRetiro){
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible()-valorRetiro);
    }
    public void cosignarDinero(int valoraConsignacion){
        cuenta.setSaldoTotal(cuenta.getSaldoTotal()+valoraConsignacion);
    }

    public void solicitarPrestamo(int valor,String tipoPrestamo, int id) {

        ((CuentaAhorro)buscarCuenta(id)).setPrestamo(new Prestamo(valor, ((CuentaAhorro) buscarCuenta(id)), tipoPrestamo));
    }

    public void generarAhorro(int valor,int categoria,int id){
        buscarCuenta(id).getMisBolsillos().add(Bolsillo.crearBolsillo(valor,buscarCuenta(id),categoria));

    }
    public void cargarAhorro(int valor,int id){
        for (Bolsillo i : cuenta.getMisBolsillos()) {
            if (id==cuenta.getMisBolsillos().get(cuenta.getMisBolsillos().indexOf(i)).getId()){
                i.cargarBolsillo(valor);
            }

        }
    }

    public void cargarAhorro(int id){
        for (Bolsillo i : cuenta.getMisBolsillos()) {
            if (id==cuenta.getMisBolsillos().get(cuenta.getMisBolsillos().indexOf(i)).getId()){
                i.cargarBolsillo();
            }

        }
    }

    public void descargarAhorro(int valor, int id){
        for (Bolsillo i : cuenta.getMisBolsillos()) {
            if (id==cuenta.getMisBolsillos().get(cuenta.getMisBolsillos().indexOf(i)).getId()){
                i.descargarBolsillo(valor);
            }

        }
    }



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

}
