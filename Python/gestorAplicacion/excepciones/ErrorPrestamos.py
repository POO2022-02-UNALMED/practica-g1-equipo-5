
# Esta exception es llamada cuando un usuario quiere solicitar un préstamo que no está en el rago permitido

from ErrorValores import ErrorValores

class ErrorPrestamos(ErrorValores):

    def __init__(self):
        super().__init__("El valor que ingresó no está en el rango permitido para un credito. El valor debe estar entre 500.000 y 7'000.000")
