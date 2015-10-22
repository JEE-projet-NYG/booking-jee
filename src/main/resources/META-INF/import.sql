-- Insertion en masse des utilisateurs

-- Administrateurs
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (1, 1, 'Guillaume', 'Pouilloux', 'gpouillo', 'gpouillo@yopmail.fr', 'gpouillo', '0102030405');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (2, 1, 'Nathanael', 'Gimenez', 'ngimenez', 'ngimenez@yopmail.fr', 'ngimenez', '0203040506');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (3, 1, 'Yann', 'Rolland', 'yrolland', 'yrolland@yopmail.fr', 'yrolland', '0304050607');

-- Utilisateurs standards
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (4, 0, 'Jon', 'Snow', 'jsnow', 'jsnow@yopmail.fr', 'jsnow', '0101020203');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (5, 0, 'Arya', 'Stark', 'astark', 'astark@yopmail.fr', 'astark', '0302010203');

-- RessourceType
INSERT INTO RESOURCETYPE (id, name) VALUES (1,'MEUBLE');
INSERT INTO RESOURCETYPE (id, name) VALUES (2,'OUTILLAGE');

-- Ressources
INSERT INTO RESOURCE (id, name, description, localisation, responsibleId, typeId) VALUES ('1', 'table', 'ceci est une table magnifique', 'salle B116', 1, 1);

-- Réservations
INSERT INTO Reservation (id, date_start, date_end, borrowerId, resourceId) VALUES (1, PARSEDATETIME('2015/10/22 12:05:00', 'yyyy/MM/dd HH:mm:ss'), PARSEDATETIME('2015/10/30 12:05:00', 'yyyy/MM/dd HH:mm:ss'), 5, 1);
INSERT INTO Reservation (id, date_start, date_end, borrowerId, resourceId) VALUES (2, PARSEDATETIME('2015/09/20 12:05:00', 'yyyy/MM/dd HH:mm:ss'), PARSEDATETIME('2015/11/05 12:05:00', 'yyyy/MM/dd HH:mm:ss'), 2, 1);