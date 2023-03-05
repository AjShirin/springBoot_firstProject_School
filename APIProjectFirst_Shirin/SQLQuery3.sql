use API_Practice_Springboot;

Select * From school;
Select * From student;
Select * From course;
Select * From mark;

Select * From course_marks;
Select * From school_students;
Select * From student_courses;

INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2023-05-09','2021-05-05','True','abm');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2020-05-09','2019-05-05','True','santop');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2023-05-09','2020-05-05','False','abq');
INSERT INTO school (updated_date,created_date,is_active,school_name) VALUES ('2019-05-09','2010-05-05','True','chips');

INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-05-09','2020-05-05','True','Shirin',9,7);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-01-01','2020-01-01','True','Ruqia',5,7);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-07-05','2020-04-04','True','Marwa',3,7);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-07-05','2020-04-04','False','Farah',2,5);
INSERT INTO student (updated_date,created_date,is_active,student_name, roll_number,school_id) VALUES ('2023-07-05','2020-04-04','True','Manal',10,6);

INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04','2020-05-05','True','Python',5);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04','2020-05-05','True','Python',2);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04','2020-05-05','True','Python',1);
INSERT INTO course (updated_date,created_date,is_active,course_name,student_id) VALUES ('2023-05-04','2020-01-01','False','Java',4);

INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-05-04','2020-05-05','True','A',85,3);
INSERT INTO mark (updated_date,created_date,is_active,grade,obtain_mark,course_id) VALUES ('2023-05-04','2020-05-05','False','c',79,8);