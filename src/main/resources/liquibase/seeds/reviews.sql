INSERT INTO review(book_id, `comment`, published_at)
VALUES
(
    (SELECT id FROM book WHERE title = 'Hibernate Tips' LIMIT 1),
    'Great Book!',
    NOW()
),
(
    (SELECT id FROM book WHERE title = 'Hibernate Tips' LIMIT 1),
    'Not Too Bad... Could be better.',
    NOW()
),
(
    (SELECT id FROM book WHERE title = 'Hibernate Tips' LIMIT 1),
    'Not sure about it. Maybe I will buy it!',
    NOW()
),
(
    (SELECT id FROM book WHERE title = 'Spring Boot And Redis' LIMIT 1),
    'Great!',
    NOW()
);