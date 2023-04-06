import re
pattern = re.compile(':-{O') #последний символ - латинская заглавная буква O
test = []
res = [0] * 5
test.append(open('../tests_1-5/test1').read()) # ''
test.append(open('../tests_1-5/test2').read()) # ':-{O1:-{O2:-{O3/:-{O1    :-{O    :-{:-{O:{O'
test.append(open('../tests_1-5/test3').read()) # многострочный
test.append(open('../tests_1-5/test4').read()) # многострочный
test.append(open('../tests_1-5/test5').read()) # многострочный
for i in range(len(test)):
    res[i] = len(pattern.findall(test[i]))
    print('В данном тексте ', res[i], ' смайликов', '\n', test[i])

test_pr = test
res_pr = res
for i in range(len(test_pr)):
    res_pr[i] = test_pr[i].replace(':-{O', 'spec_symbol').count('spec_symbol')

print(res_pr)