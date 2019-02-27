**Как запустить**

1. Создать базу данных PostgreSQL

2. Выполнить DDL из файла `db_dump/dump.ver.1.sql`

3. Указать настройки базы данных в файле `website/src/main/resources/application.properties`

4. `cd webservice/ && mvn clean spring-boot:run`

5. `cd website/ && mvn clean spring-boot:run`

6. Открыть: http://127.0.0.1:8080/index.xhtml