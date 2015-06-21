(ns project-euler.problem_5)

(defn- any-divisors?
  [x n]
  (if (= n 1)
    false
    (if (and
          (= (rem x n) 0)
          (not (= x n)))
      true
      (any-divisors? x (dec n)))))

(defn- prime?
  [x]
  (let [n (int (Math/ceil (Math/sqrt x)))]
    (if (or (and
              (even? x)
              (not (= x 2)))
            (= x 1))
      false
      (not (any-divisors? x n)))))
