SELECT a.balance,a.alias,c.number FROM Cards c JOIN Accounts a on a.idAccounts=c.account_id;
SELECT a.balance,a.alias,c.number FROM Cards c JOIN Accounts a WHERE a.idAccounts=1 AND c.number>780000000;
SELECT c.name,c.last_name,p.number FROM Phones p LEFT JOIN Clients c ON c.idClients=p.idPhones;
SELECT c.name,c.last_name,p.number FROM Phones p RIGHT JOIN Clients c ON c.idClients=p.idPhones;
SELECT c.name,c.last_name,p.number FROM Phones p LEFT JOIN Clients c ON c.idClients>p.idPhones;
SELECT idCards FROM Cards GROUP BY idCards WHERE number>580000000;
SELECT AVG(number),idCards FROM Cards GROUP BY idCards HAVING AVG(number)>580000000;
SELECT AVG(number),idCards FROM Cards GROUP BY idCards HAVING AVG(number)>580000000 AND idCards>1;