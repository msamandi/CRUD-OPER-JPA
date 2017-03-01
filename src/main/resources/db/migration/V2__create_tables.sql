
CREATE TABLE IF NOT EXISTS PRODUCT (
	ID LONG NOT NULL PRIMARY KEY,
	CATEGORY VARCHAR(100),
	TYPE VARCHAR(500),
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
    NAME VARCHAR(100),
    CONTRACTOR LONG,
    CLIENT LONG,
    CREATED DATE,
    JOBSPECS ARRAY
);

ALTER TABLE JOB
    ADD FOREIGN KEY (CLIENT)
    REFERENCES public.TPUSER(ID);

ALTER TABLE JOB
    ADD FOREIGN KEY (CONTRACTOR)
    REFERENCES public.TPUSER(ID);

insert into PRODUCT (ID, CATEGORY, TYPE, DESCRIPTION, PRICE) values
    (2001200, 'Labour','General', 'Labour', 15.00),
    (2001201, 'Labour','Special', 'Specialised Labour', 17.00),
    (2001242, 'Materials','Paint', 'Magnolia Dulux Paint', 25.2),
    (2001255, 'Parts','Sink', 'Kitchen Sink', 100),
    (2001250, 'Parts','Angles', 'Simpson Light Duty Angle Bracket 50mm x 50mm', 1.75),
    (2001245, 'Other','Food', 'Food when working on site', 9.5),
    (2001287, 'Parts','Lighting', '4Trade Gu10 5W LED', 5.99),
    (2001297, 'Parts','Shower', 'Mira Excel Shower EV Valve & Kit All Chrome', 288.5),
    (2001298, 'Parts','Shower', 'Novellini Cu1407011 30 Custom Shower Tray White 1400mm x 700mm', 343.45),
    (2001202, 'Parts','Shower', 'iflo ABS Capped Slimline Stone Shower Tray 900mm x 900mm', 120.83),
    (2001205, 'Parts','Top', 'iflo Worktop Laminate 2 M x 485 x 28 mm G Grey', 99.16),
    (2001207, 'Parts','Basin', 'Form 400 Hand Basin Unit/Odessa Oak ', 254.05),
    (2001208, 'Parts','Basin', 'Roca 32778A000 Dama-N Compact Basin 1 Tap Hole 400mm x 320mm ', 100.72),
    (2001209, 'Parts','Toilet', 'Roca A80178C004 Dama N Compact Soft Close Seat W ', 120.87),
    (2001210, 'Parts','Toilet', 'IFLO CASCADA WC PACK', 170.23),
    (2001211, 'Parts','Alarm', 'Honeywell 10 Year Battery Smoke Alarm XS100', 19.12),
    (2001212, 'Parts','Toilet', 'Dudley Tri-Shell Low Level Cistern', 89.45),
    (2001288, 'Materials','Sealant', '4TRADE Frame Silicone Sealant Clear', 4.15),
    (2001289, 'Materials','Adhesives', 'Pro Flexible Grey Tile Adhesive', 13.14);

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
    (21, 'George Neutral','447561230987', 'gneutral@gmail.com', 200, NULL, NULL),
    (1, 'John McCain','445533902100', 'johnmc@gmail.com', 201, 300, 400),
    (17, 'Jodie Rogers','449876899343', 'jrodgers@gmail.com', 202, NULL, NULL),
    (23, 'Tony Plowman','448765233452', 'tplowman@gmail.com', 203, NULL, NULL),
    (12, 'Stuart White','447564448987', 'swhite@gmail.com', 204, NULL, NULL),
    (2, 'Anthony Kaveria','447653482614', 'akaveria@gmail.com', 205, 301, 401);

insert into TPUSER (ID, TYPE, USERINFO) values
    (2500, 0, 21),
    (2501, 1, 1),
    (2502, 0, 17),
    (2503, 0, 23),
    (2504, 0, 12),
    (2505, 1, 2);

insert into ITEM (ID, QUANTITY, PRODUCT) values
    (300012, 2, 2001200),
    (300013, 1, 2001255),
    (300014, 2, 2001245),
    (300015, 15, 2001200),
    (300016, 1, 2001297),
    (300017, 1, 2001298),
    (300018, 1, 2001202),
    (300019, 2, 2001207),
    (300020, 2, 2001208),
    (300021, 1, 2001209),
    (300022, 1, 2001210),
    (300023, 1, 2001212),
    (300024, 1, 2001288),
    (300025, 1, 2001289),
    (300026, 2, 2001211),
    (300027, 1, 2001200),
    (300028, 7, 2001287),
    (300029, 1, 2001200),
    (300030, 2, 2001200),
    (300031, 1, 2001255);



insert into JOBSPEC (ID, ISQUOTEGENERATED, CREATED, QUOTECREATED, UPDATED, ITEMS) values
  (7992, false, '2017-02-28', '2017-02-28', '2017-02-28', (300012,300013,300014)),
  (7384, true, '2017-02-10', '2017-02-11', '2017-02-11', (300015, 300016, 300017, 300018, 300019, 300020, 300021, 300022, 300023, 300024, 300025)),
  (1233, false, '2017-01-08',  '2017-01-08', '2017-01-10', (300026,300027)),
  (3542, true, '2017-01-12', '2017-01-12', '2017-01-12', (300028, 300029)),
  (4689, true, '2016-12-22', '2016-12-22', '2016-12-22', (300030, 300031));

insert into JOB (ID, NAME, CONTRACTOR, CLIENT, CREATED, JOBSPECS) values
  (123, 'Kitchen Fitting', 2501, 2502, '2017-02-13', (7992)),
  (439, 'Bathroom Refurbishment', 2501, 2503, '2017-01-07', (7384)),
  (128, 'Security Check', 2505, 2504, '2016-12-05', (4689)),
  (231, 'Lighting Upgrade', 2505, 2500, '2016-10-23', (1233, 3452));




