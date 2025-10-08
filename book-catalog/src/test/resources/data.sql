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

-- Bücher Scheibenwelt
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (1, 'Die Farben der Magie', 'Fantasy', 12.99, true, 'Terry Pratchett', 1);
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (2, 'Das Licht der Phantasie', 'Fantasy', 13.99, false, 'Terry Pratchett', 1);

-- Bücher Harry Potter
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (3, 'Harry Potter und der Stein der Weisen', 'Fantasy', 15.99, true, 'J.K. Rowling', 2);

-- Einzelnes Buch ohne Reihe
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES (4, 'Der Alchimist', 'Roman', 10.99, true, 'Paulo Coelho', -1);
