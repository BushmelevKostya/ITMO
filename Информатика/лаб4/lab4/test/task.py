import codecs
import json
"""
json.dumps : Преобразовать dict в str, один - преобразовать объект Python в строку
json.loads: str to dict one - это преобразование строки в объект Python
json.dump Запись объекта Python в файл в формате JSON
json.load Чтение json файла в объект Python
"""
with codecs.open("../data/myItmo.json", "r", "utf-8") as f:
    obg_py = json.load(f)
    print(obg_py)

f = codecs.open("../data/myItmo.json", "r", "utf-8")
s = ''''''
for v in f:
    s += v
s = json.loads(s)
print(s)

s = json.dumps(s)
print(s)