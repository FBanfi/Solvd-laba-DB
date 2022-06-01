SELECT * FROM Managers RIGHT JOIN Phones ON idManagers=1;
SELECT * FROM Managers RIGHT JOIN Phones ON phone_id=2;
SELECT c.name,c.last_name,p.number FROM Phones p RIGHT JOIN Clients c ON c.idClients=p.idPhones;
SELECT c.name,c.last_name,p.number FROM Phones p RIGHT JOIN Clients c ON c.idClients>p.idPhones;
SELECT * FROM Cards RIGHT JOIN Accounts ON idCards=2;