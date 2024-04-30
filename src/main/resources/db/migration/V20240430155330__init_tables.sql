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