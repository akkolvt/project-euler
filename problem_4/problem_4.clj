(ns project-euler.problem_4)

(def highest-palindrome
  997799)

(defn- is-palindrome?
  [n]
  (let [n-str (str n)
        n-rev (apply str (reverse n-str))]
    (= n-str n-rev)))

(defn- next-palindrome
  [n]
  (let [p (dec n)]
    (if (is-palindrome? p)
      p
      (next-palindrome p))))

(defn- has-divisors?
  [p n]
  (if (and
        (= (rem p n) 0)
        (= (count (str (/ p n))) 3))
    true
    (if (< n 100)
      false
      (has-divisors? p (dec n)))))

(defn- find-largest-palindrome
  [p]
  (if (has-divisors? p 999)
    p
    (find-largest-palindrome (next-palindrome p))))

(prn (find-largest-palindrome highest-palindrome))
