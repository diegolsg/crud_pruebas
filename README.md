# CRUD COVINOV

## TABLA DE CONTENIDO
1. Descripción
2.  Instalación
3.  Uso


## Descripción
***
**Cuenta bancaria** es un proyecto para la gestion de datos de clientes con su respectiva cuenta.El objetivo es poder manejar de manera eficiente los datos mediante un CRUD.
## Instalación
***
Para realizar la instalcion es necesrio contar con:

- Postgres
- ntellij IDEA
- Postman
- Git destktop
- Navagar web
## Tecnologías usadas
- java 17
- Spring boot 3
- Gradle
- Postman
- Pgadmin 4
## Pasos instalacón
***
- Clonar repositorio git y abrirlo con Intellij
- Compilar repositorio
- Crear base de datos con el siguiente query para las tablas en pgamdim 4

create table client(
	id_client serial primary key,
	identification_type varchar(5) not null,
	identification_number decimal null,
	first_name varchar (45)null,
	last_name varchar (45) null,
	email varchar (75) null,
	birth_date date null,
	creation_date timestamp null,
	modification_date timestamp null, 
		
);

create table account(
    id_account serial not null,
    id_client int not null,
    account_type varchar (12)null,
    account_number decimal null,
    account_state varchar(12) null,
    balance decimal null,
    exent_GMf boolean null,
    creation_date timestamp null,
    modification_date timestamp null, 
    primary key(id_account),
	CONSTRAINT fk_client_account
		foreign key (id_client)
		references client (id_client)
);
create table transactions(
	id_transaction serial not null,
	id_account int not null,
	transaction_type varchar (12) null,
	amount decimal null,
	account_destination decimal,
	primary key(id_transaction),
	CONSTRAINT fk_client_transaction
		foreign key (id_account)
		references account (id_account)
	
);

- Configurar los properties
spring.application.name=crud
server.port=puerto

spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_BD
spring.datasource.username=postgres
spring.datasource.password=password
springdoc.swagger-ui.path=/swagger-ui.html

- Ejecutar api

**USO**
- En postman

--**GET**
http://localhost:puerto/client/public/all
http://localhost:puerto/client/public/{id_client}

--**POST**
**Autenticación**
http://localhost:puerto/api/auth/login
**Credenciales administrado**
{"username":"admin",
"password": "admin"}
**credenciales usuarios**
{"username":"customer",
"password": "customer123"}

**Insertar en BD**
- Realizar login
- Copiar barer token
- Autenticación
http://localhost:puerto/client/private/save
- Body
    { 
        "idClient": 8,
        "identificationType": "cc",
        "idenNumber": "5235",
        "firstName": "deo",
        "lastName": "feer3e",
        "email": "t@dr.com",
        "birthDate": "2000-05-12"
    }
**PUT**
http://localhost:puerto/client/private/update
- Modificar valores en JSON
    { 
        "idClient": 8,
        "identificationType": "cc",
        "idenNumber": "5235",
        "firstName": "deo",
        "lastName": "feer3e",
        "email": "t@dr.com",
        "birthDate": "2000-05-12"
    }
**DELETE**
http://localhost:puerto/client/public/delete/{id_client}




