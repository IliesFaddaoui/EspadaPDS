<<<<<<< Updated upstream
Insert into KeyWord value (1, 'consoleJeuxVideo');
Insert into KeyWord value (2, 'BandeDessineeAdulte');
Insert into KeyWord value (3, 'jeuxvideoAdulte');
Insert into KeyWord value (4, 'MusiqueRap');
Insert into KeyWord value (5, 'MusiqueRock');
Insert into KeyWord value (6, 'Smartphone');
Insert into KeyWord value (7,'AppareilPhoto');
Insert into KeyWord value (8, 'EcouteurMusique');
Insert into KeyWord value (9, 'Ecran');
Insert into KeyWord value (10, 'Fast-Food');
Insert into KeyWord value (11, 'equipement randonnÃ©e');
Insert into KeyWord value (12, 'beautÃ©');

Insert into Product value(1, 'Television 50cm Asus LG152', 450, 9);
Insert into Product value(2, 'Nintendo Switch', 299, 1);
Insert into Product value(3, 'Sandwich jambon beurre deau-nah', 3, 10);
Insert into Product value(4, 'sac Ã  dos randonnÃ©e', 20, 11);
Insert into Product value(5, 'parfum Dior nÂ°10', 99, 12 );

Insert into Client value(1,'ilies123','ilies123', 'faddaoui', 'ilies', '0618622953', '5 rue a', 'm');
Insert into Client value(2,'bertrand123','bertrand123', 'renard', 'bertrand','0618156154', '4 rue b', 'm');
Insert into Client value(3,'robert123','robert123', 'robert', 'redford','06235288', '6 rue b', 'm');
Insert into Client value(4,'bea123','bea123', 'beatrice', 'solide','054175120', '8 rue 8', 'f');
Insert into Client value(5,'jeanne123','jeanne123', 'jeanne', 'rapouille','026522311', '8 rue dart', 'f');
Insert into Client value(6,'farid123','farid123', 'farid', 'benarfa','09175120', '6 rue courneuse', 'm');
Insert into Client value(7,'fatou123','fatou123', 'fatoumata', 'benarfa','09175120', '6 rue courneuse', 'f');
Insert into Client value(8,'Wong123','Wong123', 'Wong', 'shihao','0615263659', '8 rue lajoulie', 'f');
Insert into Client value(9,'adam123','adam123', 'adamska', 'Shalaskala','0501020302', '8 rue 4 mai', 'm');
Insert into Client value(10,'jojo123','jojo123', 'john', 'doe','0502030214', '8 rue zero', '?');

Insert into PurchaseHistory value (1, 1, 1, date(sysdate()), 1);
Insert into PurchaseHistory value (2, 2, 1, date(sysdate()), 1);


Insert into Magasin value (1, 'Courir', 'Sport',875);
Insert into Magasin value (2, 'Adidas', 'Sport',700);
Insert into Magasin value (3, 'Foot Locker', 'Sport',734);
Insert into Magasin value (4, 'Nike', 'Sport',735);
Insert into Magasin value (5, 'Go sport', 'Sport',888);
Insert into Magasin value (6, 'Intersport', 'Sport',600);
Insert into Magasin value (7, 'Decathlon', 'Sport',1400);
Insert into Magasin value (23, 'JDsport', 'Sport',943);
Insert into Magasin value (8, 'Fnac', 'Multimï¿½dia',963);
Insert into Magasin value (9, 'Darty', 'Multimï¿½dia',1065);
Insert into Magasin value (10, 'Boulanger', 'Multimï¿½dia',875);
Insert into Magasin value (22, 'Apple', 'Multimï¿½dia',747);
Insert into Magasin value (11, 'H&M', 'Vetement',1000);
Insert into Magasin value (12, 'Devred', 'Vetement',875);
Insert into Magasin value (13, 'Zara', 'Vetement',1176);
Insert into Magasin value (14, 'Celio', 'Vetement',500);
Insert into Magasin value (15, 'C&A', 'Vetement',750);
Insert into Magasin value (16, 'Celio club', 'Vetement',475);
Insert into Magasin value (17, 'Levis', 'Vetement',578);
Insert into Magasin value (18, 'Mango', 'Vetement',765);
Insert into Magasin value (19, 'New look', 'Vetement',654);
Insert into Magasin value (20, 'Primark', 'Vetement',1200);
Insert into Magasin value (21, 'Jules', 'Vetement',624);
=======
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

Insert into Product value(1, 'Television 50cm Asus LG152', 100, 450, 9);
Insert into Product value(2, 'Nintendo Switch', 100, 299, 1);

Insert into PurchaseHistory value (1, 1, 1, date(sysdate()), 1);
Insert into PurchaseHistory value (2, 2, 1, date(sysdate()), 1);

Insert into Magasin value (1, 'Courir', 'Sport',875);
Insert into Magasin value (2, 'Adidas', 'Sport',700);
Insert into Magasin value (3, 'Foot Locker', 'Sport',734);
Insert into Magasin value (4, 'Nike', 'Sport',735);
Insert into Magasin value (5, 'Go sport', 'Sport',888);
Insert into Magasin value (6, 'Intersport', 'Sport',600);
Insert into Magasin value (7, 'Decathlon', 'Sport',1400);
Insert into Magasin value (23, 'JDsport', 'Sport',943);
Insert into Magasin value (8, 'Fnac', 'Multimédia',963);
Insert into Magasin value (9, 'Darty', 'Multimédia',1065);
Insert into Magasin value (10, 'Boulanger', 'Multimédia',875);
Insert into Magasin value (22, 'Apple', 'Multimédia',747);
Insert into Magasin value (11, 'H&M', 'Vetement',1000);
Insert into Magasin value (12, 'Devred', 'Vetement',875);
Insert into Magasin value (13, 'Zara', 'Vetement',1176);
Insert into Magasin value (14, 'Celio', 'Vetement',500);
Insert into Magasin value (15, 'C&A', 'Vetement',750);
Insert into Magasin value (16, 'Celio club', 'Vetement',475);
Insert into Magasin value (17, 'Levis', 'Vetement',578);
Insert into Magasin value (18, 'Mango', 'Vetement',765);
Insert into Magasin value (19, 'New look', 'Vetement',654);
Insert into Magasin value (20, 'Primark', 'Vetement',1200);
Insert into Magasin value (21, 'Jules', 'Vetement',624);

Insert into Emplacement value (1, 'A1', 50, 'Standard', 10.5);
Insert into Emplacement value (2, 'B2', 50, 'Standard', 20.5);
Insert into Emplacement value (3, 'A3', 75, 'Standard', 11.5);
Insert into Emplacement value (4, 'B4', 55, 'Standard', 23.0);
Insert into Emplacement value (5, 'A5', 90, 'Privilégié', 100.5);
>>>>>>> Stashed changes
