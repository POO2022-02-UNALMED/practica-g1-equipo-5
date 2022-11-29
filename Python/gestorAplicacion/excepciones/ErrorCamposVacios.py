from ErrorEjecucion import ErrorEjecucion
class ErrorCamposVacios(ErrorEjecucion):

    def __init__(self):
        super().__init__("Verifica que todos los campos se hayan diligenciado")


