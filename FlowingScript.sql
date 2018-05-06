--flowing database script
--please don't modify existing line, just add yours
Insert into client value(1,'ilies123','ilies123', 'faddaoui', 'ilies', '0618622953', '5 rue a', 'male');
Insert into client value(2,'bertrand123','bertrand123', 'renard', 'bertrand','0618156154', '4 rue b', 'male');

Insert into keyword value (1, 'consoleJeuxVideo');
Insert into keyword value (2, 'BandeDessineeAdulte');
Insert into keyword value (3, 'jeuxvideoAdulte');
Insert into keyword value (4, 'MusiqueRap');
Insert into keyword value (5, 'MusiqueRock');
Insert into keyword value (6, 'Smartphone');
Insert into keyword value (7,'AppareilPhoto');
Insert into keyword value (8, 'EcouteurMusique');
Insert into keyword value (9, 'Ecran');

Insert into product value(1, 'Television 50cm Asus LG152', 100, 450, 9);
Insert into product value(2, 'Nintendo Switch', 100, 299, 1);

insert into purchasehistory value (1, 1, 1, date(sysdate()), 1);
insert into purchasehistory value (2, 2, 1, date(sysdate()), 1);
