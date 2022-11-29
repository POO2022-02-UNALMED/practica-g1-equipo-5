# Exception ErrorEjecucion

# Esta clase/exception es la clase padre de todos los errores que producen (o pueden producir más adelante) un error que fuerce a
# detener la ejecución del programa por errores sintácticos o semánticos. 

from ErrorAplicacion import ErrorAplicacion

class ErrorEjecucion(ErrorAplicacion):

    def __init__(self, mensj):
        super().__init__(" Se ha generado un error en la ejecución \n" + mensj)



