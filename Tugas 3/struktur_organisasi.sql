CREATE DATABASE organisasi_1;

USE organisasi_1;

CREATE TABLE karyawan (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nama VARCHAR(30) NOT NULL,
posisi Varchar(20),
atasan_id INT(6)
);

INSERT INTO karyawan
(nama, posisi)
VALUES
('Rizki Saputra', 'Direktur');

INSERT INTO karyawan
(nama, posisi, atasan_id)
VALUES
('Farhan Reza', 'Manager', 1),
('Riyando Adi', 'Manager', 1);
('Nadia Aulia', 'Analis', 3),
('Mutiara Rezki', 'Analis', 3),
('Dani Setiawan', 'Analis', 3),
('Budi Putra', 'Analis', 3);
('Diego Manuel', 'Pengenbangan Bisnis', 2),
('Satya Laksana', 'Pengenbangan Bisnis', 2),
('Miguel Hernandez', 'Pengenbangan Bisnis', 2),
('Putri Persada', 'Pengenbangan Bisnis', 2),
('Alma Safira', 'Teknisi', 2),
('Haqi Hafiz', 'Teknisi', 2),
('Abi Isyawara', 'Teknisi', 2),
('Maman Kresna', 'Teknisi', 2);

SELECT 
    e.nama AS Karyawan,
    m.nama AS Atasan
FROM
    karyawan e
INNER JOIN karyawan m ON 
    m.id = e.atasan_id
ORDER BY 
    e.atasan_id;












