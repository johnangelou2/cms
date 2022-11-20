INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1006722520, 'John', 'Angelou', 'M', '20020401', '6476203772', 'johnangelou@uoft.ca', '6471111111', 'Mukund Hari', 'Father', 'Safe', '20220901', '20230501');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1008982734, 'Jun', 'Kang', 'M', '20001009', '6476202839', 'junkang@uoft.ca', '674819283', 'Martha Steward', 'Mother', 'Safe', '19982039', '19982737');

INSERT INTO residences (id, address, name) VALUES (01, '78 Chestnut Road', 'Chestnut');
INSERT INTO residences (id, address, name) VALUES (02, '27 Kings College Cir', 'University College');

INSERT INTO rooms (id, roomNum, roomType, capacity) VALUES (01, 101, 'single', 1);
INSERT INTO rooms (id, roomNum, roomType, capacity) VALUES (01, 102, 'single', 1);
INSERT INTO rooms (id, roomNum, roomType, capacity) VALUES (01, 103, 'double', 2);
INSERT INTO rooms (id, roomNum, roomType, capacity) VALUES (01, 104, 'double', 2);

INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, email, role, privilegeLevel, contractStart, contractEnd) VALUES(11111111, 'David', 'Tong', 'M', '20020408', '2509840533', 'dav.tong@mail.utoronto.ca', 'Manager', '4', '20200101', '20221220');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, email, role, privilegeLevel, contractStart, contractEnd) VALUES(55555555, 'John', 'Angie', 'F', '19990201', '6471111122', 'admin@mail.utoronto.ca', 'Floor 14 Don', '4', '20220901', '20230530');

