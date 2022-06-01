SELECT * FROM Managers LEFT JOIN Phones ON idManagers=1;
SELECT * FROM Managers LEFT JOIN Phones ON phone_id=2;
SELECT c.name,c.last_name,p.number FROM Phones p LEFT JOIN Clients c ON c.idClients=p.idPhones;
SELECT c.name,c.last_name,p.number FROM Phones p LEFT JOIN Clients c ON c.idClients>p.idPhones;
SELECT * FROM Cards LEFT JOIN Accounts ON idCards=2;