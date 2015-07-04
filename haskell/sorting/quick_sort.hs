quick_sort :: Ord a => [a] -> [a]
quick_sort [] = []
quick_sort (p:xs) = (quick_sort smaller) ++ [p] ++ (quick_sort greater)
    where
        smaller = filter (< p) xs
        greater = filter (>= p) xs

main = do
  print $ quick_sort [8, 4, 3, 5, 6, 1]
