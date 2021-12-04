CREATE TABLE IF NOT EXISTS product
(
    product_id serial PRIMARY KEY,
    name       varchar,
    price      double precision
);

CREATE TABLE IF NOT EXISTS "user"
(
    user_id  serial PRIMARY KEY,
    name     varchar,
    phone    varchar,
    email    varchar,
    username varchar,
    password varchar
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_role_id serial PRIMARY KEY,
    user_id      serial REFERENCES "user" (user_id),
    role_id      serial REFERENCES roles (roles_id)
    );

CREATE TABLE IF NOT EXISTS roles
(
    roles_id serial PRIMARY KEY,
    role   varchar
);