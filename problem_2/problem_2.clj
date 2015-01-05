(def fib-sequence
  (lazy-cat [0 1] (map +
                       (rest fib-sequence)
                       fib-sequence)))

(println
  (reduce +
          (filter even?
                  (take-while
                    (partial > 4000000)
                    fib-sequence))))
