import sys

from PySide6.QtWidgets import (QMainWindow, QApplication)
from PySide6.QtGui import QIcon

from PruebaEstudioDI import Ui_MainWindow

class VentanaPrincipalPruebaEstudio(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(VentanaPrincipalPruebaEstudio, self).__init__()
        self.setupUi(self)
        self.setWindowIcon(QIcon(':iconos/teclado-numerico.png'))
        self.setWindowTitle('Mi ventana con icono')

app = QApplication(sys.argv)
window = VentanaPrincipalPruebaEstudio()
window.show()
app.exec()