USE BOOKHUB

--ATTENTION : A LANCER AVANT LE DEMERRAGE DE L'APPLICATION
--Suppression des tables pour tout remettre bien prop'
DROP TABLE reservation
DROP TABLE borrow
DROP TABLE book
DROP TABLE category
DROP TABLE users

--ATTENTION : A LANCER APRES LE DEMARRAGE DE L'APPLICATION
-- Insertion des catégories
INSERT INTO CATEGORY (label) VALUES
                                 ('Science-fiction'),
                                 ('Fantasy'),
                                 ('Policier'),
                                 ('Roman'),
                                 ('Biographie'),
                                 ('Histoire'),
                                 ('Développement personnel'),
                                 ('Informatique');

-- Insertion des Livres
INSERT INTO BOOK
(title, author, isbn, category_id, short_desc, long_desc, img_url, condition, status)
VALUES
-- Science-fiction
('Dune', 'Frank Herbert', '9780441013593', 1, 'Un classique de SF', 'Une épopée sur Arrakis, planète désertique.', 'https://www.abramsbooks.com/cover_images/1/9781419731501_s3.jpg', 'PRISTINE', 'AVAILABLE'),
('Neuromancer', 'William Gibson', '9780441569595', 1, 'Cyberpunk culte', 'Un hacker plongé dans un monde virtuel dangereux.', 'https://m.media-amazon.com/images/I/81mcCWmIRkL._AC_UF1000,1000_QL80_.jpg', 'USED', 'AVAILABLE'),

-- Fantasy
('Le Seigneur des Anneaux', 'J.R.R. Tolkien', '9780261102385', 2, 'Quête épique', 'Un voyage pour détruire un anneau maléfique.', 'https://m.media-amazon.com/images/I/81hbMkU2jcL._AC_UF1000,1000_QL80_.jpg', 'PRISTINE', 'BORROWED'),
('Game of Thrones', 'George R.R. Martin', '9780553103540', 2, 'Intrigues politiques', 'Des familles se battent pour le trône.', 'https://m.media-amazon.com/images/I/71Jzezm8CBL._AC_UF1000,1000_QL80_.jpg', 'USED', 'AVAILABLE'),

-- Policier
('Le Crime de l’Orient-Express', 'Agatha Christie', '9780007119318', 3, 'Enquête célèbre', 'Hercule Poirot résout un meurtre dans un train.', 'https://m.media-amazon.com/images/I/817e0oCHWbL.jpg', 'PRISTINE', 'BORROWED'),
('Millénium', 'Stieg Larsson', '9780307454546', 3, 'Thriller moderne', 'Une enquête sur une disparition mystérieuse.', 'https://cdn.cultura.com/cdn-cgi/image/width=830/media/pim/13_ab150ac2-befa-4aac-99a1-94ebff2b4a30.jpeg', 'USED', 'AVAILABLE'),

-- Roman
('L’Étranger', 'Albert Camus', '9782070360024', 4, 'Roman philosophique', 'Un homme face à l’absurdité de la vie.', 'https://m.media-amazon.com/images/I/41NZ-YsKTQL._AC_UF1000,1000_QL80_.jpg', 'PRISTINE', 'BORROWED'),

-- Biographie
('Steve Jobs', 'Walter Isaacson', '9781451648539', 5, 'Vie d’un visionnaire', 'Biographie du cofondateur d’Apple.', 'https://m.media-amazon.com/images/I/71sVQDj0SCL.jpg', 'USED', 'AVAILABLE'),

-- Histoire
('Sapiens', 'Yuval Noah Harari', '9780062316097', 6, 'Histoire de l’humanité', 'Une analyse de l’évolution humaine.', 'https://m.media-amazon.com/images/I/713jIoMO3UL._UF1000,1000_QL80_.jpg', 'PRISTINE', 'BORROWED'),

-- Développement personnel
('Les 7 habitudes', 'Stephen Covey', '9780743269513', 7, 'Efficacité personnelle', 'Des principes pour réussir sa vie.', 'https://m.media-amazon.com/images/I/51iBb9eSU7L.jpg', 'USED', 'BORROWED'),

-- Informatique
('Clean Code', 'Robert C. Martin', '9780132350884', 8, 'Bonnes pratiques', 'Guide pour écrire du code propre.', 'https://m.media-amazon.com/images/I/81Rnac2Fq+L._AC_UF1000,1000_QL80_.jpg', 'PRISTINE', 'BORROWED'),
('Effective Java', 'Joshua Bloch', '9780134685991', 8, 'Java avancé', 'Bonnes pratiques pour Java.', 'https://m.media-amazon.com/images/I/51-xpxmuRoL._UF1000,1000_QL80_.jpg', 'PRISTINE', 'BORROWED');

--Insertion des emprunts
INSERT INTO borrow (user_id, book_id, borrow_start, borrow_end, return_date)
VALUES (1, 1, '2026-01-01', '2026-01-10', '2026-01-09'),
       (3, 2, '2026-01-02', '2026-01-11', '2026-01-10'),
       (4, 3, '2026-01-03', '2026-01-12', NULL),
       (6, 4, '2026-01-04', '2026-01-13', '2026-01-12'),
       (7, 5, '2026-01-05', '2026-01-14', NULL),
       (8, 6, '2026-01-06', '2026-01-15', '2026-01-14'),
       (9, 7, '2026-01-07', '2026-01-16', NULL),
       (10, 8, '2026-01-08', '2026-01-17', '2026-01-16'),

       (1, 9, '2026-02-01', '2026-02-10', NULL),
       (3, 10, '2026-02-02', '2026-02-11', NULL),
       (4, 11, '2026-02-03', '2026-02-12', NULL),
       (6, 12, '2026-02-04', '2026-02-13', NULL);

--Insertion des réservations
insert into reservation (book_id, user_id,date) values (6, 1,current_timestamp);
insert into reservation (book_id, user_id,date) values ( 4, 2,current_timestamp);
insert into reservation (book_id, user_id,date) values ( 1, 3,current_timestamp);

