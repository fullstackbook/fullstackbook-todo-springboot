# Full Stack Book Spring Boot

Terminal

```
liquibase update --changelog-file src/main/resources/db/changelog/changelog-1.0.xml --url jdbc:postgresql://localhost:5432/fullstackbook-todo-springboot
liquibase rollback-count 1 --changelog-file src/main/resources/db/changelog/changelog.xml --url jdbc:postgresql://localhost:5432/fullstackbook-todo-springboot
```