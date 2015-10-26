-- Insertion en masse des utilisateurs

-- Administrateurs
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (1, 1, 'Guillaume', 'Pouilloux', 'gpouillo', 'gpouillo@yopmail.fr', 'gpouillo', '0102030405');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (2, 1, 'Nathanael', 'Gimenez', 'ngimenez', 'ngimenez@yopmail.fr', 'ngimenez', '0203040506');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (3, 1, 'Yann', 'Rolland', 'yrolland', 'yrolland@yopmail.fr', 'yrolland', '0304050607');

-- Utilisateurs standards
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (4, 0, 'Jon', 'Snow', 'jsnow', 'jsnow@yopmail.fr', 'jsnow', '0101020203');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number) VALUES (5, 0, 'Arya', 'Stark', 'astark', 'astark@yopmail.fr', 'astark', '0302010203');

-- RessourceType
INSERT INTO RESOURCETYPE (id, name) VALUES (1,'Mobilier');
INSERT INTO RESOURCETYPE (id, name) VALUES (2,'Outillage');
INSERT INTO RESOURCETYPE (id, name) VALUES (3,'Transport');

-- Ressources
INSERT INTO RESOURCE (id, name, description, localisation, responsibleId, typeId) VALUES ('1', 'Table', 'Petite table d''intérieur', 'Salon', 1, 1);
INSERT INTO RESOURCE (id, name, description, localisation, responsibleId, typeId) VALUES ('2', 'Table IKEA', 'Petite table difficile à construire', 'Bureau', 2, 1);
INSERT INTO RESOURCE (id, name, description, localisation, responsibleId, typeId) VALUES ('3', 'Tournevis sonique', 'Permet d''ouvrir toutes les portes', 'TARDIS', 3, 2);
INSERT INTO RESOURCE (id, name, description, localisation, responsibleId, typeId) VALUES ('4', 'Tournevis laser', 'Permet d''ouvrir toutes les portes blindées', 'TARDIS', 3, 2);
INSERT INTO RESOURCE (id, name, description, localisation, responsibleId, typeId) VALUES ('5', 'Voiture UBER', 'Expérimentez l''illégalité', 'Nantes', 1, 3);
INSERT INTO RESOURCE (id, name, description, localisation, responsibleId, typeId) VALUES ('6', 'Avion privé', 'La vitesse au maximum', 'Paris', 4, 3);

-- Réservations
INSERT INTO Reservation (id, date_start, date_end, borrowerId, resourceId) VALUES (1, PARSEDATETIME('2015/10/22 12:05:00', 'yyyy/MM/dd HH:mm:ss'), PARSEDATETIME('2015/10/30 12:05:00', 'yyyy/MM/dd HH:mm:ss'), 1, 1);
INSERT INTO Reservation (id, date_start, date_end, borrowerId, resourceId) VALUES (2, PARSEDATETIME('2015/11/01 12:05:00', 'yyyy/MM/dd HH:mm:ss'), PARSEDATETIME('2015/12/10 12:05:00', 'yyyy/MM/dd HH:mm:ss'), 2, 1);
INSERT INTO Reservation (id, date_start, date_end, borrowerId, resourceId) VALUES (3, PARSEDATETIME('2016/01/01 12:05:00', 'yyyy/MM/dd HH:mm:ss'), PARSEDATETIME('2016/01/10 12:05:00', 'yyyy/MM/dd HH:mm:ss'), 3, 1);
INSERT INTO Reservation (id, date_start, date_end, borrowerId, resourceId) VALUES (4, PARSEDATETIME('2015/10/26 12:05:00', 'yyyy/MM/dd HH:mm:ss'), PARSEDATETIME('2015/11/05 12:05:00', 'yyyy/MM/dd HH:mm:ss'), 3, 3);
INSERT INTO Reservation (id, date_start, date_end, borrowerId, resourceId) VALUES (5, PARSEDATETIME('2015/11/05 12:05:00', 'yyyy/MM/dd HH:mm:ss'), PARSEDATETIME('2016/01/10 12:05:00', 'yyyy/MM/dd HH:mm:ss'), 3, 4);