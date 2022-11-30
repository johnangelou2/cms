--residenceIdences
INSERT INTO residenceIdences (resId, address, name) VALUES (1, '78 Chestnut Road', 'Chestnut');
INSERT INTO residenceIdences (resId, address, name) VALUES (2, '27 Kings College Cir', 'University College');
INSERT Into residenceIdences (resId, address, name) VALUES (3, '6 Hoskin Avenue', 'Trinity College');
INSERT Into residenceIdences (resId, address, name) VALUES (4, '111 Bloor St W', 'Victoria College');
INSERT Into residenceIdences (resId, address, name) VALUES (5, '2 Sussex Ave', 'Innis College');
INSERT Into residenceIdences (resId, address, name) VALUES (6, '81 St Mary St', 'St. Michaels College');
INSERT Into residenceIdences (resId, address, name) VALUES (7, '40 Willcocks St', 'New College');

--ROOMS
--Chestnut Rooms
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (1, 101, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (1, 102, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (1, 103, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (1, 104, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (1, 105, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (1, 106, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (1, 107, 'single', 1);

--University College Rooms
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (2, 101, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (2, 102, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (2, 103, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (2, 104, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (2, 105, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (2, 106, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (2, 107, 'double', 2);

--Trinity Rooms
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (3, 200, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (3, 201, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (3, 202, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (3, 203, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (3, 204, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (3, 205, 'single', 1);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (3, 206, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (3, 207, 'double', 2);

--Victoria Rooms
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 300, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 301, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 302, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 303, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 304, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 305, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 306, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 307, 'double', 2);
INSERT INTO rooms (resId, roomNumber, roomType, capacity) VALUES (4, 308, 'double', 2);

--STUDENTS
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1006722520, 'John', 'Angelou', 'M', '2002-04-01', '6476203772', 'password123', 1, 101, 1, 'johnangelou@uoft.ca', '6471111111', 'Mukund Hari', 'Father', 'Safe', '2022-09-01', '2023-05-01');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1008982734, 'Jun', 'Kang', 'M', '2000-10-09', '6476202839', 'password456', 1, 101, 1, 'junkang@uoft.ca', '674819283', 'Martha Steward', 'Mother', 'Safe', '2022-09-01', '2023-05-01');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1029394857, 'Minseok', 'Song', 'M', '2002-05-27', '9056843948', 'password123', 1, 101, 1, 'minseok.song@uoft.ca', '9023748576', 'Minjae Song', 'Brother', 'Safe', '2022-09-01', '2023-05-01');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002938475, 'Luke', 'Skywalker', 'M', '1998-03-23', '9074839283', 'password111', 1, 101, 1, 'skywalker@uoft.ca', '6471111111', 'Darth Vader', 'Father', 'Safe', '2022-09-01', '2023-05-01');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002938456, 'Emma', 'Watson', 'F', '1999-04-23', '2893284233', 'password', 1, 101, 1, 'emmawatson@uoft.ca', '2891827364', 'Jeremie Collette', 'Father', 'Safe', '2022-09-01', '2023-05-01');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002384928, 'Artoo', 'Detoo', 'F', '2000-05-27', '1894785746', 'password192', 1, 101, 1, 'artoodetoo@uoft.ca', '2891928174', 'Jeremy Zucker', 'Father', 'Safe', '2022-09-01', '2023-05-01');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002983928, 'Karina', 'Aespa', 'F', '2000-03-27', '2893284233', 'password1029', 1, 101, 1, 'karinaaespa@uoft.ca', '2891827364', 'Jeremie Collette', 'Father', 'Safe', '2022-09-01', '2023-05-01');
INSERT INTO students (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, emgPhoneNum, emgFullName, emgRelationship, probationStatus, stayStart, stayEnd) VALUES (1002837827, 'Keshi', 'Belmont', 'M', '2000-03-27', '9074839283', 'password111', 1, 101, 1, 'skywalker@uoft.ca', '6471111111', 'Darth Vader', 'Father', 'Safe', '2022-09-01', '2023-05-01');

--ADMINS
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, role, contractStart, contractEnd) VALUES (11111111, 'David', 'Tong', 'M', '2002-04-08', '7783207533', 'adminPassword1', 1, 102, 1, 'dav.tong@mail.utoronto.ca', 'Floor 13 Don', '2020-01-01', '2022-12-20');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, role, contractStart, contractEnd) VALUES (22222222, 'Cole', 'Stotland', 'M', '2002-03-28', '777283712', 'adminPassword2', 1, 102, 1, 'cole.stotland@mail.utoronto.ca', 'Floor 14 Don', '2020-01-01', '2022-12-20');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, role, contractStart, contractEnd) VALUES (33333333, 'Oak', 'Brock', 'M', '2000-01-29', '12398192383', 'adminPassword3', 1, 102, 1, 'Oak.brock@mail.utoronto.ca', 'Floor 15 Don', '2020-01-01', '2022-12-20');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, role, contractStart, contractEnd) VALUES (44444444, 'Charlie', 'Flethcin', 'M', '2002-01-12', '1239821739', 'adminPassword4', 1, 102, 1, 'charlie@mail.utoronto.ca', 'Floor 16 Don', '2020-01-01', '2022-12-20');
INSERT INTO admins (id, firstName, lastName, gender, dateOfBirth, phoneNum, password, residenceIdence, roomNumber, resId, email, role, contractStart, contractEnd) VALUES (55555555, 'Mary', 'Brown', 'F', '1998-03-14', '12798371289', 'adminPassword5', 1, 102, 1, 'Mary.brown@mail.utoronto.ca', 'Floor 17 Don', '2020-01-01', '2022-12-20');

--REPORTS
INSERT INTO reports (reportId, date, time, description, type, status, resId, roomNumber,  id) VALUES (001, '2022-09-10', '040812', 'A student got in a fight', 'Violent', 'resolved', 3, 201, 11111111);
INSERT INTO reports (reportId, date, time, description, type, status, resId, roomNumber,  id) VALUES (002, '2022-12-07', '050812', 'Underage Drinking', 'Nonviolent', 'resolved', 3, 202, 22222222);
INSERT INTO reports (reportId, date, time, description, type, status, resId, roomNumber,  id) VALUES (003, '2022-10-10', '060812', 'Noise complaint', 'Nonviolent', 'resolved', 3, 203, 33333333);
INSERT INTO reports (reportId, date, time, description, type, status, resId, roomNumber,  id) VALUES (004, '2022-12-08', '080812', 'Room capacity violation', 'Nonviolent', 'resolved', 3, 204, 44444444);
INSERT INTO reports (reportId, date, time, description, type, status, resId, roomNumber,  id) VALUES (005, '2022-10-10', '070812', 'Illegal drugs', 'Nonviolent', 'in progress', 3, 205, 55555555);



