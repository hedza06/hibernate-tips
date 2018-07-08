INSERT INTO book(publisher_id, title, published_at)
VALUES
(
    (SELECT id FROM publisher WHERE first_name = 'Heril' LIMIT 1),
    'Hibernate Tips',
    DATE(NOW())
),
(
    (SELECT id FROM publisher WHERE first_name = 'Heril' LIMIT 1),
    'Spring Boot And Redis',
    DATE_ADD(DATE(NOW()), INTERVAL 1 DAY)
),
(
    (SELECT id FROM publisher WHERE first_name = 'Marko' LIMIT 1),
    'Dockerizing Spring Boot and MySQL',
    DATE_ADD(DATE(NOW()), INTERVAL 2 DAY)
);