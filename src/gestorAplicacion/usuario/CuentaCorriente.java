package gestorAplicacion.usuario;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(Cliente titular,int saldo) {
        super(titular,saldo,"Corriente");
    }

    @Override
    public void aumentarSaldo(int cantidad) {
        if (isEstado()){
            setSaldoTotal(getSaldoTotal() + cantidad);
        }
    }

    @Override
    public void disminuirSaldo(int cantidad) {
        if (isEstado() && (getSaldoDisponible() >= cantidad)){
            setSaldoTotal(getSaldoTotal() - cantidad);
        }
    }

    @Override
    public String toString() {
        if (isEstado()){
            return "Cuenta (Corriente) -> ID = "+getId() + ":" + "\n"+
                    "Saldo total=" + saldoTotal +
                    ", Saldo disponible=" + saldoDisponible +
                    ", Estado=Activo" ;
        }
        else {
            return "Cuenta (Corriente) -> ID = "+getId() + ":" + "\n"+
                    "Saldo total=" + saldoTotal +
                    ", Saldo disponible=" + saldoDisponible +
                    ", Estado=Inactivo";

        }
    }
}
