import codecs
import json
import yaml


f = codecs.open('test.json', 'r', 'utf-8')
s = ''''''
for v in f:
    s += v
json_data = json.loads(s)
json_data = json.dumps(json_data)
print(json_data)

yaml_data = yaml.safe_load(json_data)
yaml_data = yaml.dump(yaml_data)
print(yaml_data)
