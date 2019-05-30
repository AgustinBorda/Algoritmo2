problemaMoneda :: Int -> [Int] -> [Int]
problemaMoneda c xs = monedas c (qSortMonedas xs)

monedas :: Int -> [Int] -> [Int]
monedas 0 _ = []
monedas c [] = error "No se puede dar cambio"
monedas c (x:xs)  | c >= x = x:monedas (c-x) (x: xs)
                  | otherwise = monedas c xs


mochila :: Int -> [(Int,Int)] -> [(Int,Int)]
mochila 0 _ = []
mochila _ [] = []
mochila c (x:xs) | c >= snd x = x: mochila (c-snd x) xs
                 | otherwise = mochila c xs


problemaMochila :: Int -> [(Int,Int)] -> [(Int,Int)]
problemaMochila c xs = mochila c (qSortMochila xs)

qSortMonedas :: [Int] -> [Int]
qSortMonedas [] = []
qSortMonedas [x] = [x]
qSortMonedas (x:xs) =   qSortMonedas (filter (>=x) xs) ++ [x] ++ qSortMonedas (filter (<x) xs)

qSortMochila :: [(Int,Int)] -> [(Int,Int)]
qSortMochila [] = []
qSortMochila [x] = [x]
qSortMochila (x:xs) = qSortMochila [y| y <- xs, fst y >= fst x] ++ [x] ++ qSortMochila [z| z<- xs, fst z < fst x]
