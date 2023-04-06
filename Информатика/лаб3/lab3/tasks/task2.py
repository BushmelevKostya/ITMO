import re
pattern = open('pattern.txt', encoding='utf-8').read()
test = []
test.append(open('../tests_6_10/test6', encoding='utf-8').read()) # Вечер за окном. / Еще один день прожит./ Жизнь скоротечна...
test.append(open('../tests_6_10/test7', encoding='utf-8').read()) # Какая длинная-длинная, / Бесконечная, / Лента реки / По снежной равнине тянется!
test.append(open('../tests_6_10/test8', encoding='utf-8').read()) # Эй, сова, гляди веселее. / Льется весенний дождь.
test.append(open('../tests_6_10/test9', encoding='utf-8').read()) # Все глубже осенняя ночь. / Млечный Путь разгорается ярче / Над черной водою полей.
test.append(open('../tests_6_10/test10', encoding='utf-8').read()) # Осенняя луна. / О, если б вновь родиться / Сосною на горе.
for i in range(len(test)):
    if re.fullmatch(pattern, test[i]):
        print(i + 1, 'тест - Хайку!')
    elif len(re.findall('/', test[i])) == 2:
        print(i + 1, 'тест - не хайку.')
    else:
        print(i + 1, 'тест - не хайку. Доолжно быть 3 строки')
