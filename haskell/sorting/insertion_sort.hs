import Data.List (insert)

insertion_sort :: (Ord a) => [a] -> [a]
insertion_sort [] = []
insertion_sort xs = foldr (\x result -> insert x result) [] xs

main = do
  print $ insertion_sort [8, 4, 3, 5, 6, 1]