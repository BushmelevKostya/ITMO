a = bin(10299)[2:]
b = bin(65536)[2:]
c = bin(int(b, 2) - int(a, 2))[2:]
d = bin(int(a, 2) + int(c, 2))[2:]
print(a, b, c, d)
print(int("0111110110110101", 2), 10299+21882)