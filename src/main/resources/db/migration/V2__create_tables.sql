-- Drop table scripts

DROP TABLE IF EXISTS `ADDRESS`;
DROP TABLE IF EXISTS `PAYMENT_DETAILS`;
DROP TABLE IF EXISTS `COMPANY_DETAILS`;
DROP TABLE IF EXISTS `USERINFO`;
DROP TABLE IF EXISTS `TPUSER`;
DROP TABLE IF EXISTS `JOB`;
DROP TABLE IF EXISTS `TASK`;
DROP TABLE IF EXISTS `ITEM`;
DROP TABLE IF EXISTS `TAG`;
DROP TABLE IF EXISTS `ITEM_TAG`;

-- Create table scripts

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
    ADDRESS_ID LONG,
    CONSTRAINT `FK_COMPANY_DETAILS_ADDRESS_ID` FOREIGN KEY (ADDRESS_ID) REFERENCES public.ADDRESS(ID)

);



CREATE TABLE IF NOT EXISTS USERINFO (
    ID LONG NOT NULL PRIMARY KEY,
    NAME VARCHAR(100),
    PHONE VARCHAR(100),
    EMAIL VARCHAR(100),
    ADDRESS_ID LONG,
    PAYMENT_DETAILS_ID LONG,
    COMPANY_DETAILS_ID LONG,
    CONSTRAINT `FK_USERINFO_ADDRESS` FOREIGN KEY (ADDRESS_ID) REFERENCES public.ADDRESS(ID),
    CONSTRAINT `FK_USERINFO_PAYMENT_DETAILS_ID` FOREIGN KEY (PAYMENT_DETAILS_ID) REFERENCES public.PAYMENT_DETAILS(ID),
    CONSTRAINT `FK_USERINFO_COMPANY_DETAILS_ID` FOREIGN KEY (COMPANY_DETAILS_ID) REFERENCES public.COMPANY_DETAILS(ID)


);




CREATE TABLE IF NOT EXISTS TPUSER (
    ID LONG NOT NULL PRIMARY KEY,
    TYPE VARCHAR(50),
    USERINFO_ID LONG,
    CONSTRAINT `FK_TPUSER_USERINFO_ID` FOREIGN KEY (USERINFO_ID)  REFERENCES public.USERINFO(ID)

);



CREATE TABLE IF NOT EXISTS JOB (
    ID LONG NOT NULL PRIMARY KEY,
    NAME VARCHAR(100),
    CONTRACTOR_ID LONG,
    CLIENT_ID LONG,
    CREATED DATE ,
    CONSTRAINT `FK_JOB_CLIENT_ID` FOREIGN KEY (CLIENT_ID) REFERENCES public.TPUSER(ID),
    CONSTRAINT `FK_JOB_CONTRACTOR_ID` FOREIGN KEY (CONTRACTOR_ID) REFERENCES public.TPUSER(ID)
);



CREATE TABLE IF NOT EXISTS TASK (
    ID LONG NOT NULL PRIMARY KEY,
    NAME VARCHAR(1000),
    ISQUOTEGENERATED BOOLEAN,
    CREATED DATE,
    QUOTECREATED DATE,
    UPDATED DATE,
    JOB_ID LONG,
    PAYMENT_TERMS VARCHAR(1000),
    VAT INTEGER,
    CONSTRAINT `FK_TASK_JOB_ID`
            FOREIGN KEY (JOB_ID)
                REFERENCES public.JOB(ID)
);



CREATE TABLE IF NOT EXISTS ITEM (
    ID LONG NOT NULL PRIMARY KEY,
    QUANTITY INTEGER,
    TASK_ID LONG,
    CATEGORY VARCHAR(100),
    TYPE VARCHAR(500),
    DESCRIPTION VARCHAR(1000),
    PRICE DOUBLE,
    CONSTRAINT `FK_ITEM_TASK_ID`
        FOREIGN KEY (TASK_ID)
        REFERENCES public.TASK(ID)
);

CREATE TABLE IF NOT EXISTS TAG (
    ID LONG NOT NULL PRIMARY KEY,
    NAME VARCHAR(500)

);

CREATE TABLE IF NOT EXISTS ITEM_TAG (
    ID LONG NOT NULL PRIMARY KEY,
    ITEM_ID LONG,
    TAG_ID LONG,
    CONSTRAINT `FK_ITEM_TAG_ITEM_ID`
            FOREIGN KEY (ITEM_ID)
            REFERENCES public.ITEM(ID),
    CONSTRAINT `FK_ITEM_TAG_TAG_ID`
                FOREIGN KEY (TAG_ID)
                REFERENCES public.TAG(ID)

);

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

insert into COMPANY_DETAILS (ID, NAME, ADDRESS_ID, VAT) values
    (400, 'Mccain Plumbing',207, 'GB 214422'),
    (401, 'Kaveria Builders',206, 'GB 129821');

insert into USERINFO (ID, NAME, PHONE, EMAIL, ADDRESS_ID, PAYMENT_DETAILS_ID, COMPANY_DETAILS_ID) values
    (21, 'George Neutral','447561230987', 'gneutral@gmail.com', 200, NULL, NULL),
    (1, 'John McCain','445533902100', 'johnmc@gmail.com', 201, 300, 400),
    (17, 'Jodie Rogers','449876899343', 'jrodgers@gmail.com', 202, NULL, NULL),
    (23, 'Tony Plowman','448765233452', 'tplowman@gmail.com', 203, NULL, NULL),
    (12, 'Stuart White','447564448987', 'swhite@gmail.com', 204, NULL, NULL),
    (2, 'Anthony Kaveria','447653482614', 'akaveria@gmail.com', 205, 301, 401);

insert into TPUSER (ID, TYPE, USERINFO_ID) values
    (2500, 'TPClient', 21),
    (2502, 'TPClient', 17),
    (2503, 'TPClient', 23),
    (2504, 'TPClient', 12),
    (2501, 'TPContractor', 1),
    (2505, 'TPContractor', 2);

insert into JOB (ID, NAME, CONTRACTOR_ID, CLIENT_ID, CREATED) values
    (123, 'Kitchen Fitting', 2501, 2502, '2017-02-13'),
    (439, 'Bathroom Refurbishment', 2501, 2503, '2017-01-07'),
    (128, 'Security Check', 2505, 2504, '2016-12-05'),
    (231, 'Lighting Upgrade', 2505, 2500, '2016-10-23');

insert into TASK (ID, ISQUOTEGENERATED, NAME, CREATED, QUOTECREATED, UPDATED, JOB_ID, PAYMENT_TERMS, VAT) values
   (7992, false, 'Task 1', '2017-02-28', '2017-02-28', '2017-02-28', 123, '20% Upfront, Rest on completion', 20),
   (7384, true, 'Task 2', '2017-02-10', '2017-02-11', '2017-02-11', 439, '50% Upfront, Rest on completion', 20),
   (1233, false, 'Task 3' ,'2017-01-08',  '2017-01-08', '2017-01-10', 231, '0% Upfront, Rest on completion', 20),
   (3542, true, 'Task 4', '2017-01-12', '2017-01-12', '2017-01-12', 231, '', 20),
   (4689, true, 'Task 5' ,'2016-12-22', '2016-12-22', '2016-12-22', 128, '20% Upfront, Rest on completion', 20);

insert into ITEM (ID, QUANTITY, TASK_ID, CATEGORY, TYPE, DESCRIPTION, PRICE) values
    (300012, 2, 7992, 'Labour','General', 'Labour', 15.00),
    (300013, 1, 7992, 'Parts','Sink', 'Kitchen Sink', 100),
    (300014, 2, 7992, 'Other','Food', 'Food when working on site', 9.5),
    (300015, 15, 7384, 'Labour','General', 'Labour', 15.00),
    (300016, 1, 7384, 'Parts','Shower', 'Mira Excel Shower EV Valve & Kit All Chrome', 288.5),
    (300017, 1, 7384, 'Parts','Shower', 'Novellini Cu1407011 30 Custom Shower Tray White 1400mm x 700mm', 343.45),
    (300018, 1, 7384, 'Parts','Shower', 'iflo ABS Capped Slimline Stone Shower Tray 900mm x 900mm', 120.83),
    (300019, 2, 7384, 'Parts','Basin', 'Form 400 Hand Basin Unit/Odessa Oak ', 254.05),
    (300020, 2, 7384, 'Parts','Basin', 'Roca 32778A000 Dama-N Compact Basin 1 Tap Hole 400mm x 320mm ', 100.72),
    (300021, 1, 7384, 'Parts','Toilet', 'Roca A80178C004 Dama N Compact Soft Close Seat W ', 120.87),
    (300022, 1, 7384, 'Parts','Toilet', 'IFLO CASCADA WC PACK', 170.23),
    (300023, 1, 7384, 'Parts','Toilet', 'Dudley Tri-Shell Low Level Cistern', 89.45),
    (300024, 1, 7384, 'Materials','Sealant', '4TRADE Frame Silicone Sealant Clear', 4.15),
    (300025, 1, 7384, 'Materials','Adhesives', 'Pro Flexible Grey Tile Adhesive', 13.14),
    (300026, 2, 1233, 'Parts','Alarm', 'Honeywell 10 Year Battery Smoke Alarm XS100', 19.12),
    (300027, 1, 1233, 'Labour','General', 'Labour', 15.00),
    (300028, 7, 3542, 'Parts','Lighting', '4Trade Gu10 5W LED', 5.99),
    (300029, 1, 3542, 'Labour','General', 'Labour', 15.00),
    (300030, 2, 4689, 'Labour','General', 'Labour', 15.00),
    (300031, 1, 4689, 'Parts','Sink', 'Kitchen Sink', 100),
    (300032, 1, 7384, 'Materials','Shower', 'Grohe Rapido Shower Valve', 5.99),
    (300033, 1, 7384, 'Materials','Shower', '4TRADE Frame Silicone Sealant Clear', 4.15),
    (300034, 1, 7384, 'Materials','Shower', 'Pro Flexible Grey Tile Adhesive', 13.14),
    (300035, 1, 7384, 'Parts','Shower', 'Iflo Architect + Fixed Drench Shower Head Thermostatic Bar Mixer Shower', 24.99),
    (300036, 1, 7384, 'Parts','Shower', 'Croydex Shower Curtain Plain White', 28.99),
    (300037, 1, 7384, 'Parts','Shower', 'iflo Rapid Secure Shower Fixing Kit', 21.66),
    (300038, 1, 7384, 'Parts','Shower', 'iflo Shower Riser Rail Chrome 650mm', 191.14),
    (300039, 1, 7384, 'Parts','Shower', 'Domed Chrome Shower Tray Waste 35 mm', 13.33),
    (300040, 1, 7384, 'Labour','Shower', 'Fitting Shower', 20),
    (300041, 1, 7384, 'Parts','Basin', 'Twyfords FC1271WH Belfast Sink White 610 x 455 x 255mm', 49.99),
    (300042, 1, 7384, 'Materials','Basin', 'McAlpine ASC10-SP Tubular Swivel Sink Trap 38mm', 39.99),
    (300043, 1, 7384, 'Materials','Basin', '4Trade Chrome Basin/Sink Tap Heads', 20.99),
    (300044, 1, 7384, 'Parts','Basin', '1 1/2in Double Bowl Sink Kit SK2', 24.99);

    insert into TAG (ID, NAME) values
        (600012, 'General'),
        (600013, 'Sink'),
        (600014, 'Food'),
        (600015, 'General'),
        (600016, 'Shower'),
        (600017, 'Toilet'),
        (600018, 'Basin'),
        (600019, 'Sealant'),
        (600020, 'Adhesives'),
        (600021, 'Alarm'),
        (600022, 'Lighting') ;

    insert into ITEM_TAG (ID, ITEM_ID, TAG_ID) values
        (60012, 300012, 600012),
        (60013, 300013, 600013),
        (60014, 300031, 600013),
        (60015, 300016, 600016),
        (60016, 300017, 600016),
        (60017, 300018, 600016),
        (60018, 300015, 600012),
        (60019, 300016, 600012);


