numbers = 1.upto(100)
diff = numbers.reduce(:+)**2 - numbers.map{|n| n**2}.reduce(:+)

puts diff
