#!/usr/bin/env python3

"""
Queue implementation
"""

class Queue(object):
    def __init__(self):
        self.items = []

    def add(self, item):
        self.items.insert(0, item)

    def remove(self):
        return self.items.pop()

    def is_empty(self):
        return self.items == []

    def size(self):
        return len(self.items)
    
q = Queue()
q.add(1)
q.add(5)
print(q.remove())
q.add(3)
print(q.size())
