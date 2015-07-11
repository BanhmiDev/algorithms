import Data.List (delete)

selection_sort :: (Ord a) => [a] -> [a]
selection_sort [] = []
selection_sort xs = (minimum xs) : (selection_sort $ delete (minimum xs) xs)

main = do
  print $ selection_sort [8, 4, 3, 5, 6, 1]
