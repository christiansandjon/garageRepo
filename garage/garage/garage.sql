drop database garage;
# creattion bd
create database garage;

# utilisation bd
use garage;

# creation tables

create table admin
(
    id       integer     not null primary key auto_increment,
    login    varchar(50) not null,
    password varchar(50) not null
);

create table utilisateur
(
    id       integer     not null primary key auto_increment,
    prenom   varchar(50) not null,
    nom      varchar(50) not null
);

create table client
(
    id          integer     not null primary key auto_increment,
    num_client  integer     not null unique,
    nom         varchar(50) not null,
    telephone   varchar(50) not null,
    rue         varchar(50) not null,
    numero      varchar(50) not null,
    code_postal varchar(50) not null,
    ville       varchar(50) not null,
    pays        varchar(50) not null
);



create table vehicule
(
    id              integer     not null primary key auto_increment,
    immatriculation varchar(50)     not null unique,
    marque          varchar(50) not null,
    modele          varchar(50) not null,
    annee           varchar(50) not null,
    fk_client       integer,
    foreign key (fk_client) references client (id)
);

create table reparation
(
    id            integer     not null primary key auto_increment,
    numero        integer     not null unique,
    date          Timestamp   not null,
    panne         varchar(50) not null,
    solution      varchar(50) not null,
    prix          decimal     not null,
    fk_vehicule   integer,
    fk_reparateur integer,
    foreign key (fk_vehicule) references vehicule (id),
    foreign key (fk_reparateur) references utilisateur(id)
);

# insertion dans les tables
insert into admin(login, password)
VALUES ('nassim', 'nas123');

