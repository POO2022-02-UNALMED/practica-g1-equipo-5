import pickle
from gestorAplicacion.usuarios.cliente import Cliente
from gestorAplicacion.transacciones.bolsillo import Bolsillo
from gestorAplicacion.transacciones.pago import Pago
from gestorAplicacion.transacciones.transferencia import Transferencia

class Deserializador:
    @classmethod
    def deserializar(cls, tipo):
        if tipo == "Prestamos":
            pickfile = open("baseDatos/temp/prestamos.txt", "rb")
            Cliente.listaCuentas = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Bolsillos":
            pickfile = open("baseDatos/temp/bolsillos.txt", "rb")
            Cliente.listarCuentas().misBolsillos = pickle.load(pickfile)
            pickfile.close

        elif tipo=="Pagos":
            pickfile = open("baseDatos/temp/pagos.txt", "rb")
            Pago.getPagos = pickle.load(pickfile)
            pickfile.close

        elif tipo=="Transferencias":
            pickfile = open("baseDatos/temp/transferencias.txt", "rb")
            Transferencia.lista = pickle.load(pickfile)
            pickfile.close

    def DeserializarTodo():
        Deserializador.deserializar("Prestamos")
        Deserializador.deserializar("Bolsillos")
        Deserializador.deserializar("Pagos")
        Deserializador.deserializar("Transferencias")

