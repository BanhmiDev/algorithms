#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import re
from PySide import QtGui

class SolutionDialog(QtGui.QDialog):

    def __init__(self):
        super(SolutionDialog, self).__init__()

        self.index = 0 # Index to move between solutions
        self.solutions = [] # Solution list
        self.field = [ [ 0 for i in range(8) ] for j in range(8) ]
        self.background = [ [ 0 for i in range(8) ] for j in range(8) ]

        self.prev_button = QtGui.QPushButton("Previous")
        self.next_button = QtGui.QPushButton("Next")

        self.solution_layout = QtGui.QGridLayout()
        navigation_layout = QtGui.QHBoxLayout()

        self.solution_box = QtGui.QGroupBox("Solution "+ str(self.index+1) + " of  " + str(len(self.solutions)) + " total solutions.")
        self.solution_box.setLayout(self.solution_layout)
        
        # Navigation
        navigation_box = QtGui.QGroupBox("Navigation")
        navigation_box.setLayout(navigation_layout)
        navigation_layout.addWidget(self.prev_button)
        navigation_layout.addWidget(self.next_button)
        
        # Solution/Chessboard
        solution_layout = QtGui.QVBoxLayout()
        solution_layout.addWidget(self.solution_box)
        solution_layout.addWidget(navigation_box)
        self.setLayout(solution_layout)
        
        self.setWindowTitle("Eight Queens Puzzle - Solutions")

        # Signals
        self.prev_button.clicked.connect(self.show_prev)
        self.next_button.clicked.connect(self.show_next)

        # Build rest of UI (chessboard)
        self.build_ui()

        # Fetch log data
        log_file = open('log.txt')
        lines = log_file.readlines()

        for i in range(len(lines)):
            # RegEx coordinates
            regexp = re.findall(r'\[(.*?),\s(.*?)\]', lines[i])
            if regexp:
                self.solutions.append(regexp)

        # Show first solution
        self.show(0)

    def show(self, index):
        """Show solution."""
        self.solution_box.setTitle("Solution "+ str(self.index+1) +" of " + str(len(self.solutions)) + " total solutions.")
        
        for queen in self.solutions[index]:
            self.field[int(queen[0])][int(queen[1])].setPixmap(QtGui.QPixmap("queenslib/assets/queen.png"))

    def show_prev(self):
        """Show previous solution."""
        if self.index > 0:
            # Reset field
            for queen in self.solutions[self.index]:
                self.field[int(queen[0])][int(queen[1])].setPixmap(QtGui.QPixmap(""))
            self.index -= 1
            self.show(self.index)

    def show_next(self):
        """Show next solution."""
        if self.index+1 < len(self.solutions):
            # Reset field
            for queen in self.solutions[self.index]:
                self.field[int(queen[0])][int(queen[1])].setPixmap(QtGui.QPixmap(""))
            self.index += 1
            self.show(self.index)

    def build_ui(self):
        mod = 0
        y = 0

        for i in range(8):
            mod += 1
            y += 1
            x = 0

            for j in range(8):
                x +=1
                
                # Setup graphical chessboard
                self.background[i][j] = QtGui.QLabel('', self)
                self.field[i][j] = QtGui.QLabel('', self)
                self.solution_layout.addWidget(self.background[i][j], x, y)
                self.solution_layout.addWidget(self.field[i][j], x, y)

                if mod % 2 == 0:
                    self.background[i][j].setPixmap(QtGui.QPixmap("queenslib/assets/even.png"))
                    self.field[i][j].setPixmap(QtGui.QPixmap(""))

                else:
                    self.background[i][j].setPixmap(QtGui.QPixmap("queenslib/assets/odd.png"))
                    self.field[i][j].setPixmap(QtGui.QPixmap(""))

                mod += 1
