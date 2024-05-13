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
ALTER TABLE reservations MODIFY COLUMN `ren_date` TIMESTAMP NOT NULL;
ALTER TABLE reservations MODIFY COLUMN `return_date` TIMESTAMP NOT NULL;

-- INSERT

INSERT INTO cars(car_code, model, price, car_class, car_number, reservation, fuel, location, seater)
VALUES('111111-111111', '모닝', 59500, '경형', '111하1111', false, '휘발유', '서울', '2인승'),
('123456-789012', '쏘나타', 122280, '중형', '132허2389', false, '휘발유', '경기', '5인승'),
('915654-321008', '그랜저', 80940, '대형', '245호8901', false, '경유', '부산', '5인승'),
('456789-012345', '투싼', 135700, 'SUV', '378하5678', false, 'LPG', '제주', '5인승'),
('193456-789512', '쏘렌토', 120400, '중형', '132하2389', false, '휘발유', '서울', '5인승'),
('917654-321098', '티볼리', 82800, '소형', '245하8901', false, '경유', '경기', '4인승'),
('264589-012345', '스팅어', 139200, '중형', '368하5678', false, 'LPG', '부산', '2인승'),
('654321-091965', '제네시스 G70', 60470, '중형', '142호9800', false, '전기', '제주', '4인승'),
('789012-324678', '포터', 112750, '중형', '531하1524', false, '하이브리드', '서울', '3인승'),
('321098-765432', '카니발', 144450, '승합', '932허7007', false, '휘발유', '경기', '5인승'),
('901234-511890', '팰리세이드', 70560, '대형', '623호4777', false, '경유', '부산', '5인승'),
('119876-543210', '레이', 907540, '소형', '456하3133', false, '전기', '제주', '2인승'),
('183567-890123', '아반떼', 135500, '준중형', '723허7890', false, '하이브리드', '서울', '4인승'),
('345678-904324', 'K5', 75050, '준중형', '954하5678', false, '휘발유', '부산', '3인승'),
('538530-124356', '그랜저 IG', 144570, '대형', '839호9876', false, 'LPG', '제주', '5인승'),
('678901-234567', '렉스턴', 80500, 'SUV', '930호9685', false, '전기', '서울', '3인승'),
('789012-342368', '그랜드 스타렉스', 145700, '승합', '395하1211', false, '하이브리드', '경기', '5인승'),
('890123-411789', '카니발', 110450, '승합', '743하8115', false, '경유', '부산', '4인승'),
('911234-567890', '모하비', 125440, 'SUV', '871허1133', false, '휘발유', '제주', '5인승'),
('109876-543220', '쏘나타', 130460, '중형', '521호6166', false, '하이브리드', '서울', '5인승'),
('210987-654321', '투싼', 54500, 'SUV', '439허2345', false, '경유', '부산', '2인승'),
('321088-765432', '스팅어', 14460, '중형', '639호9876', false, '전기', '제주', '4인승'),
('489109-876543', 'K3', 75500, '소형', '841허4444', false, 'LPG', '서울', '3인승'),
('543210-680234', '셀토스', 114500, '소형', '623하5678', false, '하이브리드', '부산', '3인승'),
('611121-098765', '소울', 1207900, '소형', '953허7890', false, '휘발유', '제주', '4인승'),
('715432-109876', '스팅어', 139000, '중형', '534하1234', false, '전기', '서울', '4인승'),
('811543-210987', 'K7', 79400, '중형', '212호2345', false, '경유', '부산', '3인승'),
('999654-321098', '아반떼', 142000, '준중형', '422하8165', false, 'LPG', '제주', '5인승'),
('265437-890123', '레이', 99300, '경형', '549허3333', false, '휘발유', '서울', '2인승'),
('365478-901234', 'K9', 142800, '대형', '346호6666', false, '하이브리드', '부산', '5인승'),
('517890-643256', '쏘나타', 73800, '중형', '927하7890', false, '전기', '서울', '3인승'),
('412109-876543', '쏘나타', 144800, '중형', '934호9999', false, '휘발유', '제주', '4인승'),
('541210-987654', '그랜저', 80270, '대형', '456호1234', false, '하이브리드', '경기', '5인승'),
('113116-689012', '쏘나타', 164900, '중형', '152허2189', false, '휘발유', '부산', '4인승'),
('911154-321098', '그랜저', 25260, '대형', '275호8901', false, '경유', '서울', '5인승'),
('411789-024525', '투싼', 147200, 'SUV', '378하5268', false, 'LPG', '부산', '3인승'),
('654421-098765', '아반떼', 83600, '준중형', '142호9090', false, '전기', '제주', '2인승'),
('789012-392678', '쏘나타', 1838500, '중형', '531하1234', false, '하이브리드', '서울', '5인승'),
('311098-765432', '그랜저', 326300, '대형', '932허7717', false, '휘발유', '부산', '4인승'),
('901224-567890', '투싼', 133400, 'SUV', '623호4567', false, '경유', '경기', '2인승'),
('103876-543210', '아반떼', 74800, '준중형', '456하3333', false, '전기', '서울', '3인승'),
('211561-890123', '쏘나타', 190220, '중형', '723허3690', false, '하이브리드', '제주', '5인승'),
('345678-901234', '그랜저', 224700, '준중형', '194하5678', false, '휘발유', '부산', '4인승'),
('567530-121356', '투싼', 145700, 'SUV', '839허9811', false, 'LPG', '서울', '2인승'),
('678901-298467', '쏘나타', 207300, '중형', '930호2345', false, '전기', '제주', '3인승'),
('789012-315678', '그랜저', 283700, '대형', '385하1111', false, '하이브리드', '부산', '5인승'),
('890123-456789', '투싼', 153280, 'SUV', '743하8765', false, '경유', '서울', '4인승'),
('901232-567890', '아반떼', 85000, '준중형', '871허3333', false, '휘발유', '경기', '2인승'),
('109846-543210', '쏘나타', 170200, '중형', '522호6666', false, '하이브리드', '서울', '3인승'),
('452589-015545', '아반떼', 77400, '준중형', '178허1131', false, '경유', '부산', '5인승'),
('123256-789012', 'BMW', 157400, '수입', '132호2389', false, '휘발유', '서울', '4인승'),
('987654-321098', 'Mercedes-Benz', 140000, '수입', '249호8901', false, '경유', '경기', '5인승'),
('452352-048685', 'Audi A4', 145000, '수입', '378하5928', false, 'LPG', '부산', '3인승'),
('111321-098765', 'Lexus ES', 162600, '수입', '142호9900', false, '전기', '서울', '2인승'),
('789012-342278', 'Jaguar XE', 155000, '수입', '531하1244', false, '하이브리드', '부산', '4인승'),
('321098-765532', 'Volvo S60', 147250, '수입', '932허7771', false, '휘발유', '서울', '3인승'),
('901234-567260', 'Acura TLX', 143170, '수입', '673호4567', false, '경유', '제주', '5인승'),
('109276-543210', 'Infiniti Q50', 148570, '수입', '456하3113', false, '전기', '부산', '2인승'),
('211227-890123', 'Cadillac CT5', 152900, '수입', '723허1890', false, '하이브리드', '서울', '4인승'),
('345988-901234', 'Lincoln MKZ', 149000, '수입', '124하5678', false, '휘발유', '경기', '3인승');

-- etc