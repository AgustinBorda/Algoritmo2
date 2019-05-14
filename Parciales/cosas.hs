ig ::(Eq a) => a -> [a] -> Bool
ig x [] = True
ig x (y:ys) | x==y = ig x ys
            | otherwise = False


reemp :: Char -> Char -> Char
reemp x y | x == 'a' && y == 'b' = 'c'
          | x == 'a' && y == 'c' = 'b'
          | x == 'b' && y == 'c' = 'a'
          | x == 'b' && y == 'a' = 'c'
          | x == 'c' && y == 'a' = 'b'
          | x == 'c' && y == 'b' = 'a'

ej2 :: [Char] -> [Char]
ej2 [] = []
ej2 [x] = [x]
ej2 (x:y:xs)  | x /= y = (ej2 ((reemp x y):xs))
              | ig x (y:xs) =(x:y:xs)
              | x == y = ej2 (x:ej2(y:xs))


ej2_2019 :: Int -> [a] -> [[a]]
ej2_2019 0 xs = [[]]
ej2_2019 n xs =  ej2Aux n xs xs

ej2Aux :: Int -> [a] -> [a] -> [[a]]
ej2Aux n [x] ys = [x:as|as<- ej2_2019 n-1 ys]
ej2Aux n (x:xs) ys = [x:bs|bs<- ej2_2019 n-1 ys] ++ ej2Aux n xs ys
