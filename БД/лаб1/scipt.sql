DROP TABLE chemistry_object CASCADE;
DROP TABLE element CASCADE;
DROP TABLE Planet CASCADE;
DROP TABLE presence_of_life CASCADE;
DROP TABLE scientist CASCADE;
DROP TABLE scientist_laboratory CASCADE;
DROP TABLE vortex CASCADE;

CREATE TABLE Planet
(
    Planet_Number    SMALLINT PRIMARY KEY,
    Planet_Name      VARCHAR(15) NOT NULL,
    Persence_Of_Life VARCHAR(3)  NOT NULL
);

CREATE TABLE Scientist
(
    Pasport_Number INTEGER PRIMARY KEY NOT NULL,
    Scientist_Name VARCHAR(32)         NOT NULL,
    Gender         VARCHAR(10)         NOT NULL,
    Age            INTEGER DEFAULT 0
);

CREATE TABLE Scientist_Laboratory
(
    Pasport_Number  INTEGER REFERENCES Scientist,
    Planet_Number   SMALLINT REFERENCES planet,
    PRIMARY KEY (Pasport_Number, Planet_Number),
    Laboratory_Name VARCHAR(32) NOT NULL
);

CREATE TABLE Presence_Of_Life
(
    Planet_Number    SMALLINT REFERENCES planet,
    Oxygen           VARCHAR(3) NOT NULL,
    Ocean            VARCHAR(3) NOT NULL,
    Temperature      INTEGER DEFAULT 0,
    Presense_Of_Life VARCHAR(3) NOT NULL
);

CREATE TABLE Vortex
(
    Vortex_Name   VARCHAR(15) PRIMARY KEY NOT NULL,
    Planet_Number SMALLINT REFERENCES planet
);

CREATE TABLE Chemistry_Object
(
    Object_Name VARCHAR(32) PRIMARY KEY NOT NULL,
    Type        VARCHAR(32)             NOT NULL,
    Formula     VARCHAR(32)             NOT NULL
);

CREATE TABLE Element
(
    Element_Name VARCHAR(32) PRIMARY KEY NOT NULL,
    Object_Name  VARCHAR(32) REFERENCES Chemistry_Object
);

INSERT INTO planet (planet_number, planet_name, persence_of_life)
VALUES (1, 'Mercury', 'no'),
       (2, 'Venera', 'no'),
       (3, 'Earth', 'yes'),
       (4, 'Mars', 'no'),
       (5, 'Jupitier', 'no'),
       (6, 'Saturn', 'no'),
       (7, 'Uran', 'no'),
       (8, 'Neptun', 'no');

INSERT INTO scientist (pasport_number, scientist_name, gender)
VALUES (1234, 'Petrov', 'men'),
       (5678, 'Vasechkin', 'men');

INSERT INTO scientist_laboratory (pasport_number, planet_number, laboratory_name)
VALUES (1234, 5, 'Gorkovskaya'),
       (5678, 3, 'Zenit');

INSERT INTO presence_of_life (planet_number, oxygen, ocean, presense_of_life)
VALUES (1, 'yes', 'no', 'no'),
       (2, 'yes', 'no', 'no'),
       (3, 'yes', 'yes', 'yes'),
       (4, 'yes', 'no', 'no'),
       (5, 'yes', 'no', 'no'),
       (6, 'yes', 'no', 'no'),
       (7, 'yes', 'no', 'no'),
       (8, 'yes', 'no', 'no');

INSERT INTO vortex (vortex_name, planet_number)
VALUES ('Big Red Spot', 5);

INSERT INTO chemistry_object (object_name, type, formula)
VALUES ('air', 'compound', 'O2'),
       ('ozone', 'compound', 'O3'),
       ('water', 'compound', 'H20'),
       ('hydrogen', 'element', 'H2'),
       ('parafin', 'compound', 'CnH2n+2'),
       ('oxygen', 'element', 'O2');

INSERT INTO element (element_name, object_name)
VALUES ('vortex', 'air'),
       ('storm', 'air'),
       ('thunder', 'ozone'),
       ('hurricane', 'air');

DROP TABLE chemistry_object CASCADE;
DROP TABLE element CASCADE;
DROP TABLE Planet CASCADE;
DROP TABLE presence_of_life CASCADE;
DROP TABLE scientist CASCADE;
DROP TABLE scientist_laboratory CASCADE;
DROP TABLE vortex CASCADE;

CREATE TABLE Planet
(
    Planet_Number    SMALLINT PRIMARY KEY,
    Planet_Name      VARCHAR(15) NOT NULL,
    Persence_Of_Life VARCHAR(3)  NOT NULL
);

CREATE TABLE Scientist
(
    Pasport_Number INTEGER PRIMARY KEY NOT NULL,
    Scientist_Name VARCHAR(32)         NOT NULL,
    Gender         VARCHAR(10)         NOT NULL,
    Age            INTEGER DEFAULT 0
);

CREATE TABLE Scientist_Laboratory
(
    Pasport_Number  INTEGER REFERENCES Scientist,
    Planet_Number   SMALLINT REFERENCES planet,
    PRIMARY KEY (Pasport_Number, Planet_Number),
    Laboratory_Name VARCHAR(32) NOT NULL
);

CREATE TABLE Presence_Of_Life
(
    Planet_Number    SMALLINT REFERENCES planet,
    Oxygen           VARCHAR(3) NOT NULL,
    Ocean            VARCHAR(3) NOT NULL,
    Temperature      INTEGER DEFAULT 0,
    Presense_Of_Life VARCHAR(3) NOT NULL
);

CREATE TABLE Vortex
(
    Vortex_Name   VARCHAR(15) PRIMARY KEY NOT NULL,
    Planet_Number SMALLINT REFERENCES planet
);

CREATE TABLE Chemistry_Object
(
    Object_Name VARCHAR(32) PRIMARY KEY NOT NULL,
    Type        VARCHAR(32)             NOT NULL,
    Formula     VARCHAR(32)             NOT NULL
);

CREATE TABLE Element
(
    Element_Name VARCHAR(32) PRIMARY KEY NOT NULL,
    Object_Name  VARCHAR(32) REFERENCES Chemistry_Object
);

INSERT INTO planet (planet_number, planet_name, persence_of_life)
VALUES (1, 'Mercury', 'no'),
       (2, 'Venera', 'no'),
       (3, 'Earth', 'yes'),
       (4, 'Mars', 'no'),
       (5, 'Jupitier', 'no'),
       (6, 'Saturn', 'no'),
       (7, 'Uran', 'no'),
       (8, 'Neptun', 'no');

INSERT INTO scientist (pasport_number, scientist_name, gender)
VALUES (1234, 'Petrov', 'men'),
       (5678, 'Vasechkin', 'men');

INSERT INTO scientist_laboratory (pasport_number, planet_number, laboratory_name)
VALUES (1234, 5, 'Gorkovskaya'),
       (5678, 3, 'Zenit');

INSERT INTO presence_of_life (planet_number, oxygen, ocean, presense_of_life)
VALUES (1, 'yes', 'no', 'no'),
       (2, 'yes', 'no', 'no'),
       (3, 'yes', 'yes', 'yes'),
       (4, 'yes', 'no', 'no'),
       (5, 'yes', 'no', 'no'),
       (6, 'yes', 'no', 'no'),
       (7, 'yes', 'no', 'no'),
       (8, 'yes', 'no', 'no');

INSERT INTO vortex (vortex_name, planet_number)
VALUES ('Big Red Spot', 5);

INSERT INTO chemistry_object (object_name, type, formula)
VALUES ('air', 'compound', 'O2'),
       ('ozone', 'compound', 'O3'),
       ('water', 'compound', 'H20'),
       ('hydrogen', 'element', 'H2'),
       ('parafin', 'compound', 'CnH2n+2'),
       ('oxygen', 'element', 'O2');

INSERT INTO element (element_name, object_name)
VALUES ('vortex', 'air'),
       ('storm', 'air'),
       ('thunder', 'ozone'),
       ('hurricane', 'air');

SELECT *
from chemistry_object;
SELECT *
from element;
SELECT *
from planet;
SELECT *
from presence_of_life;
SELECT *
from scientist;
SELECT *
from Scientist_Laboratory;
SELECT *
from vortex;

CREATE TABLE science_article
(
    ID              INTEGER PRIMARY KEY NOT NULL,
    BranchOfScience VARCHAR(32)         NOT NULL
);

CREATE TABLE article_autors
(
    Pasport_Number INTEGER REFERENCES scientist,
    ID             INTEGER REFERENCES science_article,
    PRIMARY KEY (Pasport_Number, ID),
    CreationDate   VARCHAR(32) NOT NULL
);