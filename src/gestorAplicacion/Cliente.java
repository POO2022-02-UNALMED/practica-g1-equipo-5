package gestorAplicacion;

public class Cliente {
    private String nombre;
    private Cuenta cuenta;
    private int cedula;

    public Cliente(String nombre, Cuenta cuenta, int cedula) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.cedula = cedula;
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
