
CREATE TABLE IF NOT EXISTS PRODUCT (
	ID LONG NOT NULL PRIMARY KEY,
	TYPE VARCHAR(100),
	NAME VARCHAR(500),
	DESCRIPTION VARCHAR(1000),
	PRICE DOUBLE
);

CREATE TABLE IF NOT EXISTS ITEM (
    ID LONG NOT NULL PRIMARY KEY,
    QUANTITY INTEGER,
    PRODUCT LONG
);

ALTER TABLE ITEM
    ADD FOREIGN KEY (PRODUCT)
    REFERENCES public.PRODUCT(ID);

CREATE TABLE IF NOT EXISTS ADDRESS (
    ID LONG NOT NULL PRIMARY KEY,
    LINE1 VARCHAR(100),
    LINE2 VARCHAR(100),
    POSTCODE VARCHAR(11),
    COUNTRY VARCHAR(50),
    COUNTY VARCHAR(50),
    CITY VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS PAYMENT_DETAILS (
    ID LONG NOT NULL PRIMARY KEY,
    SORTCODE VARCHAR(6),
    ACCOUNT_NUMBER VARCHAR(8),
    ACCOUNT_HOLDER_NAME VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS COMPANY_DETAILS (
    ID LONG NOT NULL PRIMARY KEY,
    NAME VARCHAR(100),
    VAT VARCHAR(50),
    ADDRESS LONG
);

ALTER TABLE COMPANY_DETAILS
    ADD FOREIGN KEY (ADDRESS)
    REFERENCES public.ADDRESS(ID);

CREATE TABLE IF NOT EXISTS USERINFO (
    ID LONG NOT NULL PRIMARY KEY,
    NAME VARCHAR(100),
    PHONE VARCHAR(100),
    EMAIL VARCHAR(100),
    ADDRESS LONG,
    PAYMENT_DETAILS LONG,
    COMPANY_DETAILS LONG
);

ALTER TABLE USERINFO
    ADD FOREIGN KEY (ADDRESS)
    REFERENCES public.ADDRESS(ID);

ALTER TABLE USERINFO
    ADD FOREIGN KEY (PAYMENT_DETAILS)
    REFERENCES public.PAYMENT_DETAILS(ID);

ALTER TABLE USERINFO
    ADD FOREIGN KEY (COMPANY_DETAILS)
    REFERENCES public.COMPANY_DETAILS(ID);


CREATE TABLE IF NOT EXISTS TPUSER (
    ID LONG NOT NULL PRIMARY KEY,
    TYPE INTEGER,
    USERINFO LONG
);


ALTER TABLE TPUSER
    ADD FOREIGN KEY (USERINFO)
    REFERENCES public.USERINFO(ID);

CREATE TABLE IF NOT EXISTS JOBSPEC (
    ID LONG NOT NULL PRIMARY KEY,
    ISQUOTEGENERATED BOOLEAN,
    CREATED DATE,
    QUOTECREATED DATE,
    UPDATED DATE,
    ITEMS ARRAY
);


CREATE TABLE IF NOT EXISTS JOB (
    ID LONG NOT NULL PRIMARY KEY,
    CONTRACTOR LONG,
    CLIENT LONG,
    CREATED DATE,
    JOBSPECS ARRAY
);

ALTER TABLE JOB
    ADD FOREIGN KEY (CLIENT)
    REFERENCES public.USERINFO(ID);

ALTER TABLE JOB
    ADD FOREIGN KEY (CONTRACTOR)
    REFERENCES public.USERINFO(ID);

insert into PRODUCT (ID, TYPE, NAME, DESCRIPTION, PRICE) values
    (2001200, 'Labour','Labour', 'Paint Labour', 15.00),
    (2001242, 'Materials','Dulux Paint', 'Magnolia Dulux Paint', 25.2),
    (2001255, 'Materials','Sink', 'Kitchen Sink', 100),
    (2001250, 'Materials','Angles', 'Simpson Light Duty Angle Bracket 50mm x 50mm', 1.75),
    (2001245, 'Other','Food', 'Food when working on site', 9.5),
    (2001287, 'Materials','Lighting', '4Trade Gu10 5W LED', 5.99),
    (2001297, 'Materials','Bathroom', 'Mira Excel Shower EV Valve & Kit All Chrome', 288.5),
    (2001202, 'Materials','Bathroom', 'iflo ABS Capped Slimline Stone Shower Tray 900mm x 900mm', 120.83),
    (2001205, 'Materials','Kitchen', 'iflo Worktop Laminate 2 M x 485 x 28 mm G Grey', 99.16),
    (2001207, 'Materials','Bathroom', 'Form 400 Hand Basin Unit/Odessa Oak ', 254.05),
    (2001209, 'Materials','Bathroom', 'Roca A80178C004 Dama N Compact Soft Close Seat W ', 120.87),
    (2001211, 'Materials','Alarm', 'Honeywell 10 Year Battery Smoke Alarm XS100', 19.12);

insert into ADDRESS (ID, LINE1, LINE2, POSTCODE, CITY, COUNTY, COUNTRY) values
    (200, '26 Rose Court','Bromley', 'BR3 2SS', 'London', '', 'UK'),
    (201, '26 Bakerloo Close','Maida Vale', 'W4 3LS', 'London', '', 'UK'),
    (202, '173 Rosebery Avenue','Flat 61', 'EC1R 4UN', 'London', '', 'UK'),
    (203, '77 Great Eastern Street','', 'EC2A 3HU', 'London', '', 'UK'),
    (204, 'Flat 4 Rosewood House','35 Vauxhall Grove', 'SW8 1TB', 'London', '', 'UK'),
    (205, '10 Bath Street','Flat 81', 'EC1V 9ET', 'London', '', 'UK'),
    (206, '29 Rosechill Avenue','Offices', 'E14 5EY', 'London', '', 'UK'),
    (207, 'Unit 1 Gordon House','Alperton', 'W10 3NN', 'London', '', 'UK');

insert into PAYMENT_DETAILS (ID, SORTCODE, ACCOUNT_NUMBER, ACCOUNT_HOLDER_NAME) values
    (300, '232312','12312345', 'John Mccain'),
    (301, '902385','22755878', 'Anthony Kaveria');

insert into COMPANY_DETAILS (ID, NAME, ADDRESS, VAT) values
    (400, 'Mccain Plumbing',207, 'GB 214422'),
    (401, 'Kaveria Builders',206, 'GB 129821');

insert into USERINFO (ID, NAME, PHONE, EMAIL, ADDRESS, PAYMENT_DETAILS, COMPANY_DETAILS) values
    (20, 'George Neutral','447561230987', 'gneutral@gmail.com', 200, NULL, NULL),
    (21, 'John McCain','445533902100', 'johnmc@gmail.com', 201, 300, 400),
    (22, 'Jodie Rogers','449876899343', 'jrodgers@gmail.com', 202, NULL, NULL),
    (23, 'Tony Ploughman','448765233452', 'tplowman@gmail.com', 203, NULL, NULL),
    (24, 'Stuart White','447564448987', 'swhite@gmail.com', 204, NULL, NULL),
    (25, 'Anthony Kaveria','447653482614', 'akaveria@gmail.com', 205, 301, 401);

insert into TPUSER (ID, TYPE, USERINFO) values
    (2500, 0, 20),
    (2501, 1, 21),
    (2502, 0, 22),
    (2503, 0, 23),
    (2504, 0, 24),
    (2505, 1, 25);

insert into ITEM (ID, QUANTITY, PRODUCT) values
    (300012, 2, 2001200),
    (300013, 1, 2001255),
    (300014, 2, 2001245),
    (300015, 1, 2001297),
    (300016, 1, 2001202),
    (300017, 1, 2001209),
    (300018, 1, 2001207),
    (300019, 8, 2001200),
    (300020, 3, 2001211),
    (300021, 1, 2001200),
    (300022, 7, 2001287),
    (300023, 1, 2001200),
    (300024, 2, 2001200),
    (300025, 1, 2001255);

