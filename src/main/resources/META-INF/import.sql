-- Insertion en masse des utilisateurs

-- Administrateurs
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number)
VALUES (1, 1, 'Guillaume', 'Pouilloux', 'gpouillo', 'gpouillo@yopmail.fr', 'gpouillo', '0102030405');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number)
VALUES (2, 1, 'Nathanael', 'Gimenez', 'ngimenez', 'ngimenez@yopmail.fr', 'ngimenez', '0203040506');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number)
VALUES (3, 1, 'Yann', 'Rolland', 'yrolland', 'yrolland@yopmail.fr', 'yrolland', '0304050607');

-- Utilisateurs standards
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number)
VALUES (4, 0, 'Jon', 'Snow', 'jsnow', 'jsnow@yopmail.fr', 'jsnow', '0101020203');
INSERT INTO User (id, admin, firstname, lastname, login, mail_address, password, phone_number)
VALUES (5, 0, 'Arya', 'Stark', 'astark', 'astark@yopmail.fr', 'astark', '0302010203');


