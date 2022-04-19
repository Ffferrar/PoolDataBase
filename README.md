# PoolDataBase
---
Проект по Java-course 2022

Кожанов Глеб

Бурлакова Ольга

Инструкция по запуску приложения в IntelliJ IDEA Community:

**Подключение Базы Данных** 
--
1. JDK 16.0.2
2. MySQL - установлено
3. File -> Settings -> Plugins -> DataBase Navigation
4. DataBase window -> Create connection -> MySQL -> Name: pool. User: root. Password: qqq122
5. TestConnection -> Если возникает проблема с часовым поясом -> открыть MySQL Command Line Client -> set global time_zone = '+3:00';

**Подключение TomCat** 
--
0. Скачать apache-tomcat-9.0.62.
1. File -> Settings -> Plugins -> Smart TomCat download
2. Edit configuration ->  New TomCat -> Указать путь к apache-tomcat-9.0.62 в TomCat Server 
3. Успешно!
