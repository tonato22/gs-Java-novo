﻿# API de Apoio Psicológico Remoto

Este projeto é uma API REST desenvolvida em Java 17 com Spring Boot, destinada ao gerenciamento de usuários, agendamentos e relatórios de apoio psicológico em contextos de calamidade.

## ✅ Requisitos

- Java 17
- Maven 3.8+
- Oracle Database (FIAP)
- IDE recomendada: IntelliJ IDEA ou VSCode

---

## ⚙️ Tecnologias e Recursos

- ✅ Spring Boot 3.2.5
- ✅ Spring Data JPA
- ✅ Oracle JDBC
- ✅ Spring Security + JWT
- ✅ Bean Validation
- ✅ Swagger UI (OpenAPI 3)
- ✅ CORS Configurado
- ✅ Deploy pronto para nuvem

---

## 🔧 Configuração do Banco

**application.properties:**

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=rmXXXXX
spring.datasource.password=*****
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect

springdoc.api-docs.path=/api-docs
