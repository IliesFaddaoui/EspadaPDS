-- Clean database script

delete on cascade from LinkTPKeyword;
delete on cascade from EtablishedProfile;
delete on cascade from PurchaseHistory;
delete on cascade from KeyWord;
delete on cascade from Product;
delete on cascade from TypicalProfile;
delete on cascade from Client;
delete on cascade from Emplacement;
delete on cascade from Magasin;
delete on cascade from ChiffreDaffaires;
delete on cascade from Frequentation;
delete on cascade from Stock;
delete on cascade from Occupation;



drop table LinkTPKeyword;
drop table EtablishedProfile;
drop table PurchaseHistory;
drop table Product;
drop table TypicalProfile;
drop table KeyWord;
drop table Client;
drop table Emplacement;
drop table Magasin;
drop table ChiffreDaffaires;
drop table Frequentation;
drop table Stock;
drop table Occupation;