SELECT idCards FROM Cards GROUP BY idCards WHERE number>580000000;
SELECT AVG(number),idCards FROM Cards GROUP BY idCards HAVING AVG(number)>580000000;
SELECT AVG(number),idPhones FROM Phones GROUP BY idPhones HAVING MIN(number)>42000000 AND idPhones=1;
SELECT MIN(number),idPhones FROM Phones GROUP BY idPhones HAVING AVG(number)>42000000 AND idPhones>1;
SELECT MAX(number),idCards FROM Cards GROUP BY idCards HAVING MAX(number)>580000000 AND idCards=4;
SELECT COUNT(number),idCards FROM Cards GROUP BY idCards HAVING AVG(number)>580000000 AND idCards>3;