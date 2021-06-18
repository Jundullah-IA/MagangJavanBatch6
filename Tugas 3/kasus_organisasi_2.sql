INSERT INTO company
(nama, alamat)
VALUES
('PT Javan', 'Sleman'),
('PT Dicoding', 'Bandung');


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

SELECT nama FROM sdm.employee where atasan_id in (SELECT id FROM sdm.employee where atasan_id in (SELECT id FROM sdm.employee where atasan_id = (SELECT id FROM sdm.employee where atasan_id is null)));

SELECT nama FROM sdm.employee where atasan_id in (SELECT id FROM sdm.employee where atasan_id is null);

SELECT nama FROM sdm.employee where atasan_id in (SELECT id FROM sdm.employee where atasan_id = (SELECT id FROM sdm.employee where atasan_id is null));

select * from sdm.employee where nama not in (?); //Pak Budi

select @atasanid := id from sdm.employee where nama = ?;
select case			//Lainnya
    when @atasanid=2 then @atasan := id
    when @atasanid=3 then @atasan := id
    when @atasanid=4 then @atasan := id
    when @atasanid=5 then @atasan := id end
from sdm.employee where  atasan_id=@atasanid;
select count(id) as jumlah_bawahan from sdm.employee where atasan_id=@atasan;
