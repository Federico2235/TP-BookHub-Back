INSERT INTO BOOK
(title, author, isbn, category_id, short_desc, long_desc, img_url, condition, status)
VALUES
-- Science-fiction (1)
('Dune', 'Frank Herbert', '9780441013593', 1, 'Un classique de SF', 'Une épopée sur Arrakis, planète désertique.', null, 'PRISTINE', 'AVAILABLE'),
('Neuromancien', 'William Gibson', '9780441569595', 1, 'Cyberpunk culte', 'Un hacker plongé dans un monde virtuel dangereux.', null, 'USED', 'AVAILABLE'),

-- Fantasy (2)
('Le Seigneur des Anneaux', 'J.R.R. Tolkien', '9780261102385', 2, 'Quête épique', 'Un voyage pour détruire un anneau maléfique.', null, 'PRISTINE', 'AVAILABLE'),
('Game of Thrones', 'George R.R. Martin', '9780553103540', 2, 'Intrigues politiques', 'Des familles se battent pour le trône.', null, 'USED', 'BORROWED'),

-- Policier (3)
('Le Crime de l’Orient-Express', 'Agatha Christie', '9780007119318', 3, 'Enquête célèbre', 'Hercule Poirot résout un meurtre dans un train.', null, 'PRISTINE', 'AVAILABLE'),
('Millénium', 'Stieg Larsson', '9780307454546', 3, 'Thriller moderne', 'Une enquête sur une disparition mystérieuse.', null, 'USED', 'RESERVED'),

-- Roman (4)
('L’Étranger', 'Albert Camus', '9782070360024', 4, 'Roman philosophique', 'Un homme face à l’absurdité de la vie.', null, 'PRISTINE', 'AVAILABLE'),

-- Biographie (5)
('Steve Jobs', 'Walter Isaacson', '9781451648539', 5, 'Vie d’un visionnaire', 'Biographie du cofondateur d’Apple.', null, 'USED', 'AVAILABLE'),

-- Histoire (6)
('Sapiens', 'Yuval Noah Harari', '9780062316097', 6, 'Histoire de l’humanité', 'Une analyse de l’évolution humaine.', null, 'PRISTINE', 'AVAILABLE'),

-- Développement personnel (7)
('Les 7 habitudes', 'Stephen Covey', '9780743269513', 7, 'Efficacité personnelle', 'Des principes pour réussir sa vie.', null, 'USED', 'AVAILABLE'),

-- Informatique (8)
('Clean Code', 'Robert C. Martin', '9780132350884', 8, 'Bonnes pratiques', 'Guide pour écrire du code propre.', null, 'PRISTINE', 'AVAILABLE'),
('Effective Java', 'Joshua Bloch', '9780134685991', 8, 'Java avancé', 'Bonnes pratiques pour Java.', null, 'PRISTINE', 'AVAILABLE');