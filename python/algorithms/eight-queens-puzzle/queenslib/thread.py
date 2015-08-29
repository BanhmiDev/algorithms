#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import time
from PySide.QtCore import QThread, QObject
from PySide import QtCore

class Thread(QThread):

    def __init__(self, parent=None):
        super(Thread, self).__init__(parent)

        self.signal = Signals();
        self.user_delay = 0.2
        self.active_queens = [] # Current active queens
        self.solutions = [] # Field information of each solution

    def run(self):
        self.signal.log.emit("Starting logging...")
       
        # Backtracking
        self.place(0,0)
        while len(self.active_queens) > 0:
            self.place(0,0)

    def place(self, x, y):
        """Place a queen - function going to be recursively used."""
        time.sleep(self.user_delay)

        if self.is_placeable(x,y) == True:
            # Emit graphical change
            self.signal.coordinates.emit(x, y, "queenslib/assets/queen.png")
            # Append to real list
            self.active_queens.append([x,y])

            if len(self.active_queens) == 8:
                # Solution found, append it to our list
                self.solutions.append(self.active_queens)

                # Highlight queens graphically
                for queen in self.active_queens:
                    self.signal.coordinates.emit(queen[0], queen[1], "queenslib/assets/queen_highlight.png")
                
                # Create string for logging
                solution_string = ''.join(str(i) for i in self.solutions[len(self.solutions)-1])
                self.signal.log.emit("\n" + str(len(self.solutions)) + ". Solution: " + solution_string)

                # Highlight by sleeping
                time.sleep(0.5)
                for queen in self.active_queens:
                    self.signal.coordinates.emit(queen[0], queen[1], "queenslib/assets/queen.png")

            # Try to place queen horizontally till the boundary
            else:
                self.place(x+1, 0)
        else:
            # Try to search more solutions by moving the last queen (vertically)
            if y < 7:
                self.place(x, y+1)
            else:
                self.search_deeper()
    
    def is_placeable(self, x, y):
        """Evaluate if queen is placeable."""
        # Vertical check not needed
        # Horizontal check
        for queen in self.active_queens:
            if y == queen[1]:
                return False

        # Check diagonally
        for queen in self.active_queens:
            diff_x = queen[0]-x
            diff_y = queen[1]-y
            if abs(diff_x) == abs(diff_y):
                return False

        return True 

    def search_deeper(self):
        """Solution variations by moving the last active queen."""
        if len(self.active_queens) == 0:
            self.signal.log.emit("\nEnd reached!\nTotal of " + str(len(self.solutions)) + " solutions found.")
            # End-methoden aufrufen
            self.signal.end.emit()

        else:
            # Take last queen from list
            last_queen = self.active_queens[-1]
            # Graphical change
            self.signal.coordinates.emit(last_queen[0], last_queen[1], "")
            # Finally remove the queen
            self.active_queens.pop()
            
            # Recursively until queen reached the bottom
            if last_queen[1] < 7:
                self.place(last_queen[0], last_queen[1]+1)
            else:
                self.search_deeper()

class Signals(QObject):
    coordinates = QtCore.Signal(int, int, str)
    log = QtCore.Signal(str)
    end = QtCore.Signal()
