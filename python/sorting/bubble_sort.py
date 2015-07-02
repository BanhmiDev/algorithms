#!/usr/bin/env python3

"""
Bubble Sort
Time complexity: O(n^2)
Space complexity: O(1)
"""

def sort(list):

    n = len(list)
    swapped = True
    while swapped:
        swapped = False
        for i in range(1, n):
            if list[i-1] > list[i]: # Swap
                temp_value = list[i-1]
                list[i-1] = list[i]
                list[i] = temp_value
                swapped = True
        n = n-1

    return list
    

#print(sort([1, 2, 3, 4, 5, 6, 7]))
print(sort([5, 3, -1, 13, 6, 2, 8]))
