#!/usr/bin/env python3

"""
Node object
"""

class Node(object):

    def __init__(self, value, left=None, right=None):
        self.left = left
        self.right = right
        self.value = value

    def __str__(self):
        return "Value %s" % self.value;

    def insert_child(self, value):
        if self.value > value:
            if self.left is None:
                self.left = Node(value)
            else:
                self.left.insert_child(value)
        else:
            if self.right is None:
                self.right = Node(value)
            else:
                self.right.insert_child(value)
