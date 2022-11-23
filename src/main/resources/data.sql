--Residences
INSERT INTO residences (resId, address, name) VALUES (01, '78 Chestnut Road', 'Chestnut');
INSERT INTO residences (resId, address, name) VALUES (02, '27 Kings College Cir', 'University College');
INSERT Into residences (resId, address, name) VALUES (03, '6 Hoskin Avenue', 'Trinity College');
INSERT Into residences (resId, address, name) VALUES (04, '150 Charles St W', 'Victoria College');

--ROOMS

--Chestnut Rooms
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (01, 101, 101, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (01, 102, 102, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (01, 103, 103, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (01, 104, 104, 'double', 2);

--University College Rooms
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (02, 101, 101, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (02, 102, 102, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (02, 103, 103, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (02, 104, 104, 'double', 2);

--Trinity Rooms
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (03, 200, 200, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (03, 201, 201, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (03, 202, 202, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (03, 203, 203, 'double', 2);

--Victoria Rooms
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (04, 300, 300, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (04, 301, 301, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (04, 302, 302, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomN, roomType, capacity) VALUES (04, 303, 303, 'double', 2);

--STUDENTS
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residence, roomN, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1006722520, 'John', 'Angelou', 'M', '20020401', '6476203772', 'password123', 01, 101, 01, 'johnangelou@uoft.ca', '6471111111', 'Mukund Hari', 'Father', 'Safe', '20220901', '20230501');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residence, roomN, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1008982734, 'Jun', 'Kang', 'M', '20001009', '6476202839', 'password456', 01, 101, 01, 'junkang@uoft.ca', '674819283', 'Martha Steward', 'Mother', 'Safe', '19982039', '19982737');

INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residence, roomN, resId, email, role, contractStart, contractEnd) VALUES (11111111, 'David', 'Tong', 'M', '20020408', '7783207533', 'adminPassword', 01, 102, 01, 'dav.tong@mail.utoronto.ca', 'Floor 13 Don', '20200101', '20221220');

--INSERT INTO reports (reportId, date, time, status, lastName, roomNum, id) VALUES (001, '20221010', '040812', 'resolved', 'Tong', 101, 11111111);

