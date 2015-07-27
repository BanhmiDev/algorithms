# Sorting

## Heapsort
Items go into a heap. Remove largest item and insert into ordered list.

**Time Complexity**

- Worst case: O(n log(n))
- Average case: O(n log(n))
- Best case: O(n log(n))

**Space Complexity:** O(1)

## Mergesort
Divide into sublists (until each list contains up to one element). From there on create sorted sublists by checking adjacent items. Merge sorted sublists.

**Time Complexity:**

- Best case: O(n log(n))
- Average case: O(n log(n))
- Worst case: O(n log(n))

**Space Complexity:** O(n)

## Quicksort
Select pivot and recursively split list into two.

**Time Complexity:**

- Worst case: O(n log(n))
- Average case: O(n log(n))
- Best case: O(n^2)

**Space Complexity:** O(n)

## Bubble Sort
Iterate over the list and check if adjacent items can be swapped.

**Time Complexity:**

* Best case: O(n)
* Average case: O(n^2)
* Worst case: O(n^2)

**Space Complexity:** O(1)

## Insertion Sort
Iterate over the list while inserting one item to its correct place.

**Time Complexity:**

- Best case: O(n)
- Average case: O(n^2)
- Worst case: O(n^2)

**Space Complexity:** O(n)

## Selection Sort
Swap the smallest item into position as the first item.

**Time Complexity:**

- Best case: O(n^2)
- Average case: O(n^2)
- Worst case: O(n^2)

**Space Complexity:** O(1)
