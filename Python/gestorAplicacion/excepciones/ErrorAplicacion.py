class ErrorAplicacion(Exception):

    mG = "Manejo de errores de la aplicación\n"

    def __init__(self, mensj):
        self.mE =  mensj
        super().__init__(self.mE )

    def getMEspe(self):
        return self.mE 
