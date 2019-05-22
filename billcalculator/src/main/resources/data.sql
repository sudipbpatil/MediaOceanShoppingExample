/*
create table product_tax
(
  id integer NOT null,
  catagory_id integer NOT null,
  catagory_name varchar(255) NOT null,
  tax double NOT null,
  primary key(id)
);
*/
insert into product_tax values(5001,'CATAGORY_A',0.10);
insert into product_tax values(5002,'CATAGORY_B',0.20);
insert into product_tax values(5003,'CATAGORY_C',0.30);



/*
create table product_attribute
(
  id integer NOT null,
  product_id integer NOT null,
  price double NOT null,
  catagory_id integer NOT null,
  primary key(id)
);*/

insert into product_attribute values(1001,50000,5001);
insert into product_attribute values(1002,30000,5001);
insert into product_attribute values(1003,4000,5002);
insert into product_attribute values(1004,2000,5002);
insert into product_attribute values(1005,100,5003);
insert into product_attribute values(1006,500,5003);


/*create table product
(
  id integer NOT null,
  name varchar(255) NOT null,
  description varchar(255) NOT null,
  primary key(id)
);
*/
insert into product values(1001,'PC','Dell desktop PC');
insert into product values(1002,'TV','Samsung TV');
insert into product values(1003,'Jeans','pants');
insert into product values(1004,'T-Shirt','shirt');
insert into product values(1005,'Juice','Mango Juice');
insert into product values(1006,'Biryani Rice','rice');





