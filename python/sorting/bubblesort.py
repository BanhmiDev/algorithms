#!/usr/bin/env python3

"""
Bubblesort
Version: 1
Desc: Goes through the list (multiple times) and compares 
      adjacent items and swaps those that are out of order.
"""

def bubble(list):

    n = len(list)
    swapped = True
    while swapped:
        swapped = False
        for i in range(1, n):
            if list[i-1] > list[i]:
                # Swap
                temp_value = list[i-1]
                list[i-1] = list[i]
                list[i] = temp_value
                swapped = True
        n = n-1

    return list
    

#print(bubble([1, 2, 3, 4, 5, 6, 7]))
print(bubble([5, 3, -1, 13, 6, 2, 8]))
