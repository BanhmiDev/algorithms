#!/usr/bin/env python3

from node import Node

"""
Binary search tree implementation
"""

class BinarySearchTree(object):

    def __init__(self, root=None):
        self.root = root

    def get_inorder(self, node, values):
        if node is not None:
            self.get_inorder(node.left, values)
            values.append(node.value)
            self.get_inorder(node.right, values)

    def get_preorder(self, node, values):
        if node is not None:
            values.append(node.value)
            self.get_preorder(node.left, values)
            self.get_preorder(node.right, values)

    def get_postorder(self, node, values):
        if node is not None:
            self.get_postorder(node.left, values)
            self.get_postorder(node.right, values)
            values.append(node.value)

    def values(self, order="inorder"):
        values = [] # Save values in list to print out
        if order == "inorder":
            self.get_inorder(self.root, values)
        elif order == "preorder":
            self.get_preorder(self.root, values)
        else:
            self.get_postorder(self.root, values)
        return values
    
    def insert(self, value):
        if self.root is None:
            self.root = Node(value)
        else:
            self.root.insert_child(value)

# Testing
bst = BinarySearchTree()
bst.insert(5)
bst.insert(1)
bst.insert(7)
print(bst.values())
