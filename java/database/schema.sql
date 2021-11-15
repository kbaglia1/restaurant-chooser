BEGIN TRANSACTION;

DROP TABLE IF EXISTS restaurant_food_type;
DROP TABLE IF EXISTS food_type;
DROP TABLE IF EXISTS menu_item;
DROP TABLE IF EXISTS restaurant;


CREATE TABLE restaurant (
        id SERIAL,
        name varchar(80) NOT NULL,
        price_point smallint NOT NULL CHECK (price_point >= 1 AND price_point <= 5),
        has_seating boolean,
        has_drive_thru boolean,
        has_online_ordering boolean,
        
        CONSTRAINT pk_restaurant PRIMARY KEY (id)
);

CREATE TABLE menu_item (
        id SERIAL,
        name varchar(100) NOT NULL,
        restaurant_id int,
        
        CONSTRAINT pk_menu_item PRIMARY KEY (id),
        CONSTRAINT fk_menu_item_restaurant_id FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)
);

CREATE TABLE food_type (
        id SERIAL,
        name varchar(100) NOT NULL,
        
        CONSTRAINT pk_food_type PRIMARY KEY (id)
);

CREATE TABLE restaurant_food_type (
        restaurant_id int,
        food_type_id int,
        
        CONSTRAINT pk_restaurant_food_type PRIMARY KEY (restaurant_id, food_type_id),
        CONSTRAINT fk_restaurant_id FOREIGN KEY (restaurant_id) REFERENCES restaurant (id),
        CONSTRAINT fk_food_type_id FOREIGN KEY (food_type_id) REFERENCES food_type (id)
);

INSERT INTO restaurant (name, price_point, has_seating, has_drive_thru, has_online_ordering)
        VALUES ('Chick-fil-A', 2, true, true, true),
                ('Olive Garden', 2, true, false, true),
                ('Papa Joe''s', 3, true, false, true),
                ('Longhorn Steakhouse', 4, true, false, true),
                ('Fleming''s', 5, true, false, true),
                ('Giovanni''s Ristorante', 5, true, false, false),
                ('Chipotle', 2, true, false, true),
                ('Taco Bell', 1, true, true, true),
                ('McDonald''s', 1, true, true, true),
                ('Penn Station', 2, true, false, true),
                ('Gasoline Alley', 2, true, false, false),
                ('Ray''s Place', 2, true, false, false),
                ('Leo''s Italian Social', 4, true, false, true),
                ('Hibachi Japan', 3, true, false, false), 
                ('Shogun Japanese Steakhouse', 3, true, false, true),
                ('P.F. Chang''s', 3, true, false, true),
                ('First Watch', 2, true, false, true),
                ('Wally Waffle', 2, true, false, false),
                ('Michael''s A.M.', 2, true, false, false),
                ('The Winking Lizard', 2, true, false, true),
                ('Domino''s', 2, false, false, true);
                
INSERT INTO food_type (name)
        VALUES ('Fast Food'),
                ('Italian'),
                ('Steakhouse'),
                ('Bar'),
                ('Japanese'),
                ('Chinese'),
                ('Mexican'),
                ('Breakfast'),
                ('Pizza');
                
INSERT INTO menu_item (name, restaurant_id)
        VALUES ('Chick-fil-A Sandwich (No pickle)', 1),
                ('Mac and Cheese', 1),
                ('Chicken Carbonara', 2),
                ('Chicken Alfredo', 2),
                ('Chicken Marsala', 3),
                ('Chicken Francaise', 3),
                ('Lasagna', 3),
                ('Outlaw Ribeye', 4),
                ('Texas Tonion', 4),
                ('Double Steak Burrito', 7),
                ('Large Chips and Queso', 7),
                ('Chicken Parm Sub', 10),
                ('Chicken Teryaki Sub', 10),
                ('Ravioli', 13),
                ('Chang''s Spicy Chicken', 16),
                ('Handmade Pan Pizza', 21),
                ('Parmesean Twists', 21),
                ('Garlic Twists', 21);
                
INSERT INTO restaurant_food_type (restaurant_id, food_type_id)
        VALUES (1, 1),
                (2, 2),
                (3, 2),
                (4, 3),
                (5, 3),
                (6, 2),
                (7, 1),
                (7, 7),
                (8, 1),
                (8, 7),
                (9, 1),
                (10, 1),
                (11, 4),
                (12, 4),
                (13, 2),
                (13, 4),
                (14, 3),
                (14, 5),
                (15, 3),
                (15, 5),
                (16, 6),
                (17, 8),
                (18, 8),
                (19, 8),
                (20, 4),
                (21, 9);

COMMIT;