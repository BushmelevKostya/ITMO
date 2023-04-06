s = input('Введите код ')
kb1 = s[0]
kb2 = s[1]
kb3 = s[3]
kod = s[2] + s[4:]
s = '0' + '0' + s[2] + '0' + s[4:]
s = str((int(s[2]) + int(s[4]) + int(s[6])) % 2) + str((int(s[1]) + int(s[2]) + int(s[5]) + int(s[6])) % 2) + s[2] + str((int(s[3]) + int(s[4]) + int(s[5]) + int(s[6])) % 2) + s[4:]
kb1_new = s[0]
kb2_new = s[1]
kb3_new = s[3]
error_razrad = -1
if kb1_new != kb1: error_razrad += 1
if kb2_new != kb2: error_razrad += 2
if kb3_new != kb3: error_razrad += 4
if error_razrad != -1:
    print('индекс бита с ошибкой: ', error_razrad)
    s = s[:error_razrad] + str((int(s[error_razrad]) + 1) % 2) + s[error_razrad + 1:]
else: print('ошибок нет')
s = s[2] + s[4:]
print("правильное сообщение: ", s)