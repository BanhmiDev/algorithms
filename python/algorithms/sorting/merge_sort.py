#!/usr/bin/env python3

# Ref: https://docs.python.org/3.5/library/heapq.html
from heapq import merge

def sort(l):
    if len(l) <= 1:
        return l
    else:
        middle = len(l) // 2
        left = l[:middle]
        right = l[middle:]
     
        left = sort(left)
        right = sort(right)

        return list(merge(left, right))

#print(sort([1, 2, 3, 4, 5, 6, 7]))
print(sort([5, 3, -1, 13, 6, 2, 8]))
