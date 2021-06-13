CREATE DATABASE sdm;

USE sdm;

CREATE TABLE departemen (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nama VARCHAR(30) NOT NULL,
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DESC departemen;

CREATE TABLE karyawan (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nama VARCHAR(30) NOT NULL,
jenis_kelamin ENUM('L' , 'P'),
status ENUM('Menikah', 'Belum'),
tanggal_lahir DATE,
tanggal_masuk DATE,
departemen INT(6),
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DESC karyawan;

INSERT INTO departemen ( nama ) VALUES
('Manajemen'),
('Pengembangan Bisnis'),
('Teknisi'),
('Analis');

SELECT * FROM departemen;

INSERT INTO karyawan
(nama, jenis_kelamin, status, tanggal_lahir, tanggal_masuk, departemen)
VALUES
('Rizki Saputra', 'L', 'Menikah', '1980-10-11' , '2011-01-01', 1);

INSERT INTO karyawan
(nama, jenis_kelamin, status, tanggal_lahir, tanggal_masuk, departemen)
VALUES
('Farhan Reza', 'L', 'Belum', '1989-11-01' , '2011-01-01', 1),
('Riyando Adi', 'L', 'Menikah', '1977-01-25' , '2011-01-01', 1),
('Diego Manuel', 'L', 'Menikah', '1983-02-22' , '2012-09-04', 2),
('Satya Laksana', 'L', 'Menikah', '1980-01-12' , '2011-03-19', 2),
('Miguel Hernandez', 'L', 'Menikah', '1994-10-16' , '2014-06-15', 2),
('Putri Persada', 'P', 'Menikah', '1988-01-30' , '2013-04-14', 2),
('Alma Safira', 'P', 'Menikah', '1980-05-18' , '2013-09-28', 3),
('Haqi Hafiz', 'L', 'Belum', '1995-09-19' , '2015-03-09', 3),
('Abi Isyawara', 'L', 'Belum', '1991-06-03' , '2012-01-22', 3),
('Maman Kresna', 'L', 'Belum', '1993-08-21' , '2012-09-15', 3),
('Nadia Aulia', 'P', 'Belum', '1989-10-07' , '2012-05-07', 4),
('Mutiara Rezki', 'P', 'Menikah', '1988-03-23' , '2013-05-21', 4),
('Dani Setiawan', 'L', 'Belum', '1986-11-02' , '2014-11-30', 4),
('Budi Putra', 'L', 'Belum', '1995-10-23' , '2015-12-03', 4);

SELECT * FROM karyawan;


