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

n = 3
pl = 2

while pl < 10001 do
  n += 2
  pl += 1 if prime?(n)
end

puts n
