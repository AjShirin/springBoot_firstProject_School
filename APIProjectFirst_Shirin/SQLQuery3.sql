use API_Practice_Springboot;

Select * From school;
Select * From student;
Select * From course;
Select * From mark;
SELECT DISTINCT(id) FROM student
Select * From course_marks;
Select * From school_students;
Select * From student_courses;

SELECT school_id FROM student

UPDATE student
SET is_active = 'True'
WHERE student_name = 'Asma';

DELETE FROM student WHERE student_name = 'Safaa';

INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2020-05-09 09:30:21.1200000','2021-05-05 10:30:21.1000000','True','abm');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2020-05-09','2019-05-05 ','True','santop');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2023-05-09','2020-05-05','False','kitkat');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2019-05-09','2010-05-05','True','chips');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2009-06-08','2010-03-05','True','Tomato');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2009-06-08','2016-09-08','True','Banana');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2009-06-08','2007-09-08','True','cacke');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2009-05-05','2007-07-07','True','Twix');

INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-05-09','2020-05-05','True','Shirin',9,1);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-01-01','2020-01-01','True','Ruqia',5,3);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-07-05','2020-04-04','True','Marwa',3,3);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-07-05','2020-04-04','True','Fatma',6,3);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-07-05','2020-04-04','False','Farah',2,2);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-07-05','2020-04-04','True','Manal',10,4);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2020-02-05','2021-05-05','True','Esraa',11,1);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2016-02-10','2019-03-04','True','Khulood',4,1);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2016-02-10','2019-03-04','True','Asma',7,10);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2006-02-10','2007-03-04','True','Maryam',8,10);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2006-02-10','2007-03-04','True','Nasser',10,10);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2006-02-10','2007-03-04','True','Noor',12,10);

INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04 09:30:21.1200000','2020-05-05','True','Python',11);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04','2020-05-05','True','HTML',13);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04','2020-05-05','True','CSS',12);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04 07:45:19.1500000','2020-01-01 10:30:21.9000000','False','Java',15);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04 07:45:19.1500000','2020-01-01 10:30:21.9000000','True','PE',15);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2017-05-04 07:45:19.1500000','2016-01-01 10:30:21.9000000','True','Math',15);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2017-05-04 07:45:19.1500000','2016-01-01 10:30:21.9000000','True','Math',29);

INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-05-04','2020-05-05','True','A',85,13);
INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-05-04','2020-05-05','True','D',65,12);
INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-05-04','2020-05-05','False','B',73,14);
INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-05-04','2020-05-05','False','c',79,15);
