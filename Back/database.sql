CREATE TABLE Category(
cId IDENTITY,
cName VARCHAR(50),
cDesc VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY(cId)




);

INSERT INTO category(cName,cDesc,image_url,is_active) VALUES ('MOBILE','SAMSUNG MOBILE','ABC.1',true);
INSERT INTO category(cName,cDesc,image_url,is_active) VALUES ('tv','SAMSUNG tv','ABC.2',true);
INSERT INTO category(cName,cDesc,image_url,is_active) VALUES ('laptop','SAMSUNG laptop','ABC.3',true);

CREATE TABLE user_detail(

uId IDENTITY,
fname VARCHAR(50),
lname VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
Password VARCHAR(50),
email VARCHAR(50),
contactNumber VARCHAR(50),
CONSTRAINT pk_user_id PRIMARY KEY(uId),

);

INSERT INTO user_detail
(Fname,Lname,Role,Enabled,Password,Email,ContactNumber)
VALUES('mohit','vats','ADMIN','true','admin','mohit@gmail.com','6666666666');

INSERT INTO user_detail
(Fname,Lname,Role,Enabled,Password,Email,ContactNumber)
VALUES('aman','vats','SUPPLIER','true','aman','aman@gmail.com','888888888');

INSERT INTO user_detail
(Fname,Lname,Role,Enabled,Password,Email,ContactNumber)
VALUES('rohit','vats','SUPPLIER','true','rohit','rohit@gmail.com','99999999999');



CREATE TABLE Product(

pId IDENTITY,
pCode VARCHAR(50),
pName VARCHAR(50),
pBrand VARCHAR(50),
pDesc VARCHAR(255),
pPrice DECIMAL(10,2),
pQat INT,
is_active BOOLEAN,
category_id INT,
supplier_id INT,
Purchase INT DEFAULT 0,
Views INT DEFAULT 0,

CONSTRAINT pk_Product_id PRIMARY KEY(pId),
CONSTRAINT fk_Product_category_id FOREIGN KEY (category_id) REFERENCES Category (cId),
CONSTRAINT fk_Product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (uId),

);

INSERT INTO Product
(pCode,pName,pBrand,pDesc,pPrice,pQat,is_active,Category_id,Supplier_id,Purchase,Views)
VALUES('PRDd123ejadhe','apple','apple','iphone',12000.00,2,true,1,2,0,0);

INSERT INTO Product
(pCode,pName,pBrand,pDesc,pPrice,pQat,is_active,Category_id,Supplier_id,Purchase,Views)
VALUES('PRDdb456jakhe','samsung','samsung','s4',14000.00,2,true,1,3,0,0);
INSERT INTO Product
(pCode,pName,pBrand,pDesc,pPrice,pQat,is_active,Category_id,Supplier_id,Purchase,Views)
VALUES('PRDd635ejsahe','apple','apple','mac3',32000.00,2,true,3,2,0,0);
INSERT INTO Product
(pCode,pName,pBrand,pDesc,pPrice,pQat,is_active,Category_id,Supplier_id,Purchase,Views)
VALUES('PRDdb459jjkqe','micromax','micromax','canvastv',15000.00,2,true,2,3,0,0);

CREATE TABLE cartLine(

id IDENTITY,
crId int,
total decimal(10,2),
pId int,
pCount int,
buying_price DECIMAL(10,2),
is_available boolean,

CONSTRAINT pk_cartLine_id PRIMARY KEY(id),
CONSTRAINT fk_cartLine_product_id FOREIGN KEY (pId) REFERENCES product (pId),
CONSTRAINT fk_Product_cart_id FOREIGN KEY (crId) REFERENCES cart (crId)

);


