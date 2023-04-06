import codecs
import re
import time

start_time3 = time.time()
for i in range(100):
    f = codecs.open("data/myItmo.json", "r", "utf-8")
    s = ''''''
    for v in f:
        s += v

    new_yaml = '''---\n'''
    k = 0   #  количество табуляций
    pattern = re.compile('\{[^{]*?\{')
    sfound = re.search(pattern, s)[0]
    while True:
        s = '{' + s.replace(sfound, '', 1)
        while True:
            try:
                re.search('\".+\"\s*:\s*\".+\"', sfound)[0]
            except:
                try:
                    key = re.search('\"[\w\d:-]+\"', sfound)[0]
                    new_yaml += '\n' + '\t' * k + key.replace("\"", "") + ':'
                finally:
                    break
            else:
                key = re.search('\"[\w\d:-]+\"', sfound)[0]
                new_yaml += '\n' + '\t' * k + key.replace("\"", "") + ':'
                sfound = sfound.replace(key, '', 1)
                value = re.search('\".+\"', sfound)[0]
                new_yaml += value.replace("\"", "")
                sfound = sfound.replace(value, '', 1)
        try:
            sfound = re.search(pattern, s)[0]
            k = s.count('}') - s.count('{')
        except:
            break

while True:
    try:
        re.search('\".+\"\s*:\s*\".+\"', s)[0]
    except:
        break
    else:
        key = re.search('\"[\w\d:-]+\"', s)[0]
        new_yaml += '\n' + '\t' * k + key.replace("\"", "") + ':'
        s = s.replace(key, '', 1)
        value = re.search('\".+\"', s)[0]
        new_yaml += value.replace("\"", "")
        s = s.replace(value, '', 1)
end_time3 = time.time()
new_yaml += '\n---'
# print("Использование регулряных выражений")
# print(new_yaml)