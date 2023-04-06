import codecs
import json
import yaml
import time

start_time2 = time.time()
for i in range(100):
    f = codecs.open('data/myItmo.json', 'r', 'utf-8')
    s = ''''''
    for v in f:
        s += v

    json_data = json.loads(s)
    json_data = json.dumps(json_data)

    yaml_data = yaml.safe_load(json_data)
    with open('data/myitmo.yaml', 'w', encoding='utf-8') as file:
        yaml.dump(yaml_data, file, allow_unicode=True)
    output = codecs.open("data/myitmo.yaml", "r", "utf-8")
end_time2 = time.time()
# print("Использование библиотек json, yaml")
# print(output.read())

# import codecs
# import json
# f = codecs.open("myItmo.json", "r", "utf-8")
# s = ''''''
# for v in f:
#     s += v
# d = json.loads(s)
# # print(d["timetable"]["group"].keys)
#
# a = [[]]
# keys = []
# keys.append(d.keys())
# for v in keys[0]:
#     a[0].append(v)
# for i in range(3):
#     i0 = i
#     a.append([])
#     for j in range(len(a[i])):
#         try:
#             keys.append(d[a[i][j]].keys())
#         except:
#             continue
#         else:
#             for v in d[a[i][j]].keys():
#                 a[i0+1].append(v)
#             a.append([])
#             i0 += 1
#     d = d[a[i][-1]]
# print(keys, a, sep='\n')
#
# # a = [[]]
# # values = []
# # values.append(d.values())
# # for v in values[0]:
# #     a[0].append(v)
# # for i in range(1):
# #     a.append([])
# #     for j in range(len(a[i])):
# #         print(a[i][j])
# #         values.append(d[a[i][-2]].keys())
# #     for v in values[i+1]:
# #         a[i+1].append(v)
# #     d = d[a[i][-1]]
# # print(values, a, sep='\n')