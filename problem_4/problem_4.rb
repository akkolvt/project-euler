from = 10000 #100 * 100
to = 998001 #999 * 999

palindromes = []

to.downto(from).each do |n|
  palindromes << n if n.to_s == n.to_s.reverse
end

largest = nil

palindromes.each do |p|
  999.downto(100).each do |n|
    if p % n == 0 && (p / n).to_s.length == 3
      largest = p
      break
    end

    break if largest
  end
end

puts largest
