def prime?(num)
  return true if [1, 2].include?(num)
  return false if num.even?

  n = Math.sqrt(num).ceil
  div = nil

  3.upto(n).select(&:odd?).each do |d|
    if num % d == 0
      div = d
      break
    end
  end

  div.nil?
end

def decompose_num(num, multiples=[])
  if prime?(num)
    multiples << num
    return multiples
  end

  2.upto(num).each do |n|
    if num % n == 0
      multiples << n
      num = num / n
      break
    end
  end

  decompose_num(num, multiples)
end

@factors = []

20.downto(2).each do |n|
  prime_factors = decompose_num(n)

  prime_factors.uniq.each do |f|
    diff = prime_factors.count(f) - @factors.count(f)
    diff.times { @factors << f }
  end
end

puts @factors.reduce(:*)
