Breif Description :
<br>
A Simple wallet application created as an individual project in a span of 2 days where a user can create an account , after creation of account he/she should use the valid credentials to login to the account. At the time of login a current user session is being created and a random string is generated. Using that particular string which is named a key, the user can view his wallet balance, add money to the wallet and can even withdraw money from the wallet.
The User can also delete his/her account if necessary.

Operations :
<br>
User Registration
<br>
Login
<br>
Logout
<br>
View Wallet Balance
<br>
Add Money
<br>
Withdraw Money
<br>
Delete Account
<br>
<br>

Feature:
<br>
User authentication and authorization with session ID.

Tech Stacks Used : 
<br>
Java | SpringBoot 

Database :
<br>
MySql

UnitTests :
Junit
<br>

UnitTest : View Balance:
<br>
<br>

![Screenshot (30)](https://github.com/arunprazad001/walletApp/assets/105920330/06e0f134-3ced-40cb-8888-eb541d931c5d)
<br>

UnitTest : Add Money:
<br>
<br>
![Screenshot (31)](https://github.com/arunprazad001/walletApp/assets/105920330/6937a2bc-4f27-4b15-b02c-8c182011fbbd)
<br>

UnitTest : Withdraw Money:
<br>
<br>
![Screenshot (32)](https://github.com/arunprazad001/walletApp/assets/105920330/40843593-c103-41df-891e-7d428cef10bb)
<br>
<br>

Installation & Run

    Before running the API server, you should update the database config inside the application.properties file.
    Update the port number, username and password as per your local database configuration.
    For current application we have used the below properties.

    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/walletapp;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

