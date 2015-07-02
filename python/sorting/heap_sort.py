#!/usr/bin/env python3

"""
Heap Sort
Time complexity: O(n*log(n))
Space complexity: O(1)
"""

# Reference: http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/heapSort.htm
def max_heapify(list, length, i):
    left = 2 * i + 1
    right = 2 * i + 2
    if left <= length - 1 and list[left] > list[i]:
        largest = left
    else:
        largest = i
    if right <= length - 1 and list[right] > list[largest]:
        largest = right
    if largest != i:
        list[i], list[largest] = list[largest], list[i]
        max_heapify(list, length, largest)


def build_max_heap(list, length):
    for i in range(int((length - 1)/2), -1, -1):
        max_heapify(list, length, i)


def sort(list):
    heap_size = len(list)
    build_max_heap(list, heap_size) # Build max heap for list
    
    for i in range(heap_size):
        list[0], list[heap_size - 1] = list[heap_size - 1], list[0]
        heap_size = heap_size - 1
        max_heapify(list, heap_size, 0)

    return list

#print(sort([1, 2, 3, 4, 5, 6, 7]))
print(sort([5, 3, -1, 13, 6, 2, 8]))
