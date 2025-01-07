import sys

from PySide6.QtWidgets import (QMainWindow, QApplication)
from PySide6.QtGui import QIcon

from Formulario import Ui_MainWindow
import resources
class VentanaPrincipalPruebaEstudio(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(VentanaPrincipalPruebaEstudio, self).__init__()
        self.setupUi(self)
        self.setWindowIcon(QIcon(':icons/formularios-de-google.png'))

app = QApplication(sys.argv)
window = VentanaPrincipalPruebaEstudio()
window.show()
app.exec()