NUM = 600851475143

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
divs = []
left = NUM

while n <= left do
  if prime?(n) && left % n == 0
    divs << n
    left = left / n
  end

  n += 2
end

puts divs.last
