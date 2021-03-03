DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS meals;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    enabled    bool                DEFAULT true  NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_role
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE meals
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    date          TIMESTAMP NOT NULL,
    calories      INTEGER   NOT NULL,
    description   VARCHAR   NOT NULL,
    weight        NUMERIC   NOT NULL,
    fats          NUMERIC   NOT NULL,
    proteins      NUMERIC   NOT NULL,
    carbohydrates NUMERIC   NOT NULL,
    user_id       INTEGER   NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX meals_unique_user_datetime_idx
    ON meals (user_id, date);