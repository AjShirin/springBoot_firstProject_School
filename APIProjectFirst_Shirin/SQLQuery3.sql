use API_Practice_Springboot;

Select * From school;
Select * From student;
Select * From course;
Select * From mark;

Select * From course_marks;
Select * From school_students;
Select * From student_courses;

INSERT INTO school (school_name) VALUES ('abm');
INSERT INTO school (school_name,is_active) VALUES ('abc','false');
INSERT INTO student (student_name, roll_number,school_id) VALUES ('Mariam',10,2);
INSERT INTO course (course_name,student_id) VALUES ('Python',5);
INSERT INTO mark (grade,obtain_mark,course_id) VALUES ('A',85,2);