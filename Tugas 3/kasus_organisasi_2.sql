-- organisasi_2.company definition

CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

INSERT INTO company
(nama, alamat)
VALUES
('PT Javan', 'Sleman'),
('PT Dicoding', 'Bandung');


-- organisasi_2.employee definition

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `atasan_id` int(11) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_FK` (`atasan_id`),
  KEY `employee_FK_1` (`company_id`),
  CONSTRAINT `employee_FK` FOREIGN KEY (`atasan_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `employee_FK_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

INSERT INTO organisasi_2.employee
(nama, atasan_id, company_id)
VALUES
("Pak Budi" , null , 1),
("Pak Tono" , 1 , 1),
("Pak Totok" , 1 , 1),
("Bu Sinta" , 2 , 1),
("Bu Novi" , 3 , 1),
("Andre" , 4 , 1),
("Pak Dono" , 4 , 1),
("Ismir" , 5 , 1),
("Anto" , 5 , 1);

SELECT nama as CEO FROM employee
WHERE atasan_id IS NULL;

SELECT nama FROM sdm.employee 
where atasan_id in 
	(SELECT id FROM sdm.employee 
	where atasan_id in 
		(SELECT id FROM sdm.employee 
		where atasan_id = 
		(SELECT id FROM sdm.employee 
		where atasan_id is null)));

SELECT nama FROM sdm.employee 
where atasan_id in 
	(SELECT id FROM sdm.employee 
	where atasan_id is null);

SELECT nama FROM sdm.employee 
where atasan_id in 
	(SELECT id FROM sdm.employee 
	where atasan_id = 
		(SELECT id FROM sdm.employee 
		where atasan_id is null));

select * from sdm.employee 
where nama not in (?); //Pak Budi

select @atasanid := id from sdm.employee where nama = ?;
select case			//Lainnya
    when @atasanid=2 then @atasan := id
    when @atasanid=3 then @atasan := id
    when @atasanid=4 then @atasan := id
    when @atasanid=5 then @atasan := id end
from sdm.employee where  atasan_id=@atasanid;
select count(id) as jumlah_bawahan from sdm.employee where atasan_id=@atasan;
