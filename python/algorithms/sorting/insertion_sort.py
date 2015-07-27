#!/usr/bin/env python3

def sort(l):
    for i in range(1, len(l)):
        position = i-1
        value = l[i]

        while position >= 0 and l[position] > value:
            l[position+1] = l[position]
            position -= 1

        l[position+1] = value

    return l

#print(sort([1, 2, 3, 4, 5, 6, 7]))
print(sort([5, 3, -1, 13, 6, 2, 8]))
