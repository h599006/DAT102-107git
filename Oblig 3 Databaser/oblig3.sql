

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
 
 
 CREATE TABLE Avdeling
(
	AvdelingId SERIAL UNIQUE,
	Avdeling VARCHAR,
	Sjef INTEGER UNIQUE,
	CONSTRAINT AvdelingPK PRIMARY KEY (AvdelingId)	
);
CREATE TABLE Ansatt
(
	AnsattId SERIAL UNIQUE,
	Brukernavn CHAR(4) UNIQUE,
	Fornavn VARCHAR,
	Etternavn VARCHAR,
	AnsattDato DATE NOT NULL,
	Stilling VARCHAR,
	MndLonn INTEGER,
	Avdeling SERIAL NOT NULL,
	CONSTRAINT AnsattPK PRIMARY KEY (AnsattId),
	CONSTRAINT AvdelingFK FOREIGN KEY (Avdeling) REFERENCES Avdeling(AvdelingId)
);

INSERT INTO
  Avdeling(Avdeling)
VALUES
    ('IT'),
    ('Økonomi'),
    ('Helse');
	
INSERT INTO
  Ansatt(Brukernavn, Fornavn, Etternavn, AnsattDato, Stilling, MndLonn, Avdeling)
VALUES
    ('PeP','Per', 'Persson', '2016-06-15', 'Leder', 50000, 1),
	('AtAt','Atle', 'Atlesen', '2018-03-09', 'Ansatt', 30000, 3),
	('HaH','Håkon', 'Håkonsen', '2013-09-29', 'Avdelings-Leder', 45000, 1),
	('CaC','Carsten', 'Carstensen', '2020-03-19', 'Ansatt', 50000, 2),
	('LaL','Lars', 'Larsen', '2020-07-14', 'Ansatt', 30000, 1),
	('JeJ', 'Jens', 'Jensen', '2015-01-02', 'Avdelings-Leder', 45000,3),
    ('BiB','Brit', 'Britsen', '2021-02-01', 'Ansatt', 32000, 3),
	('KaN','Kari', 'Nordmann', '2017-06-15', 'Avdelings-Leder', 45000, 2),
	('DoDu','Donald', 'Duck', '2016-10-17', 'Ansatt', 29000, 3),
	('MiMu', 'Mikke', 'Mus', '2022-03-23', 'Ansatt', 31000,2);
	
ALTER TABLE Avdeling 
ADD CONSTRAINT Sjef FOREIGN KEY (Sjef) REFERENCES Ansatt(AnsattId);

UPDATE Avdeling
SET Sjef = 3
WHERE Avdeling.Avdeling = 'IT';

UPDATE Avdeling
SET Sjef = 8
WHERE Avdeling.Avdeling = 'Økonomi';

UPDATE Avdeling
SET Sjef = 6
WHERE Avdeling.Avdeling = 'Helse';

