create table if not exists brand (
                                     id identity,
                                     name varchar(50) not null,
    year_of_creation int not null,
    price int not null,
    rate double not null,
    brand_name_from varchar(50) not null,
    created_at timestamp not null
    );