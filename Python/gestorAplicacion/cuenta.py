import random
class Cuenta:
    id = 1000

    def __int__(self, titular, saldo, tipoCuenta):
        self.titular = titular
        self.saldo = saldo
        self.tipoCuenta = tipoCuenta
        self.saldoTotal = 0
        self.saldoDisponible = 0
        self.misBolsillos = []
        self.estado = True
        self.numero = random.randint(1000,10000)
        Cuenta.id += 1

        def getTitular(self):
            return self.titular

        def setTitular(self, titular):
            self.titular = titular

        def getSaldo(self):
            return self.saldo

        def setSaldo(self, saldo):
            self.saldo = saldo

        def getTipoCuenta(self):
            return self.tipoCuenta

        def setTipoCuenta(self, tipoCuenta):
            self.tipoCuenta = tipoCuenta

        def getSaldoTotal(self):
            return self.saldoTotal

        def setSaldoTotal(self, saldoTotal):
            self.saldoTotal = saldoTotal

        def getSaldoDisponibles(self):
            return self.saldoDisponible

        def setSaldoDisponible(self, saldoDisponible):
            self.saldoDisponible= saldoDisponible

        def getMisBolsillos(self):
            return self.misBolsillos

        def setMisBolsillos(self, misBolsillos):
            self.misBolsillos = misBolsillos






