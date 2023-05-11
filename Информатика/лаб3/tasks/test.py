import re
pattern = '/'
test = 'Какая длинная-длинная, / Бесконечная, / Лента реки / По снежной равнине тянется!'
# test = r'8<{P98<{}f8{P8<{P8<{P88<{P'
# pattern = re.compile(r'8<{P')
# a = re.search(pattern, test)
# print(a[0] if a else 'NO')
# b = re.fullmatch(pattern, test)
# print('YES' if b else 'NO')
# c = re.split(pattern, test)
# print(c)
d = re.findall(pattern, test)
print(len(d))
# for i in re.finditer(pattern, test):
#     print(i[0], i.start())
# test = re.sub(pattern, '1', test)
# print(test)
# print(test.count('1'))

