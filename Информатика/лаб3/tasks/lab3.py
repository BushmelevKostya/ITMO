# import subprocess
# n = int(input('Введите номер задания от 1 до 3 '))
# if n == 1: subprocess.call("task1.py", shell=True)
# elif n == 2: subprocess.call("task2.py", shell=True)
# elif n == 3: subprocess.call("task3.py", shell=True)
# else:
#     print('Внимательно прочитайте описание и попробуйте еще раз')
#     subprocess.call('lab3.py', shell=True)
import re
pattern = input('Введите смайлик: ')
alph = ['(', ')', '/']
print(pattern)
test = input('Введите текст: ')
tet=r"pattern"
pattern = re.compile(r"tet")
count = pattern.match(test)
print('В данном тексте ', count, ' смайлик(а)(ов)')
