-- creation database script
--please don't modify existing line, just add yours

CREATE table Client (
idClient integer not null,
clientName varchar(30) not null,
clientSurname varchar(30) not null,
birthdate date not null,
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
nameKeyWord varchar(20)
PRIMARY KEY(idKeyWord));

CREATE table Product (
idProduct integer not null,
productReference varchar(50) not null,
stock integer not null,
price integer not null,
keyword varchar(20) not null,
PRIMARY KEY(idProduct),
foreign key (keyword) references KeyWord(nameKeyWord);
);

CREATE table PurchaseHistory (
idPurchaseHistory integer not null,
idProduct integer not null,
idClient integer not null,
purchaseDate date not null,
Quantity integer not null,
PRIMARY KEY(idProduct),
foreign key(idProduct) references Product(idProduct),
foreign key(idClient) references Client(idClient) 
);