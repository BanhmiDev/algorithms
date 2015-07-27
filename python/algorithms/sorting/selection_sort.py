#!/usr/bin/env python3

"""
Selection Sort
Time complexity: O(n^2)
Space complexity: O(1)
"""

def sort(list):
    n = len(list)
    for i in range(0, n-1): # Loop through elements
        min = i
        for j in range(i+1, n):
            if list[j] < list[min]: # Set new minimum
                min = j
        if min != i: # Swap
            temp_value = list[min]
            list[min] = list[i]
            list[i] = temp_value

    return list

#print(sort([1, 2, 3, 4, 5, 6, 7]))
print(sort([5, 3, -1, 13, 6, 2, 8]))
