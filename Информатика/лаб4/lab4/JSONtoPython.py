import codecs
import json
f = codecs.open("data/myItmo.json", "r", "utf-8")
s = ''''''
for v in f:
    s += v
d = json.loads(s)
print(d)

