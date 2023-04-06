from JSONToYAML import start_time1, end_time1

def TimeToTask(start, end):
    return (end - start) * 100
t1 = TimeToTask(start_time1, end_time1)
print("Время выполнение первой программы: ", t1)

from Dop1 import start_time2, end_time2

t2 = TimeToTask(start_time2, end_time2)
print("Время выполнение второй программы: ", t2)

from Dop2 import start_time3, end_time3

t3 = TimeToTask(start_time3, end_time3)
print("Время выполнение третьей программы: ", t3)
