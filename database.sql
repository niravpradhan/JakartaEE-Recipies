create table recipies
(
    id           int unsigned auto_increment
        primary key,
    recipeNumber varchar(50) null,
    name         varchar(30) null,
    description  varchar(100) null,
    text         varchar(100) null
);

create table book_author
(
    id        int unsigned auto_increment,
    lastname  varchar(150),
    firstname varchar(150),
    bio       varchar(2500),
    primary key (id)
);