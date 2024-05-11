-- DDL
CREATE TABLE users(
`user_id` VARCHAR(20) PRIMARY KEY,
`password` VARCHAR(20) NOT NULL CHECK(password REGEXP '^(?=.*[a-z])(?=.*[!@#$%])[a-z0-9!@#$%]{8,12}$'),
`name` VARCHAR(40) NOT NULL,
`email` VARCHAR(100),
`birth` DATE NOT NULL,
`telecom` VARCHAR(4) NOT NULL,
`phone` CHAR(13) NOT NULL UNIQUE CHECK(phone REGEXP '^[0-9]{3}-[0-9]{4}-[0-9]{4}$'),
`gender` CHAR(1) CHECK(gender IN ('M','F')),
`country` VARCHAR(10) NOT NULL CHECK(country IN('local','foreigner')),
`reg_date` DATETIME NOT NULL DEFAULT(NOW()),
`mod_date` DATETIME NOT NULL DEFAULT(NOW())
);

CREATE TABLE cars(
`car_code` CHAR(13) PRIMARY KEY CHECK(car_code REGEXP'^[0-9]{6}-[0-9]{6}$'),
`model` VARCHAR(20) NOT NULL,
`price` INT NOT NULL,
`car_class` VARCHAR(20) NOT NULL,
`car_number` VARCHAR(20) NOT NULL UNIQUE,
`reservation` TINYINT NOT NULL DEFAULT(false),
`fuel` VARCHAR(20) NOT NULL
);

CREATE TABLE boards(
`code` CHAR(13) PRIMARY KEY CHECK(`code` REGEXP '^[0-9]{6}-[0-9]{6}$'),
`title` VARCHAR(40) NOT NULL,
`content` VARCHAR(4000) NOT NULL,
`write_date` DATETIME NOT NULL,
`mod_date` DATETIME NOT NULL,
`user_id` VARCHAR(20) NOT NULL,
`category` VARCHAR(20) NOT NULL CHECK(`category` IN ('Free','Admin')),
FOREIGN KEY(`user_id`) REFERENCES users(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE reservations(
`number` CHAR(13) PRIMARY KEY CHECK(number REGEXP '^[0-9]{6}-[0-9]{6}$'),
`user_id` VARCHAR(20) NOT NULL,
`car_code` CHAR(13) NOT NULL,
`ren_date` DATETIME NOT NULL,
`return_date` DATETIME NOT NULL,
`insurance` VARCHAR(20),
`payment_status` TINYINT NOT NULL DEFAULT(false),
`payment` VARCHAR(10) NOT NULL,
FOREIGN KEY(`user_id`) REFERENCES users(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(`car_code`) REFERENCES cars(`car_code`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE views(
`user_id` VARCHAR(20),
`car_code` VARCHAR(13),
`view_date` DATETIME,
PRIMARY KEY(`user_id`, `car_code`, `view_date`),
FOREIGN KEY(`user_id`) REFERENCES users(`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(`car_code`) REFERENCES cars(`car_code`) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE users MODIFY COLUMN `password` VARCHAR(255) NOT NULL;
ALTER TABLE users MODIFY COLUMN `mod_date` TIMESTAMP NOT NULL DEFAULT(NOW()) ON UPDATE NOW();
ALTER TABLE users MODIFY COLUMN `reg_date` TIMESTAMP NOT NULL DEFAULT(NOW());
ALTER TABLE users DROP CONSTRAINT users_chk_1;
ALTER TABLE boards MODIFY COLUMN `mod_date` TIMESTAMP NOT NULL DEFAULT(NOW()) ON UPDATE NOW();
ALTER TABLE boards MODIFY COLUMN `write_date` TIMESTAMP NOT NULL DEFAULT(NOW());
ALTER TABLE cars ADD COLUMN `location` VARCHAR(100) NOT NULL;
ALTER TABLE cars ADD COLUMN `seater` VARCHAR(30) NOT NULL;

-- INSERT
-- etc