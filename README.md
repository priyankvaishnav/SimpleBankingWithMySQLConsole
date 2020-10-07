# SimpleBankingWithMySQLConsole
It is a small Console application. 
------------------------------------
Language used: Java (1.8)
IDE used: Eclipse
Database used: MySQL (8)
Workbench used: MySQL Workbench 
Connector: MySQL JDBC Connector 

Workflow
------------------------------------

1. User will need to put login credentials.
2. Credentials will be checked.
3. Available operations will be availabe.
4. Banking operations:
4.1 Check Balance
4.2 Deposit
4.3 Withdraw
4.4 Exit
5. Exit will terminate the program.

MySQL Create Queries
------------------------------------

CREATE DATABASE IF NOT EXISTS banking_app;
USE banking_app;

CREATE TABLE IF NOT EXISTS user_info (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  user_username VARCHAR(20) UNIQUE NOT NULL,
  user_userpassword VARCHAR(20) NOT NULL
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS user_account(
  user_id INT,
  user_account_balance FLOAT,
  FOREIGN KEY (user_id) REFERENCES user_info(user_id)
)ENGINE=InnoDB;

MySQL insert Queries for table user_info
------------------------------------


INSERT INTO user_info(user_id , user_username, user_userpassword)
					VALUES(1000 , "priyank", "dummy");
          
INSERT INTO user_info(user_username, user_userpassword)
					VALUES("priyank1", "dummy");

MySQL insert Queries for table user_account
------------------------------------
INSERT INTO user_account(user_id, user_account_balance)
	        VALUES (1000, 100.00);
  
INSERT INTO user_account(user_id , user_account_balance)
          VALUES(1001, 200.00);  
