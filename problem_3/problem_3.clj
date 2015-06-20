(ns project-euler.problem_3)

(def number
  600851475143)

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

(defn- next-prime
  [x]
  (let [n (inc x)]
    (if (prime? n)
      n
      (next-prime n))))

(defn- find-next-prime-factor
  [x f]
  (let [n (next-prime f)]
    (if (= (rem x n) 0)
      n
      (find-next-prime-factor x n))))

(find-next-prime-factor (long number) 3)

(defn- find-largest-prime-factor
  [x p]
  (let [n (find-next-prime-factor x p)]
    (if (< n x)
      (find-largest-prime-factor (/ x n) n)
      n)))

(prn (find-largest-prime-factor (long number) 2))
