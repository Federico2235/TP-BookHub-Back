INSERT INTO BOOK
(title, author, isbn, category_id, short_desc, long_desc, img_url, condition, status)
VALUES
-- Science-fiction (1)
('Dune', 'Frank Herbert', '9780441013593', 1, 'Un classique de SF', 'Une épopée sur Arrakis, planète désertique.', 'https://www.abramsbooks.com/cover_images/1/9781419731501_s3.jpg', 'PRISTINE', 'AVAILABLE'),
('Neuromancer', 'William Gibson', '9780441569595', 1, 'Cyberpunk culte', 'Un hacker plongé dans un monde virtuel dangereux.', 'https://m.media-amazon.com/images/I/81mcCWmIRkL._AC_UF1000,1000_QL80_.jpg', 'USED', 'AVAILABLE'),

-- Fantasy (2)
('Le Seigneur des Anneaux', 'J.R.R. Tolkien', '9780261102385', 2, 'Quête épique', 'Un voyage pour détruire un anneau maléfique.', 'https://m.media-amazon.com/images/I/81hbMkU2jcL._AC_UF1000,1000_QL80_.jpg', 'PRISTINE', 'AVAILABLE'),
('Game of Thrones', 'George R.R. Martin', '9780553103540', 2, 'Intrigues politiques', 'Des familles se battent pour le trône.', 'https://m.media-amazon.com/images/I/71Jzezm8CBL._AC_UF1000,1000_QL80_.jpg', 'USED', 'BORROWED'),

-- Policier (3)
('Le Crime de l’Orient-Express', 'Agatha Christie', '9780007119318', 3, 'Enquête célèbre', 'Hercule Poirot résout un meurtre dans un train.', 'https://m.media-amazon.com/images/I/817e0oCHWbL.jpg', 'PRISTINE', 'AVAILABLE'),
('Millénium', 'Stieg Larsson', '9780307454546', 3, 'Thriller moderne', 'Une enquête sur une disparition mystérieuse.', 'https://cdn.cultura.com/cdn-cgi/image/width=830/media/pim/13_ab150ac2-befa-4aac-99a1-94ebff2b4a30.jpeg', 'USED', 'RESERVED'),

-- Roman (4)
('L’Étranger', 'Albert Camus', '9782070360024', 4, 'Roman philosophique', 'Un homme face à l’absurdité de la vie.', 'https://m.media-amazon.com/images/I/41NZ-YsKTQL._AC_UF1000,1000_QL80_.jpg', 'PRISTINE', 'AVAILABLE'),

-- Biographie (5)
('Steve Jobs', 'Walter Isaacson', '9781451648539', 5, 'Vie d’un visionnaire', 'Biographie du cofondateur d’Apple.', 'https://m.media-amazon.com/images/I/71sVQDj0SCL.jpg', 'USED', 'AVAILABLE'),

-- Histoire (6)
('Sapiens', 'Yuval Noah Harari', '9780062316097', 6, 'Histoire de l’humanité', 'Une analyse de l’évolution humaine.', 'https://m.media-amazon.com/images/I/713jIoMO3UL._UF1000,1000_QL80_.jpg', 'PRISTINE', 'AVAILABLE'),

-- Développement personnel (7)
('Les 7 habitudes', 'Stephen Covey', '9780743269513', 7, 'Efficacité personnelle', 'Des principes pour réussir sa vie.', 'https://m.media-amazon.com/images/I/51iBb9eSU7L.jpg', 'USED', 'AVAILABLE'),

-- Informatique (8)
('Clean Code', 'Robert C. Martin', '9780132350884', 8, 'Bonnes pratiques', 'Guide pour écrire du code propre.', 'https://m.media-amazon.com/images/I/81Rnac2Fq+L._AC_UF1000,1000_QL80_.jpg', 'PRISTINE', 'AVAILABLE'),
('Effective Java', 'Joshua Bloch', '9780134685991', 8, 'Java avancé', 'Bonnes pratiques pour Java.', 'https://m.media-amazon.com/images/I/51-xpxmuRoL._UF1000,1000_QL80_.jpg', 'PRISTINE', 'AVAILABLE');