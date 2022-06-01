SELECT * FROM Cards JOIN Accounts WHERE idCards=2;
SELECT * FROM Clients JOIN Managers JOIN Accounts ON account_id=2;
SELECT * FROM Managers JOIN Phones ON phone_id=2;
SELECT a.balance,a.alias,c.number FROM Cards c JOIN Accounts a on a.idAccounts=c.account_id;
SELECT a.balance,a.alias,c.number FROM Cards c JOIN Accounts a WHERE a.idAccounts=1 AND c.number>780000000;