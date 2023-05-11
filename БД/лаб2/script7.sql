SELECT COUNT(HUMANS)
FROM (
SELECT AVG(CAST(Н_ВЕДОМОСТИ.ОЦЕНКА AS INTEGER)) AS AVERAGE
FROM Н_ЛЮДИ
RIGHT JOIN Н_ВЕДОМОСТИ ON Н_ЛЮДИ.ИД = Н_ВЕДОМОСТИ.ЧЛВК_ИД
RIGHT JOIN Н_УЧЕНИКИ ON Н_ЛЮДИ.ИД = Н_УЧЕНИКИ.ЧЛВК_ИД
RIGHT JOIN Н_ПЛАНЫ ON Н_УЧЕНИКИ.ПЛАН_ИД = Н_ПЛАНЫ.ИД
RIGHT JOIN Н_ОТДЕЛЫ ON Н_ПЛАНЫ.ОТД_ИД = Н_ОТДЕЛЫ.ИД
WHERE Н_ВЕДОМОСТИ.ОЦЕНКА IN ('2', '3', '4', '5') AND 
Н_ОТДЕЛЫ.КОРОТКОЕ_ИМЯ = 'КТиУ'
GROUP BY Н_ЛЮДИ.ИМЯ, Н_ВЕДОМОСТИ.ОЦЕНКА
HAVING Н_ВЕДОМОСТИ.ОЦЕНКА = '5'
) AS HUMANS;