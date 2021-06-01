DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA public;

CREATE TABLE role (
    id SERIAL PRIMARY KEY NOT NULL,
    role VARCHAR(100) NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(30) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE room (
    id SERIAL PRIMARY KEY NOT NULL,
    name varchar(255)
);

CREATE TABLE message (
    id SERIAL PRIMARY KEY NOT NULL,
    content TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    room_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES room(id)
);

CREATE TABLE user_room (
    user_id BIGINT NOT NULL,
    room_id BIGINT NOT NULL,
    PRIMARY KEY (user_id,room_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES room(id)
);




