bubble_sort :: (Ord a) => [a] -> [a]
bubble_sort [] = []
bubble_sort xs = iterate swapkey xs !! (length xs - 1)
    where
        swapkey [x] = [x]
        swapkey (x:y:zs)
            | x > y     = y : swapkey (x:zs)
            | otherwise = x : swapkey (y:zs)
            
main = do
  print $ bubble_sort [8, 4, 3, 5, 6, 1]