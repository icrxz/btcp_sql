SELECT * FROM movies;
SELECT * FROM series;
SELECT * FROM seasons;
SELECT * FROM episodes;
SELECT * FROM genres;
SELECT * FROM actors;
SELECT * FROM actor_movie;
SELECT * FROM actor_episode;

#Exercicio 1
SELECT s.title, g.name FROM series s
INNER JOIN genres g ON g.id = s.genre_id;

#Exercicio 2
SELECT e.title, a.first_name, a.last_name FROM episodes e
INNER JOIN actor_episode ae ON e.id = ae.episode_id
INNER JOIN actors a ON a.id = ae.actor_id;

#Exercicio 3
SELECT s.title, COUNT(se.id) FROM series as s
INNER JOIN seasons as se ON s.id = se.serie_id 
GROUP BY s.title;

#Exercicio 4
SELECT g.name, COUNT(m.id) FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING COUNT(m.id) >= 3;

#Exercicio 5
SELECT DISTINCT a.first_name, a.last_name FROM movies m
INNER JOIN actor_movie am ON m.id = am.movie_id
INNER JOIN actors a ON a.id = am.actor_id
WHERE m.title LIKE ('La Guerra de las galaxias:%');
