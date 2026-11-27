CREATE DATABASE laboration2_database;

USE laboration2_database;

CREATE USER 'appuser5'@'localhost' IDENTIFIED BY '?';

GRANT ALL PRIVILEGES ON laboration2_database.* TO 'appuser5'@'localhost';

CREATE TABLE department
(
    department_id   INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(30) NOT NULL,
    office_location VARCHAR(30) NOT NULL
);

CREATE TABLE employee
(
    employee_id   INT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(30)  NOT NULL,
    last_name     VARCHAR(30)  NOT NULL,
    email         VARCHAR(100) NOT NULL UNIQUE,
    hiring_date   DATE         NOT NULL,
    department_id INT          NOT NULL,
    FOREIGN KEY (department_id)
        REFERENCES department (department_id)
);

CREATE TABLE access_card
(
    card_id       INT AUTO_INCREMENT PRIMARY KEY,
    card_number   VARCHAR(30) NOT NULL UNIQUE,
    date_of_issue DATE        NOT NULL,
    expiry_date   DATE        NOT NULL,
    employee_id   INT         NOT NULL UNIQUE,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
);

CREATE TABLE competence
(
    competence_id INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(30)  NOT NULL UNIQUE,
    description   VARCHAR(100) NOT NULL
);

CREATE TABLE employee_competence
(
    employee_id   INT NOT NULL,
    competence_id INT NOT NULL,
    PRIMARY KEY (employee_id, competence_id),
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id),
    FOREIGN KEY (competence_id)
        REFERENCES competence (competence_id)
);

INSERT INTO department (name, office_location)
VALUES ('Department1', 'Address1'),
       ('Department2', 'Address2'),
       ('Department3', 'Address3'),
       ('Department4', 'Address4');

INSERT INTO employee (first_name, last_name, email, hiring_date, department_id)
VALUES ('Anna', 'Andersson', 'email1', '2020-02-09', 1),
       ('Emma', 'Karlsson', 'email2', '2023-02-03', 1),
       ('Erik', 'Johansson', 'email3', '2022-02-06', 1),
       ('Hanna', 'Hansson', 'email4', '2021-03-05', 2),
       ('Jan', 'Jansson', 'email5', '2019-02-01', 2),
       ('Ellen', 'Jansson', 'email6', '2018-02-01', 3),
       ('Sara', 'Svensson', 'email7', '2017-02-01', 3);

INSERT INTO access_card (card_number, date_of_issue, expiry_date, employee_id)
VALUES ('CardNumber1', '2025-05-05', '2028-05-05', 1),
       ('CardNumber2', '2024-01-01', '2027-02-02', 3),
       ('CardNumber3', '2022-01-01', '2026-02-05', 4),
       ('CardNumber4', '2023-01-01', '2029-02-05', 7);

INSERT INTO competence (name, description)
VALUES ('SQL', 'Ability to work with SQL'),
       ('Java', 'Ability to work with Java'),
       ('Project management', 'Ability to manage projects');

INSERT INTO employee_competence (employee_id, competence_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (3, 1),
       (4, 2);

SELECT first_name,
       last_name,
       name
FROM employee
         INNER JOIN department
                    ON employee.department_id = department.department_id;

SELECT name,
       first_name,
       last_name
FROM department
         LEFT JOIN employee
                   ON department.department_id = employee.department_id;

SELECT first_name,
       last_name,
       name,
       card_number
FROM employee
         INNER JOIN department
                    ON employee.department_id = department.department_id
         LEFT JOIN access_card
                   ON employee.employee_id = access_card.employee_id;

SELECT name,
       first_name,
       last_name,
       card_number
FROM department
         LEFT JOIN employee
                   ON employee.department_id = department.department_id
         LEFT JOIN access_card
                   ON employee.employee_id = access_card.employee_id;

SELECT first_name,
       last_name,
       email,
       hiring_date,
       department.name,
       office_location,
       card_number,
       date_of_issue,
       expiry_date,
       competence.name,
       description
FROM employee
         LEFT JOIN department
                   ON employee.department_id = department.department_id
         LEFT JOIN access_card
                   ON employee.employee_id = access_card.employee_id
         LEFT JOIN employee_competence
                   ON employee.employee_id = employee_competence.employee_id
         LEFT JOIN competence
                   ON employee_competence.competence_id = competence.competence_id
WHERE employee.employee_id = 1;

SELECT first_name,
       last_name,
       email,
       hiring_date,
       department.name,
       office_location,
       card_number,
       date_of_issue,
       expiry_date,
       competence.name,
       description
FROM employee
         LEFT JOIN department
                   ON employee.department_id = department.department_id
         LEFT JOIN access_card
                   ON employee.employee_id = access_card.employee_id
         LEFT JOIN employee_competence
                   ON employee.employee_id = employee_competence.employee_id
         LEFT JOIN competence
                   ON employee_competence.competence_id = competence.competence_id
WHERE employee.employee_id = 2;

SELECT first_name,
       last_name,
       email,
       hiring_date,
       department.name,
       office_location,
       card_number,
       date_of_issue,
       expiry_date,
       competence.name,
       description
FROM employee
         LEFT JOIN department
                   ON employee.department_id = department.department_id
         LEFT JOIN access_card
                   ON employee.employee_id = access_card.employee_id
         LEFT JOIN employee_competence
                   ON employee.employee_id = employee_competence.employee_id
         LEFT JOIN competence
                   ON employee_competence.competence_id = competence.competence_id
WHERE employee.employee_id = 5;

SELECT name,
       first_name,
       last_name
FROM department
         INNER JOIN employee
                    ON department.department_id = employee.department_id;

SELECT name,
       first_name,
       last_name
FROM department
         LEFT JOIN employee
                   ON department.department_id = employee.department_id;