# customers

Para este projeto funcionar perfeitamente, sugiro ler o application.properties e ter banco mysql configurado, segue create da tabela: 
create table usuarios.customer
(
    id             bigint auto_increment
        primary key,
    endereco       varchar(100) not null,
    cidade         varchar(100) not null,
    uf             varchar(100) not null,
    genero         varchar(8)   not null,
    nome           varchar(100) not null,
    sobre_nome     varchar(100) not null,
    num_cpf        varchar(30)  not null,
    dth_nascimento datetime     not null
);

Para verificar online esta api com swagger, basta acessar: http://localhost:8080/swagger-ui.html e clicar em customer-controller e todos os métodos criados estarão disponíveis para teste e visualização.
