INSERT INTO BRANDS (name) values ('ZARA');
INSERT INTO BRANDS (name) values ('BRAND1');
INSERT INTO BRANDS (name) values ('BRAND2');

INSERT INTO PRICES (brand_id,start_date,end_date,price_list,product_id,priority,price,currency) VALUES (1,'2020-06-14 00:00:00+02:00','2020-12-31 23:59:59+02:00',1,35455,0,35.50,'EUR');
INSERT INTO PRICES (brand_id,start_date,end_date,price_list,product_id,priority,price,currency) VALUES (1,'2020-06-14 15:00:00+02:00','2020-06-14 18:30:00+02:00',2,35455,1,25.45,'EUR');
INSERT INTO PRICES (brand_id,start_date,end_date,price_list,product_id,priority,price,currency) VALUES (1,'2020-06-15 00:00:00+02:00','2020-06-15 11:00:00+02:00',3,35455,1,30.50,'EUR');
INSERT INTO PRICES (brand_id,start_date,end_date,price_list,product_id,priority,price,currency) VALUES (1,'2020-06-15 16:00:00+02:00','2020-12-31 23:59:59+02:00',4,35455,1,38.95,'EUR');