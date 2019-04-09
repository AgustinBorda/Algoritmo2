interc :: a -> [a] -> [[a]]
interc x [] = [[x]]
interc x (y:ys) = [x:y:ys] ++ [y:zs | zs <- interc x ys]

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