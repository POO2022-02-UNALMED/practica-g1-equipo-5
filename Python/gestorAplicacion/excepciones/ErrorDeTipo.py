
# Es llamada cuando el tipo de dato  no corresponde al tipo de dato esperado 

from ErrorEjecucion import ErrorEjecucion
class ErrorDeTipo(ErrorEjecucion):

    def __init__(self, indicacionError):
        super().__init__(indicacionError)
