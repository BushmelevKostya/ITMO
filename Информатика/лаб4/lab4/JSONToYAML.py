import codecs
import time
import re

start_time1 = time.time()
for i in range(100):
    f = codecs.open("data/myItmo.json", "r", "utf-8")
    s = ''''''
    k = 0
    for v in f:
        s += v
        k += 1
pattern = "[{}[]\",]"
yaml = re.sub(pattern, "", s)
yaml = '---' + '\n' + yaml + '\n' + '---'
end_time1 = time.time()
print("необходимо перевести json в yaml формат")
print("json файл:")
print(s)
print("yaml файл:")
print(yaml)





# s = yaml.split('\n')
# new_yaml = '''
# '''
# for i in range(len(s)):
#     if isonlykey(s[i]): new_yaml = new_yaml + '        - ' + s[i]
#     else: new_yaml += s[i]
#     print(new_yaml)