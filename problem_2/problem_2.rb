def generate_fib_seq
  fib = [0, 1]

  while fib.last < 4_000_000
    fib << fib.last(2).reduce(:+)
  end

  fib
end

fib_seq = generate_fib_seq
sum = fib_seq.select {|f| f.even?}.reduce(:+)

puts sum
