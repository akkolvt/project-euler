(println (reduce + (for [x (range 1000) :when (or (= (mod x 5) 0) (= (mod x 3) 0))] x)))
