SELECT 
    e.nama AS Staff,
    e.atasan_id
FROM
    employee e
INNER JOIN employee m ON 
	m.atasan_id = e.id
WHERE  NOT e.id = m.atasan_id;