interc :: a -> [a] -> [[a]]
interc x [] = [[x]]
interc x (y:ys) = [x:y:ys] ++ [y:zs | zs <- interc x ys]

--parc2 :: Int -> [a] -> [[a]]
--parc2 0 _ = [[]]
--arc2 n xs = [map (xs!!i:) (parc2 (n-1) xs) | i <- [0..length xs]]

permut :: [a] -> [[a]]
permut [] = [[]]
permut (x:xs) = concat(map (interc x) (permut xs))

subSet :: [a] -> [[a]]
subSet [] = [[]]
subSet (x:xs) =[x:ys | ys <- as] ++ [zs | zs <- as]
				where as = subSet xs

sub :: [a] -> [[a]]
sub [x] = [[x]]
sub (x:xs) = [[x]] ++ map (x:) (sub xs)

subList :: [a] -> [[a]]
subList [] = [[]]
subList (x:xs) = (sub (x:xs)) ++ (subList xs)

isSorted ::(Ord a) => [a] -> Bool
isSorted [] = True
isSorted [x] = True
isSorted (x:y:xs) = x<=y && isSorted (y:xs)

slowSort ::(Ord a) => [a] -> [a]
slowSort xs = head(filter (isSorted) (permut xs))

desarreglo :: [Int] -> Int -> Bool
desarreglo [] n = True
desarreglo (x:xs) n | x == n = False
										| otherwise = desarreglo xs (n+1)

ej10 :: Int -> [[Int]]
ej10 n = [xs | xs <-permut [0..n],  desarreglo xs 0]
