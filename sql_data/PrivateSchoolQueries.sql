use PrivateSchool;

-- Populate Course table:

INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES ('cb7', 'Java', 'full-time', '2011-11-11', '2012-01-11');
INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES ('cb8', 'C#', 'full-time', '2011-11-11', '2012-01-11');
INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES ('cb9', 'Java', 'part-time', '2011-11-11', '2012-03-11');
INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES ('cb10', 'C#', 'part-time', '2011-11-11', '2012-03-11');
INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES ('cb11', 'Java', 'full-time', '2011-11-11', '2012-01-11');
INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES ('cb12', 'C#', 'full-time', '2011-11-11', '2012-01-11');
INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES ('cb13', 'Java', 'part-time', '2011-11-11', '2012-03-11');
INSERT INTO `PrivateSchool`.`Course` (courseTitle, stream, typeOfParticipation, startDate, endDate) VALUES ('cb14', 'C#', 'part-time', '2011-11-11', '2012-03-11');


-- Populate Student table:

INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('John', 'Doe', '2011-11-11', 100);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Ann', 'Own', '2007-07-07', 50);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Pikos', 'Apikos', '1979-11-11', 100);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Emilios', 'Tomilo', '1980-11-11', 100);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Maria', 'Pentagiotissa', '1936-12-12', 50);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Alpen', 'Kraft', '1945-11-11', 100);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Emily', 'Plays', '1960-08-08', 50);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Clarise', 'Lispektor', '1930-11-11', 50);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Frantz', 'Kafka', '1892-11-11', 100);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Heinrich', 'Böll', '1910-01-14', 100);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Robero', 'Bolano', '1950-05-04', 100);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Michel', 'Foucault', '1947-03-03', 100);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Angela', 'Dimitrakaki', '1979-02-01', 50);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Virginia', 'Woolf', '1910-04-06', 50);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Sylvia', 'Plath', '1932-11-27', 50);
INSERT INTO `PrivateSchool`.`Student` (fname, lname, dob, fees) VALUES ('Maria', 'Polydouri', '1902-04-01', 50);

-- Populate Trainer table:

INSERT INTO `PrivateSchool`.`Trainer` (fname, lname, subjOfTrainer) VALUES ('Han', 'Kang', 'MySQL');
INSERT INTO `PrivateSchool`.`Trainer` (fname, lname, subjOfTrainer) VALUES ('Tani', 'Zaki', 'Java');
INSERT INTO `PrivateSchool`.`Trainer` (fname, lname, subjOfTrainer) VALUES ('Hermann', 'Hesse', 'C#');
INSERT INTO `PrivateSchool`.`Trainer` (fname, lname, subjOfTrainer) VALUES ('Paul', 'Celan', 'Javascript');
INSERT INTO `PrivateSchool`.`Trainer` (fname, lname, subjOfTrainer) VALUES ('JG', 'Ballard', 'DevOps');

-- Populate HeadMaster table:

INSERT INTO `PrivateSchool`.`HeadMaster` (fname, lname) VALUES ("Marcel", "Proust");


-- Populate Assignment table:

INSERT INTO `PrivateSchool`.`Assignment` (assignTitle, descr, submissionDateTime, minOralMark, minTotalMark) VALUES ('assignment1', 'OOP design & implementation', '2019-11-03 12:00:00', 45, 65);
INSERT INTO `PrivateSchool`.`Assignment` (assignTitle, descr, submissionDateTime, minOralMark, minTotalMark) VALUES ('assignment2', 'Databases', '2019-11-03 12:00:00', 55, 55);
INSERT INTO `PrivateSchool`.`Assignment` (assignTitle, descr, submissionDateTime, minOralMark, minTotalMark) VALUES ('assignment3', 'Individual Project', '2019-11-03 12:00:00', 45, 65);
INSERT INTO `PrivateSchool`.`Assignment` (assignTitle, descr, submissionDateTime, minOralMark, minTotalMark) VALUES ('assignment4', 'Team Project', '2019-11-03 12:00:00', 45, 65);

-- Populate CourseAssignments table:

INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (1, 1);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (1, 2);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (1, 3);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (1, 4);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (2, 1);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (2, 2);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (2, 3);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (2, 4);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (3, 1);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (3, 2);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (3, 3);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (3, 4);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (4, 1);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (4, 2);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (4, 3);
INSERT INTO `PrivateSchool`.`CourseAssignments` (fk_as_id, fk_co_id) VALUES (4, 4);

-- Populate CourseTrainers table:

INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (1, 1);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (1, 2);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (1, 3);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (1, 4);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (2, 1);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (2, 3);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (3, 2);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (3, 4);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (4, 1);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (4, 2);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (5, 3);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (5, 4);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (1, 5);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (1, 6);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (1, 7);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (1, 8);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (2, 5);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (2, 7);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (3, 6);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (3, 8);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (4, 5);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (4, 6);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (5, 7);
INSERT INTO `PrivateSchool`.`CourseTrainers` (fk_tr_id, fk_co_id) VALUES (5, 8);

-- Populate CourseStudents table:

INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (1, 1);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (1, 4);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (2, 3);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (2, 5);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (3, 6);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (4, 7);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (5, 8);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (5, 2);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (5, 4);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (6, 6);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (7, 3);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (8, 5);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (9, 1);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (10, 3);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (10, 4);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (10, 5);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (11, 6);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (11, 1);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (11, 3);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (12, 1);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (13, 2);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (14, 3);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (15, 6);
INSERT INTO `PrivateSchool`.`CourseStudents` (fk_st_id, fk_co_id) VALUES (16, 7);

-- Populate StudentsAssignmentsCourse table:

INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (1, 1, 45, 55, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (1, 5, 56, 67, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (1, 9, 45, 68, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (1, 13, 33, 56, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (2, 4, 55, 78, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (2, 8, 78, 66, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (2, 12, 23, 32, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (2, 16, 88, 99, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (3, 3, 55, 65, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (3, 7, 56, 78, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (3, 11, 67, 67, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (3, 15, 54, 56, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (8, 2, 34, 32, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (8, 6, 67, 69, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (8, 10, 78, 79, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (8, 14, 67, 76, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (10, 4, 77, 77, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (10, 8, 87, 87, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (10, 12, 88, 99, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (10, 16, 45, 45, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (12, 3, 33, 33, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (12, 7, 66, 77, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (12, 11, 75, 75, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (12, 15, 56, 56, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (14, 1, 57, 75, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (14, 5, 57, 56, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (14, 9, 34, 34, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (14, 13, 32, 32, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (15, 3, 55, 55, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (15, 7, 77, 77, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (15, 11, 88, 99, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (15, 15, 66, 77, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (16, 4, 44, 55, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (16, 8, 34, 55, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (16, 12, 77, 88, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (16, 16, 89, 99, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (19, 1, 66, 66, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (19, 5, 44, 44, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (19, 9, 33, 55, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (19, 13, 78, 79, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (20, 3, 67, 67, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (20, 7, 56, 67, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (20, 11, 45, 56, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (20, 15, 54, 67, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (21, 1, 32, 31, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (21, 5, 45, 45, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (21, 9, 66, 77, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (21, 13, 77, 88, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (22, 4, 34, 45, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (22, 8, 33, 44, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (22, 12, 45, 67, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (22, 16, 76, 87, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (23, 3, 67, 69, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (23, 7, 34, 56, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (23, 11, 32, 32, 0);
INSERT INTO `PrivateSchool`.`StudentsAssignmentsCourse` (fk_cs_id, fk_ca_id, studentOralMark, studentTotalMark, assignmentSubmitted) VALUES (23, 15, 22, 22, 0);

-- Populate UserStudent table:

INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("DoJo", "a5303217e3686a912eaf54855b671341", 1);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("OwAn", "3c146743b9f73f5b54cbc561c93659e0", 2);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("ApiPik", "2c0b43b9b026cac401962eabad7b2590", 3);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("TomEmi", "05fa5f028e524aa892f0c4d922641caa", 4);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("PenMar", "c1019f29a2414cfc06a1b74d6b74febd", 5);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("KraAlp", "69d84343f8fb3d9e3d2c7f871722ff82", 6);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("PlaEmi", "debff15ba020668648519cd3c5adcf17", 7);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("LisCla", "0bf69d8fd58001e3e83021ddf33f58ee", 8);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("KafFra", "6bd13b30565dce30e9231df50c0998ca", 9);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("BoelHe", "fbd01df4d615799832823b05c5da39be", 10);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("BolRob", "5b2228b22d4f3cd1b67def477fb4ec44", 11);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("FouMic", "3de4a67d44c2f60a9b6a7628a20a0677", 12);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("DimAng", "9c886a705ddb6254bbd16b489cad6b05", 13);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("WooVir", "7302f185efbc65e240ed190e88ec2308", 14);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("PlaSyl", "d26580d5ff05f87a40280525b80ee186", 15);
INSERT INTO `PrivateSchool`.`UserStudent` (userName, passHashed, fk_st_id) VALUES ("PolMar", "c8e14533b67901072adf79203d4b88cb", 16);

-- Populate UserTrainer table:

INSERT INTO `PrivateSchool`.`UserTrainer` (userName, passHashed, fk_tr_id) VALUES ("KanHan", "55a5ba443a622fd3f068c7318e8236fa", 1);
INSERT INTO `PrivateSchool`.`UserTrainer` (userName, passHashed, fk_tr_id) VALUES ("ZakTan", "c250a54726750a90fa5b68141dbfbfc2", 2);
INSERT INTO `PrivateSchool`.`UserTrainer` (userName, passHashed, fk_tr_id) VALUES ("HesHer", "741e0d498edb45763537aac822fe2093", 3);
INSERT INTO `PrivateSchool`.`UserTrainer` (userName, passHashed, fk_tr_id) VALUES ("CelPau", "57187fc1e5c10abffb7347d7d4d2c7a6", 4);
INSERT INTO `PrivateSchool`.`UserTrainer` (userName, passHashed, fk_tr_id) VALUES ("BalJG", "b1ad1ae542dd380a8b41e689b0d5faa6", 5);

-- Populate UserHeadMaster table:

INSERT INTO `PrivateSchool`.`UserHeadMaster` (userName, passHashed, fk_hm_id) VALUES ("ProMar", "e22ede0c1886a00889dff582e55d8085", 1);

-- Populate Day table:

INSERT INTO `PrivateSchool`.`Day` (SchoolDay) VALUES ("Monday");
INSERT INTO `PrivateSchool`.`Day` (SchoolDay) VALUES ("Tuesday");
INSERT INTO `PrivateSchool`.`Day` (SchoolDay) VALUES ("Wednesday");
INSERT INTO `PrivateSchool`.`Day` (SchoolDay) VALUES ("Thursday");
INSERT INTO `PrivateSchool`.`Day` (SchoolDay) VALUES ("Friday");

-- Populate CourseDays table:

INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (1, 1);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (1, 2);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (1, 3);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (1, 4);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (2, 5);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (2, 6);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (2, 7);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (2, 8);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (3, 1);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (3, 3);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (3, 5);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (3, 7);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (4, 2);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (4, 4);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (4, 6);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (4, 8);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (5, 1);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (5, 8);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (5, 2);
INSERT INTO `PrivateSchool`.`CourseDays` (fk_d_id, fk_co_id) VALUES (5, 7);

-- See all Students, Courses, Trainers, Assignments, Users:

SELECT * FROM Student;
SELECT * FROM Course;
SELECT * FROM Trainer;
SELECT * FROM Assignment;
SELECT * FROM HeadMaster;
SELECT * FROM UserStudent;
SELECT * FROM UserHeadMaster;
SELECT * FROM UserTrainer;


-- See Assignments Per Course:

SELECT caId, assignTitle, descr, courseTitle FROM Assignment AS A
INNER JOIN CourseAssignments AS CA ON CA.fk_as_id = asId
INNER JOIN Course AS C ON coId = CA.fk_co_id;

-- See Trainers Per Course:

SELECT ctId, trId, fname, lname, courseTitle FROM Trainer AS T
INNER JOIN CourseTrainers AS CT ON CT.fk_tr_id = trId
INNER JOIN Course AS C ON coId = CT.fk_co_id;

-- See Students Per Course:

SELECT csId, stId, fname, lname, courseTitle FROM Student AS S
INNER JOIN CourseStudents AS CS ON CS.fk_st_id = stId
INNER JOIN Course AS C ON coId = CS.fk_co_id;

-- See Students who attend more than one courses:

SELECT fname, lname, stId, COUNT(*) AS subjectsAttending
FROM CourseStudents AS CS, Student AS S, Course AS C
WHERE CS.fk_st_id = stId
AND CS.fk_co_id = coId
GROUP BY stId
HAVING COUNT(*) > 1;

-- Assignments Per Student Per Course:

SELECT sacId, stId, fname, lname, coId, courseTitle, assignTitle, studentOralMark, studentTotalMark, assignmentSubmitted
FROM CourseStudents AS CS
INNER JOIN StudentsAssignmentsCourse AS SAC ON SAC.fk_cs_id = csId
INNER JOIN CourseAssignments AS CA ON caId = SAC.fk_ca_id
INNER JOIN Student AS S ON stId = CS.fk_st_id
INNER JOIN Course AS C ON coId = CS.fk_co_id
INNER JOIN Assignment AS A ON asId = CA.fk_as_id;

-- See Daily Schedule:

SELECT SchoolDay, courseTitle, stId, fname, lname
FROM Day AS D
INNER JOIN CourseDays CD ON dId = CD.fk_d_id
INNER JOIN Course AS C ON coId = CD.fk_co_id
INNER JOIN CourseStudents CS ON coId = CS.fk_co_id
INNER JOIN Student AS S ON stId = CS.fk_st_id;

SELECT SchoolDay, courseTitle
FROM Day AS D
INNER JOIN CourseDays CD ON dId = CD.fk_d_id
INNER JOIN Course AS C ON coId = CD.fk_co_id
ORDER BY dId;
/* Used with kind permission by Panteleimon Rovatsos.
This code produces the same results. It also requires less coding.
I can't say I clearly understand the difference between these two implementations.
The one I used seemed somehow more reasonable.

SELECT courseTitle , courseTitle, fname, lname
FROM Assignment AS A
INNER JOIN CourseAssignments CA ON A.id = CA.fk_as_id
INNER JOIN Course AS C ON C.id = CA.fk_co_id
INNER JOIN CourseStudents CS ON C.id = CS.fk_co_id
INNER JOIN Student AS S ON S.id = CS.fk_st_id;

*/
-- SELECT * FROM CourseStudents;
-- SELECT * FROM CourseAssignments;
-- SELECT * FROM CourseTrainers;
-- SELECT * FROM StudentsAssignmentsCourse;
