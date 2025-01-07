import sys
from PySide6 import QtWidgets
from PySide6.QtWidgets import QApplication
from PySide6.QtUiTools import QUiLoader
import resources
loader = QUiLoader()
app = QApplication(sys.argv)
window = loader.load("Formulario.ui", None)
window.show()
app.exec()