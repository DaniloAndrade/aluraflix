create table videos (
    id bigint auto_increment
        primary key,
    titulo varchar(100) not null,
    descricao varchar (255),
    url varchar (255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

