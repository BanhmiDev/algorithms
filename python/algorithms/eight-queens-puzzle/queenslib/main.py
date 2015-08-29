#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from PySide import QtCore, QtGui

from queenslib.thread import Thread

class Mainwindow(QtGui.QWidget):
    
    def __init__(self):
        super(Mainwindow, self).__init__()

        # Initialize field lists
        # field = [
        # [0,0,0,0,0,0,0,0],
        # [0,0,0,0,0,0,0,0],
        # [0,0,0,0,0,0,0,0],
        # [0,0,0,0,0,0,0,0],
        # [0,0,0,0,0,0,0,0],
        # [0,0,0,0,0,0,0,0],
        # [0,0,0,0,0,0,0,0],
        # [0,0,0,0,0,0,0,0]]     
        # => size of 8x8
        # Background will stay the same as the field changes
        self.field =  [[ 0 for i in range(8) ] for j in range(8) ]
        self.background = [ [ 0 for i in range(8) ] for j in range(8) ]

        # Create/reset log file on startup
        open('log.txt', 'w').close()

        # Run backtracking in another thread to prevent GUI from freezing
        self.thread = Thread()
        self.thread.signal.coordinates.connect(self.thread_run)
        self.thread.signal.end.connect(self.thread_finished)
        self.thread.signal.log.connect(self.thread_log)

        self.build_ui()
        self.show()

    def build_ui(self):
        self.magic_button = QtGui.QPushButton("Run")
        self.magic_button.clicked.connect(self.backtrack_start)
        self.solution_button = QtGui.QPushButton("Solutions")
        self.solution_button.setEnabled(False)
        self.solution_button.clicked.connect(self.open_solutions)

        # Console box
        layout_console = QtGui.QFormLayout()
        self.console_box = QtGui.QGroupBox("Console")
        self.console_output = QtGui.QTextEdit()
        self.console_output.insertPlainText("log.txt loaded...\n")
        self.console_output.setReadOnly(True)

        # Auto scroll to bottom
        self.console_output.moveCursor(QtGui.QTextCursor.End)
        layout_console.addRow(self.console_output)
        
        self.console_box.setLayout(layout_console)

        # Main layout
        main_layout = QtGui.QVBoxLayout()
        main_layout.addWidget(self.gui_settings())
        main_layout.addWidget(self.gui_chessboard())
        main_layout.addWidget(self.console_box)
        
        self.setLayout(main_layout)
        
        # Center window
        resolution = QtGui.QDesktopWidget().screenGeometry()
        screenX = (resolution.width()/2) - 200
        screenY = (resolution.height()/2) - 320
        self.move(screenX,screenY)

        self.setFixedSize(400, 600)
        self.setWindowTitle("Eight Queens Puzzle")


    def gui_settings(self):
        """Settings box initialization."""
        box = QtGui.QGroupBox("Settings")
        layout = QtGui.QHBoxLayout()

        delay_input = QtGui.QLineEdit("0.2")
        delay_input.setFixedWidth(40)
        delay_label = QtGui.QLabel("Seconds per Solution")
        delay_input.textChanged.connect(self.thread_delay)

        layout.addWidget(delay_input)
        layout.addWidget(delay_label)
        layout.addWidget(self.magic_button)
        layout.addWidget(self.solution_button)
        box.setLayout(layout)
        return box

    def gui_chessboard(self):
        """Chessboard box initialization."""
        box = QtGui.QGroupBox("Checkboard")
        layout = QtGui.QGridLayout()
        mod = 0
        y = 0

        for i in range(len(self.field)):
            mod += 1
            y += 1
            x = 0

            for j in range(len(self.field[i])):
                x += 1
                
                # Initialize fields
                self.background[i][j] = QtGui.QLabel('', self)
                self.field[i][j] = QtGui.QLabel('', self)

                layout.addWidget(self.background[i][j], x, y)
                layout.addWidget(self.field[i][j], x, y)
                
                # Chessboard pattern
                if mod % 2 == 0:
                    self.background[i][j].setPixmap(QtGui.QPixmap("queenslib/assets/even.png"))
                    self.field[i][j].setPixmap(QtGui.QPixmap(""))
                else:
                    self.background[i][j].setPixmap(QtGui.QPixmap("queenslib/assets/odd.png"))
                    self.field[i][j].setPixmap(QtGui.QPixmap(""))

                mod += 1

        box.setLayout(layout)
        return box

    def thread_finished(self):
        """On finished run."""
        self.solution_button.setEnabled(True)
        self.magic_button.setEnabled(False)

    def thread_run(self, x, y, value):
        """Graphically place queen."""
        self.field[x][y].setPixmap(QtGui.QPixmap(value))

    def thread_log(self, text):
        """Logging in file."""
        log_file = open('log.txt','a+')
        log_file .write(text)
        log_file .close()

        # Graphical indication
        self.console_output.insertPlainText(text)
        # Auto scrolling
        self.console_output.moveCursor(QtGui.QTextCursor.End)
    
    def backtrack_start(self):
        """Do stuff."""
        # ref: http://srinikom.github.io/pyside-docs/PySide/QtCore/QThread.html
        self.thread.start()
    
    def thread_delay(self, value):
        """Update user delay value."""
        self.thread.user_delay = float(value)/10

    def open_solutions(self):
        """Open the solution dialog."""
        from queenslib.dialog.solution import SolutionDialog
        d = SolutionDialog()
        d.exec_()
