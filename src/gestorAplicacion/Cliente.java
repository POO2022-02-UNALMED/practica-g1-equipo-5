package gestorAplicacion;

public class Cliente {
    private String name;
    private Cuenta cuenta;
    private Tarjeta tarjeta;

    public Cliente(String name, Cuenta cuenta, Tarjeta tarjeta) {
        this.name = name;
        this.cuenta = cuenta;
        this.tarjeta = tarjeta;
    }
    //Metodos
    public void consultarSaldo(){
        if(cuenta.isEstado()){
            System.out.println("Su saldo es de: " + cuenta.getSaldo() + "pesos.");
        }
        else {
            System.out.println("Su cuenta está ináctiva");
        }
    }

    public void retirarDinero( int cantidad){
        if (cantidad < cuenta.getSaldo() && cuenta.isEstado()){
            cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            System.out.println("Se ha retirado la cantidad " + cantidad);
        }
    }

    public void enviarDinero(){

    }

    public void pagarDeuda(){

    }
    
    //getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
