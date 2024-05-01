create table if not exists users(
    id bigserial primary key not null,
    created_at timestamp Not null default now(),
    updated_at timestamp,
    deleted_at timestamp,
    is_deleted BOOLEAN not null default false,
    username varchar(255) not null unique,
    password varchar(255) not null,
    role varchar(255) not null DEFAULT 'ROLE_USER'
);

create table if not exists cards(
    id bigserial primary key not null,
    created_at timestamp Not null default now(),
    updated_at timestamp,
    type varchar(255) not null,
    number VARCHAR(20) NOT NULL UNIQUE,
    expiration_month VARCHAR(2) NOT NULL,
    expiration_year VARCHAR(2) NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    user_id BIGINT NOT NULL references users(id)
);