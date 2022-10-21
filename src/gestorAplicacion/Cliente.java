package gestorAplicacion;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private Cuenta cuenta;
    private Bolsillo bolsillo;
    private Prestamo prestamo;
    private int cedula;

    public Cliente(String nombre, Cuenta cuenta, int cedula) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.cedula = cedula;
    }
    public void consultarSaldo(){
        cuenta.getSaldoTotal();
    }
    public void retirarDinero(int valorRetiro){
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible()-valorRetiro);
    }
    public void cosignarDinero(int valoraConsignacion){
        cuenta.setSaldoTotal(cuenta.getSaldoTotal()+valoraConsignacion);
    }
    public void solicitarPrestamo(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}
