(ns project-euler.problem_6)

(defn find-sum-square-difference
  [c]
  (let [numbers (take c (iterate inc 1))
        square (fn [x] (* x x))
        sum-of-squares (reduce + (map square numbers))
        square-of-sum (square (reduce + numbers))]
    (- square-of-sum sum-of-squares)))

(prn (find-sum-square-difference 100))
