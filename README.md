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

## Run
```
sudo service mysql start
mvn spring-boot:run
```

## References
- https://javahungry.blogspot.com/2019/09/spring-boot-hello-world-example-maven-eclipse.html
- https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04
- https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
- https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html
