import pickle
from gestorAplicacion.usuarios.cliente import Cliente
from gestorAplicacion.transacciones.bolsillo import Bolsillo
from gestorAplicacion.transacciones.pago import Pago
from gestorAplicacion.transacciones.transferencia import Transferencia


class Serializador:
    @classmethod
    def serializar(cls,tipo):
        if tipo=="Prestamos":
            pickfile = open("baseDatos/temp/prestamos.txt", "wb")
            serializa = Cliente.listaCuentas
            pickle.dump(serializa, pickfile,)
            pickfile.close

        elif tipo=="Bolsillos":
            pickfile = open("baseDatos/temp/bolsillos.txt", "wb")
            serializa = Cliente.listarCuentas().misBolsillos
            pickle.dump(serializa, pickfile)
            pickfile.close
        
        elif tipo=="Pagos":
            pickfile = open("baseDatos/temp/pagos.txt", "wb")
            serializa = Pago.getPagos()
            pickle.dump(serializa, pickfile)
            pickfile.close
        
        elif tipo=="Transferencias":
            pickfile = open("baseDatos/temp/transferencias.txt", "wb")
            serializa = Transferencia.lista
            pickle.dump(serializa, pickfile)
            pickfile.close
        
    def SerializarTodo():
        Serializador.serializar("Prestamos")
        Serializador.serializar("Bolsillos")
        Serializador.serializar("Pagos")
        Serializador.serializar("Transferencias")