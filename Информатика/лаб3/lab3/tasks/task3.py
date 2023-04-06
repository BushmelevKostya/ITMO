import re
pattern = re.compile('[\w.]+@[A-Za-z.]+\.([A-Za-z]){2,3}')

test = []
test.append(open('../tests_11-15/test11', encoding='utf-8').read()) #
test.append(open('../tests_11-15/test12', encoding='utf-8').read()) #
test.append(open('../tests_11-15/test13', encoding='utf-8').read()) #
test.append(open('../tests_11-15/test14', encoding='utf-8').read()) #
test.append(open('../tests_11-15/test15', encoding='utf-8').read()) #
for i in range(len(test)):
    if pattern.fullmatch(test[i]):
        server = re.findall('@.+', test[i])
        print(i + 1, 'тест :', server)
    else:
        print(i + 1, 'тест : Fail!')