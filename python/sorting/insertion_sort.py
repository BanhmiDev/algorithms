#!/usr/bin/env python3

"""
Insertion Sort
Time complexity: O(n^2)
Space complexity: O(1)
"""

def sort(list):
    for i in range(1, len(list)):
        position = i-1
        value = list[i]

        while position >= 0 and list[position] > value:
            list[position+1] = list[position]
            position -= 1

        list[position+1] = value

    return list

#print(sort([1, 2, 3, 4, 5, 6, 7]))
print(sort([5, 3, -1, 13, 6, 2, 8]))
