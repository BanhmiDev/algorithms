#!/usr/bin/env python3

def sort(l):

    n = len(l)
    swapped = True
    while swapped:
        swapped = False
        for i in range(1, n):
            if l[i-1] > l[i]: # Swap
                temp_value = l[i-1]
                l[i-1] = l[i]
                l[i] = temp_value
                swapped = True
        n = n-1

    return l

#print(sort([1, 2, 3, 4, 5, 6, 7]))
print(sort([5, 3, -1, 13, 6, 2, 8]))
