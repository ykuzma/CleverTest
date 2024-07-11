create table if not exists product (
                                       id  bigserial primary key,
                                       description varchar(50) not null ,
    price decimal not null ,
    quantity_in_stock integer,
    wholesale_product boolean);

insert into product (description, price, quantity_in_stock, wholesale_product) VALUES
                                                                                   ('Milk',1.07,10, true),
                                                                                   ('Cream 400g',2.71,20, true),
                                                                                   ('Yogurt 400g',2.1,7,true),
                                                                                   ('Packed potatoes 1kg',1.47,30,false),
                                                                                   ('Packed cabbage 1kg',1.19,15,false),
                                                                                   ('Packed tomatoes 350g',1.6,50,false),
                                                                                   ('Packed apples 1kg',2.78,18,false),
                                                                                   ('Packed oranges 1kg',3.2,12,false),
                                                                                   ('Packed bananas 1kg',1.1,25,true),
                                                                                   ('Packed beef fillet 1kg',12.8,7,false),
                                                                                   ('Packed pork fillet 1kg',8.52,14,false),
                                                                                   ('Packed chicken breasts 1kg Sour',10.75,18,false),
                                                                                   ('Baguette 360g',1.3,10,true),
                                                                                   ('Drinking water1,5l',0.8,100,false),
                                                                                   ('Olive oil 500ml',5.3,16,false),
                                                                                   ('Sunflower oil 1l',1.2,12,false),
                                                                                   ('Chocolate Ritter sport 100g',1.1,50,true),
                                                                                   ('Paulaner 0,5l',1.1,100,false),
                                                                                   ('Whiskey Jim Beam 1l',13.99,30,false),
                                                                                   ('Whiskey Jack Daniels 1l',17.19,20,false);

create table if not exists discount_card (
                                             id bigserial primary key,
                                             number integer not null,
                                             amount smallint check ( amount >= 0 and discount_card.amount <= 100)
    );

insert into discount_card (number, amount) VALUES
                                               (1111, 3),
                                               (2222, 3),
                                               (3333, 4),
                                               (4444, 5);