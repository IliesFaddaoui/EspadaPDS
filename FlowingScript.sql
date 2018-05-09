--flowing database script
--please don't modify existing line, just add yours
Insert into Client value(1,'ilies123','ilies123', 'faddaoui', 'ilies', '0618622953', '5 rue a', 'male');
Insert into Client value(2,'bertrand123','bertrand123', 'renard', 'bertrand','0618156154', '4 rue b', 'male');

Insert into KeyWord value (1, 'consoleJeuxVideo');
Insert into KeyWord value (2, 'BandeDessineeAdulte');
Insert into KeyWord value (3, 'jeuxvideoAdulte');
Insert into KeyWord value (4, 'MusiqueRap');
Insert into KeyWord value (5, 'MusiqueRock');
Insert into KeyWord value (6, 'Smartphone');
Insert into KeyWord value (7,'AppareilPhoto');
Insert into KeyWord value (8, 'EcouteurMusique');
Insert into KeyWord value (9, 'Ecran');

Insert into Product value(1, 'Television 50cm Asus LG152', 450, 9);
Insert into Product value(2, 'Nintendo Switch', 299, 1);

Insert into PurchaseHistory value (1, 1, 1, date(sysdate()), 1);
Insert into PurchaseHistory value (2, 2, 1, date(sysdate()), 1);
