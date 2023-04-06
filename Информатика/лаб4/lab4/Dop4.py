import codecs
import json
import re

f = codecs.open("data/myItmo.json", "r", "utf-8")
s = ''''''
for v in f:
    s += v
jsondata = json.loads(s)
csvdata = ''''''
csvdatakey = []
csvdatavalue = []
k = 0  # количество табуляций
pattern = re.compile('\{[^{]*?\{')
sfound = re.search(pattern, s)[0]
while True:
    s = '{' + s.replace(sfound, '', 1)
    while True:
        try:
            re.search('\".+\"\s*:\s*\".+\"', sfound)[0]
        except:
            break
        else:
            key = re.search('\"[\w\d:-]+\"', sfound)[0]
            csvdatakey.append(key)
            sfound = sfound.replace(key, '', 1)
            value = re.search('\".+\"', sfound)[0]
            csvdatavalue.append(value)
            sfound = sfound.replace(value, '', 1)
    try:
        sfound = re.search(pattern, s)[0]
    except:
        break
while True:
    try:
        re.search('\".+\"\s*:\s*\".+\"', s)[0]
    except:
        break
    else:
        key = re.search('\"[\w\d:-]+\"', s)[0]
        csvdatakey.append(key)
        s = s.replace(key, '', 1)
        value = re.search('\".+\"', s)[0]
        csvdatavalue.append(value)
        s = s.replace(value, '', 1)

csvdatakey2 = ['"NumberOfLesson"']
csvdatavalue2 = [['"1"'], ['"2"'], ['"3"'], ['"4"'], ['"5"'], ['"6"']]
for v in csvdatakey[::-1]:
    if v not in csvdatakey2:
        csvdatakey2.append(v)
csvdatakey2 = [csvdatakey2[0]] + csvdatakey2[::-1][:3] + csvdatakey2[1:-3][::-1]
for i in range(6):
    k = 0
    remove = []
    for j in range(8):
        try:
            csvdatavalue2[i].append(csvdatavalue[j])
        except:
            break
        k += 1
        if k > 3: remove.append(csvdatavalue[j])
    for g in range(5):
        try: csvdatavalue.remove(remove[g])
        except: break
for v in csvdatakey2:
    csvdata += v + ';'
csvdata += '\n'
for v in csvdatavalue2:
    for i in v:
        csvdata += i + ';'
    csvdata += '\n'
print("CSV файл")
print(csvdata)