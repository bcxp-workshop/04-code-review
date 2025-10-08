DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS SERIES;

CREATE TABLE SERIES (
                        id INT PRIMARY KEY,
                        name VARCHAR(255)
);

CREATE TABLE BOOK (
                      id INT PRIMARY KEY,
                      title VARCHAR(255),
                      genre VARCHAR(100),
                      price DOUBLE,
                      available BOOLEAN,
                      author VARCHAR(255),
                      series_id INT
);

-- Reihen
INSERT INTO SERIES (id, name) VALUES (1, 'Scheibenwelt');
INSERT INTO SERIES (id, name) VALUES (2, 'Harry Potter');
INSERT INTO SERIES (id, name) VALUES (3, 'Der Herr der Ringe');
INSERT INTO SERIES (id, name) VALUES (4, 'Per Anhalter durch die Galaxis');
INSERT INTO SERIES (id, name) VALUES (5, 'Die drei Sonnen-Trilogie');

-- Bücher Scheibenwelt
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (1, 'Die Farben der Magie', 'Fantasy', 12.99, true, 'Terry Pratchett', 1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (2, 'Das Licht der Phantasie', 'Fantasy', 13.99, false, 'Terry Pratchett', 1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (17, 'Gevatter Tod', 'Fantasy', 13.99, true, 'Terry Pratchett', 1);

-- Bücher Harry Potter
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (3, 'Harry Potter und der Stein der Weisen', 'Fantasy', 15.99, true, 'J.K. Rowling', 2);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (18, 'Harry Potter und der Feuerkelch', 'Fantasy', 17.99, false, 'J.K. Rowling', 2);

-- Bücher "Der Herr der Ringe"
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (19, 'Die Gefährten', 'Fantasy', 13.99, true, 'J.R.R. Tolkien', 3);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (20, 'Die zwei Türme', 'Fantasy', 13.99, true, 'J.R.R. Tolkien', 3);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (21, 'Die Rückkehr des Königs', 'Fantasy', 13.99, true, 'J.R.R. Tolkien', 3);

-- Bücher "Per Anhalter durch die Galaxis"
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (22, 'Per Anhalter durch die Galaxis', 'Science Fiction', 12.99, true, 'Douglas Adams', 4);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (23, 'Das Restaurant am Ende des Universums', 'Science Fiction', 12.99, false, 'Douglas Adams', 4);

-- Bücher "Die drei Sonnen-Trilogie"
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (24, 'Die drei Sonnen', 'Science Fiction', 14.99, true, 'Cixin Liu', 5);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (25, 'Der dunkle Wald', 'Science Fiction', 15.99, true, 'Cixin Liu', 5);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (26, 'Jenseits der Zeit', 'Science Fiction', 16.99, false, 'Cixin Liu', 5);

-- Einzelwerke (keine Serie, series_id = -1)
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (4, 'Der Alchimist', 'Roman', 10.99, true, 'Paulo Coelho', -1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (27, 'Der Schwarm', 'Thriller', 15.99, true, 'Frank Schätzing', -1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (28, 'Mord im Orient Express', 'Krimi', 10.99, false, 'Agatha Christie', -1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (29, '1984', 'Dystopie', 12.49, false, 'George Orwell', -1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (30, 'Die Unendliche Geschichte', 'Fantasy', 13.99, true, 'Michael Ende', -1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (31, 'Wer die Nachtigall stört', 'Roman', 11.99, false, 'Harper Lee', -1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (32, 'Sophies Welt', 'Roman', 10.99, true, 'Jostein Gaarder', -1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (33, 'Die Entdeckung der Langsamkeit', 'Roman', 10.99, true, 'Sten Nadolny', -1);