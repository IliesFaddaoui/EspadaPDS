CREATE table Client (
idClient integer not null,
pseudo varchar(30) not null,
password varchar(30) not null,
clientName varchar(30) not null,
clientSurname varchar(30) not null,
phone varchar(13) ,
address varchar(100),
gender varchar(5),
PRIMARY KEY(idClient)
);

CREATE table TypicalProfile (
idTypicalProfile integer not null,
ProfileName varchar(30),
PRIMARY KEY (idTypicalProfile));

CREATE table KeyWord (
idKeyWord integer not null,
nameKeyWord varchar(20),
PRIMARY KEY(idKeyWord));

CREATE table Product (
idProduct integer not null,
productReference varchar(50) not null,
price float not null,
keyword integer not null,
PRIMARY KEY(idProduct),
foreign key (keyword) references KeyWord(idKeyWord)
);

CREATE table PurchaseHistory (
idPurchaseHistory integer not null,
idProduct integer not null,
idClient integer not null,
purchaseDate date not null,
Quantity integer not null,
PRIMARY KEY(idPurchaseHistory),
foreign key(idProduct) references Product(idProduct),
foreign key(idClient) references Client(idClient)
);

CREATE table LinkTPKeyWord (
idLTPKW integer not null,
idKeyWord integer not null,
idTypicalProfile integer not null,
PRIMARY KEY (idLTPKW),
foreign key(idKeyWord) references KeyWord(idKeyWord),
foreign key(idTypicalProfile) references TypicalProfile(idTypicalProfile));

CREATE table EtablishedProfile (
idEtablishedProfile integer not null,
idTypicalProfile integer not null,
idClient integer not null,
PRIMARY KEY(idEtablishedProfile),
foreign key(idTypicalProfile) references TypicalProfile(idTypicalProfile),
foreign key(idClient) references Client(idClient)
);

CREATE table Emplacement (
idEmplacement integer not null,
localisation varchar(30) not null,
superficie integer not null,
categorie varchar(30) not null,
txOccupation float not null,
PRIMARY KEY(idEmplacement)
);

CREATE table Magasin (
idMagasin integer not null,
magasinName varchar(30) not null,
magasinType varchar(30) not null,
magasinSuperficie integer not null,
PRIMARY KEY(idMagasin)
);

CREATE table ChiffreDaffaires (
chiffreDate date not null,
idMagasin integer not null,
Montant integer not null,
PRIMARY KEY(chiffreDate, idMagasin),
foreign key(idMagasin) references Magasin(idMagasin)
);

CREATE table Frequentation (
frequentationDate date not null,
idMagasin integer not null,
niveauFrequentation integer not null,
PRIMARY KEY(frequentationDate, idMagasin),
foreign key(idMagasin) references Magasin(idMagasin)
);

CREATE table Stock (
idMagasin integer not null,
idProduct integer not null,
Quantite integer not null,
dateEntree date not null,
dateSortie date not null,
motifSortie varchar(30) not null,
PRIMARY KEY(idMagasin, idProduct),
foreign key(idMagasin) references Magasin(idMagasin),
foreign key(idProduct) references Product(idProduct)
);

CREATE table Occupation (
idEmplacement integer not null,
idMagasin integer not null,
dateEntree date not null,
dateSortie date not null,
PRIMARY KEY(idEmplacement, idMagasin),
foreign key(idEmplacement) references Emplacement(idEmplacement),
foreign key(idMagasin) references Magasin(idMagasin)
);

CREATE table BonDeLivraison (
numeroBon integer not null,
listProduits varchar(50) not null,
PRIMARY KEY (numeroBon)
);