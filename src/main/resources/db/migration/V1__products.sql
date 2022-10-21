create table if not exists products (id bigserial primary key, title varchar(255), price int);

insert into products (title, price)
values
    ('Bacon', 139),
    ('Beef', 511),
    ('Chicken', 356),
    ('Ham', 128),
    ('Pork', 486),
    ('Beans', 28),
    ('Cucumber', 132),
    ('Pumpkin', 78),
    ('Onion', 13),
    ('Banana', 74),
    ('Grape', 211),
    ('Melon', 179),
    ('Pear', 85),
    ('Raspberry', 200),
    ('Butter', 115),
    ('Cheese', 177),
    ('Cookie', 60),
    ('Cracker', 34),
    ('Honey', 352),
    ('Milk', 182);