from ErrorAplicacion import ErrorAplicacion

class ErrorValores(ErrorAplicacion):

    def __init__(self, mensj):
        super().__init__("-Verifica que los valores si estén permitidos -\n" + mensj)



