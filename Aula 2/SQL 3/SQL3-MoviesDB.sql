#Desativa o safe_delete e o safe_update
SET SQL_SAFE_UPDATES = 0;

#Exercicio 2
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ("El laberinto del fauno", 8.2, 3, "2006-12-1", 119, 11);

#Exercicio 3
INSERT INTO genres (name, ranking, active)
VALUES ("Guerra", 13, true);

#Exercicio 4
UPDATE movies
SET genre_id = 13
WHERE id = 22;

#Exercicio 5
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 48;

#Exercicio 6
CREATE TEMPORARY TABLE movies_copy AS (SELECT * FROM movies);

#Exercicio 7
DELETE FROM movies_copy
WHERE movies_copy.awards < 5;

SELECT * FROM movies_copy;

#Exercicio 8
SELECT DISTINCT g.* FROM genres g
INNER JOIN movies m ON g.id = m.genre_id;

#Exercicio 9
SELECT DISTINCT a.first_name, a.last_name FROM actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

SHOW INDEX FROM movies;

#Exercicio 12
CREATE INDEX movies_title_idx ON movies(title);

#Exercicio 13
SHOW INDEX FROM movies;

#Reativa o safe_delete e o safe_update
SET SQL_SAFE_UPDATES = 1;
