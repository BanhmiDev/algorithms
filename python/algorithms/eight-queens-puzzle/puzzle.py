#!/usr/bin/env python3
# -*- coding: utf-8 -*-

if __name__ == '__main__':
    import sys
    from PySide import QtGui
    from queenslib.main import Mainwindow

    app = QtGui.QApplication(sys.argv)
    mainwindow = Mainwindow()
    sys.exit(app.exec_())
