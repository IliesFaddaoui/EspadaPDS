-- Clean database script

delete from LinkTPKeyword;
delete from LinkClientTP;
delete from PurchaseHistory;
delete from Product;
delete from KeyWord;
delete from TypeProfile;
delete from Client;
delete from Emplacement;
delete from Magasin;
delete from ChiffreDaffaires;
delete from Frequentation;
delete from Stock;
delete from Occupation;
delete from BonDeLivraison;


drop table LinkTPKeyword;
drop table LinkClientTP;
drop table PurchaseHistory;
drop table TypeProfile;
drop table Client;
drop table ChiffreDaffaires;
drop table Frequentation;
drop table Stock;
drop table Product;
drop table Occupation;
drop table Emplacement;
drop table Magasin;
drop table KeyWord;
drop table BonDeLivraison;