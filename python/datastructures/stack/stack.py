#!/usr/bin/env python3

"""
Stack implementation
"""

class Stack(object):
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def is_empty(self):
        return self.items == []

    def size(self):
        return len(self.items)

s = Stack()
s.push(1)
s.push(5)
print(s.pop())
s.push(3)
print(s.size())
