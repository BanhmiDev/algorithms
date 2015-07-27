#!/usr/bin/env python3

# Reference: http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/heapSort.htm
def max_heapify(l, length, i):
    left = 2 * i + 1
    right = 2 * i + 2
    if left <= length - 1 and l[left] > l[i]:
        largest = left
    else:
        largest = i
    if right <= length - 1 and l[right] > l[largest]:
        largest = right
    if largest != i:
        l[i], l[largest] = l[largest], l[i]
        max_heapify(l, length, largest)


def build_max_heap(l, length):
    for i in range(int((length - 1)/2), -1, -1):
        max_heapify(l, length, i)


def sort(l):
    heap_size = len(l)
    build_max_heap(l, heap_size) # Build max heap for l
    
    for i in range(heap_size):
        l[0], l[heap_size - 1] = l[heap_size - 1], l[0]
        heap_size = heap_size - 1
        max_heapify(l, heap_size, 0)

    return l

#print(sort([1, 2, 3, 4, 5, 6, 7]))
print(sort([5, 3, -1, 13, 6, 2, 8]))
