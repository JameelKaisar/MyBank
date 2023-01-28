# MyBank

## Setup MySQL
```
sudo apt update
sudo apt install mysql-server
sudo service mysql start
sudo mysql
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
exit;
```
```
sudo mysql_secure_installation
```
```
sudo mysql -u root -p
SHOW DATABASES;
CREATE DATABASE mybank;
SHOW DATABASES;
exit;
```
 - Reference: https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04
## Run
```
mvn spring-boot:run
```
