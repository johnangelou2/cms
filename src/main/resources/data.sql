--residenceIdences
INSERT INTO residenceIdences (residenceId, address, name) VALUES (01, '78 Chestnut Road', 'Chestnut');
INSERT INTO residenceIdences (residenceId, address, name) VALUES (02, '27 Kings College Cir', 'University College');
INSERT Into residenceIdences (residenceId, address, name) VALUES (03, '6 Hoskin Avenue', 'Trinity College');
INSERT Into residenceIdences (residenceId, address, name) VALUES (04, '111 Bloor St W', 'Victoria College');
INSERT Into residenceIdences (residenceId, address, name) VALUES (05, '2 Sussex Ave', 'Innis College');
INSERT Into residenceIdences (residenceId, address, name) VALUES (06, '81 St Mary St', 'St. Michaels College');
INSERT Into residenceIdences (residenceId, address, name) VALUES (07, '40 Willcocks St', 'New College');

--ROOMS
--Chestnut Rooms
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (1, 101, 101, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (1, 102, 102, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (1, 103, 103, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (1, 104, 104, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (1, 105, 105, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (1, 106, 106, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (1, 107, 107, 'single', 1);

--University College Rooms
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (2, 101, 101, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (2, 102, 102, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (2, 103, 103, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (2, 104, 104, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (2, 105, 105, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (2, 106, 106, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (2, 107, 107, 'double', 2);

--Trinity Rooms
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (3, 200, 200, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (3, 201, 201, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (3, 202, 202, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (3, 203, 203, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (3, 204, 204, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (3, 205, 205, 'single', 1);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (3, 206, 206, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (3, 207, 207, 'double', 2);

--Victoria Rooms
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 300, 300, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 301, 301, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 302, 302, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 303, 303, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 304, 304, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 305, 305, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 306, 306, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 307, 307, 'double', 2);
INSERT INTO rooms (residenceId, roomN, roomType, capacity) VALUES (4, 308, 308, 'double', 2);

--STUDENTS
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1006722520, 'John', 'Angelou', 'M', '20020401', '6476203772', 'password123', 01, 101, 01, 'johnangelou@uoft.ca', '6471111111', 'Mukund Hari', 'Father', 'Safe', '20220901', '20230501');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1008982734, 'Jun', 'Kang', 'M', '20001009', '6476202839', 'password456', 01, 101, 01, 'junkang@uoft.ca', '674819283', 'Martha Steward', 'Mother', 'Safe', '19982039', '19982737');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1029394857, 'Minseok', 'Song', 'M', '20020527', '9056843948', 'password123', 01, 101, 01, 'minseok.song@uoft.ca', '9023748576', 'Minjae Song', 'Brother', 'Safe', '20220901', '20230501');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002938475, 'Luke', 'Skywalker', 'M', '19980323', '9074839283', 'password111', 01, 101, 01, 'skywalker@uoft.ca', '6471111111', 'Darth Vader', 'Father', 'Safe', '20220901', '20230501');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002938456, 'Emma', 'Watson', 'F', '19990423', '2893284233', 'password', 01, 101, 01, 'emmawatson@uoft.ca', '2891827364', 'Jeremie Collette', 'Father', 'Safe', '20220901', '20230501');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002384928, 'Artoo', 'Detoo', 'F', '20000527', '1894785746', 'password192', 01, 101, 01, 'artoodetoo@uoft.ca', '2891928174', 'Jeremy Zucker', 'Father', 'Safe', '20220901', '20230501');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002983928, 'Karina', 'Aespa', 'F', '20000327', '2893284233', 'password1029', 01, 101, 01, 'karinaaespa@uoft.ca', '2891827364', 'Jeremie Collette', 'Father', 'Safe', '20220901', '20230501');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002837827, 'Keshi', 'Belmont', 'M', '20000327', '9074839283', 'password111', 01, 101, 01, 'skywalker@uoft.ca', '6471111111', 'Darth Vader', 'Father', 'Safe', '20220901', '20230501');

--ADMINS
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, role, contractStart, contractEnd) VALUES (11111111, 'David', 'Tong', 'M', '20020408', '7783207533', 'adminPassword1', 01, 102, 01, 'dav.tong@mail.utoronto.ca', 'Floor 13 Don', '20200101', '20221220');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, role, contractStart, contractEnd) VALUES (22222222, 'Cole', 'Stotland', 'M', '20020328', '777283712', 'adminPassword2', 01, 102, 01, 'cole.stotland@mail.utoronto.ca', 'Floor 14 Don', '20200101', '20221220');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, role, contractStart, contractEnd) VALUES (33333333, 'Oak', 'Brock', 'M', '20000129', '12398192383', 'adminPassword3', 01, 102, 01, 'Oak.brock@mail.utoronto.ca', 'Floor 15 Don', '20200101', '20221220');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, role, contractStart, contractEnd) VALUES (44444444, 'Charlie', 'Flethcin', 'M', '20020112', '1239821739', 'adminPassword4', 01, 102, 01, 'charlie@mail.utoronto.ca', 'Floor 16 Don', '20200101', '20221220');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomN, residenceId, email, role, contractStart, contractEnd) VALUES (55555555, 'Mary', 'Brown', 'F', '19980314', '12798371289', 'adminPassword5', 01, 102, 01, 'Mary.brown@mail.utoronto.ca', 'Floor 17 Don', '20200101', '20221220');

--REPORTS
INSERT INTO reports (reportId, date, time, status, residenceIdence, roomN,  id) VALUES (001, '20221010', '040812', 'resolved', 3, 201, 11111111);
INSERT INTO reports (reportId, date, time, status, residenceIdence, roomN,  id) VALUES (002, '20221207', '050812', 'resolved', 3, 202, 22222222);
INSERT INTO reports (reportId, date, time, status, residenceIdence, roomN,  id) VALUES (003, '20221010', '060812', 'resolved', 3, 203, 33333333);
INSERT INTO reports (reportId, date, time, status, residenceIdence, roomN,  id) VALUES (004, '20221208', '080812', 'resolved', 3, 204, 44444444);
INSERT INTO reports (reportId, date, time, status, residenceIdence, roomN,  id) VALUES (005, '20221010', '070812', 'resolved', 3, 205, 55555555);


