CREATE TABLE developer (
  id SERIAL PRIMARY KEY,
  firstName VARCHAR (255) NOT NULL,
  lastName VARCHAR (255) NOT NULL,
  age INTEGER NOT NULL,
  position VARCHAR (255) NOT NULL,
  salary INTEGER NOT NULL
);

INSERT INTO developer (firstname, lastname, age, position, salary) VALUES ('Hakan', 'Yedibela', 34, 'Technical Lead', 4103);
INSERT INTO developer (firstName, lastName, age, position, salary) VALUES ('John', 'Doe', 34, 'Technical Lead', 5103);
INSERT INTO developer (firstName, lastName, age, position, salary) VALUES ('Aisha', 'Fellers', 31, 'UI/UX', 4403);

