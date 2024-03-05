insert into public.doctor (name, specialization, phone_number) values ('Deane', 'Therapist', '104-252');
insert into public.doctor (name, specialization, phone_number) values ('Davis', 'Surgeon', '205-311');
insert into public.doctor (name, specialization, phone_number) values ('Vittorio', 'Dentist', '555-658');
insert into public.doctor (name, specialization, phone_number) values ('Koren', 'Gynecologist', '888-654');

insert into public.patient (doctor_id, name) values (1,'Vasya');
insert into public.patient (doctor_id, name) values (1,'Dima');
insert into public.patient (doctor_id, name) values (2,'Sveta');
insert into public.patient (doctor_id, name) values (3,'Nastya');
insert into public.patient (doctor_id, name) values (4,'Oleg');
insert into public.patient (doctor_id, name) values (1,'Michael');
insert into public.patient (doctor_id, name) values (3,'Alexey');
insert into public.patient (doctor_id, name) values (2,'Kseny');
insert into public.patient (doctor_id, name) values (3,'Zepp');
insert into public.patient (doctor_id, name) values (1,'Said');
insert into public.patient (doctor_id, name) values (4,'Pupsik');

insert into public.student (name, phone) values ('S_Vasya', '1238855');
insert into public.student (name, phone) values ('S_Dima', '1238855');
insert into public.student (name, phone) values ('S_Sveta', '1238855');
insert into public.student (name, phone) values ('S_Nastya', '1238855');
insert into public.student (name, phone) values ('S_Oleg', '1238855');
insert into public.student (name, phone) values ('S_Michael', '1238855');
insert into public.student (name, phone) values ('S_Beyeta', '1238855');
insert into public.student (name, phone) values ('S_Lenystya', '1238855');
insert into public.student (name, phone) values ('S_Feppeta', '1238855');
insert into public.student (name, phone) values ('S_Sadistka', '1238855');


insert into public.course (course_name, school) values ('JAVA', 'IT');
insert into public.course (course_name, school) values ('C++', 'IT');
insert into public.course (course_name, school) values ('EXEL', 'Microsoft');
insert into public.course (course_name, school) values ('Office', 'Microsoft');
insert into public.course (course_name, school) values ('FOTO', 'Design');
insert into public.course (course_name, school) values ('Video', 'Design');

insert into public.student_course (student_id, course_id) VALUES (1, 1);
insert into public.student_course (student_id, course_id) VALUES (1, 2);
insert into public.student_course (student_id, course_id) VALUES (2, 3);
insert into public.student_course (student_id, course_id) VALUES (2, 4);
insert into public.student_course (student_id, course_id) VALUES (3, 5);
insert into public.student_course (student_id, course_id) VALUES (3, 6);



insert into public.student_course (student_id, course_id) VALUES (2, 1);
insert into public.student_course (student_id, course_id) VALUES (1, 2);
insert into public.student_course (student_id, course_id) VALUES (2, 5);
insert into public.student_course (student_id, course_id) VALUES (1, 4);
insert into public.student_course (student_id, course_id) VALUES (3, 3);
insert into public.student_course (student_id, course_id) VALUES (4, 6);
insert into public.student_course (student_id, course_id) VALUES (4, 2);
insert into public.student_course (student_id, course_id) VALUES (4, 1);
insert into public.student_course (student_id, course_id) VALUES (5, 3);
insert into public.student_course (student_id, course_id) VALUES (5, 1);
insert into public.student_course (student_id, course_id) VALUES (5, 2);
insert into public.student_course (student_id, course_id) VALUES (5, 3);
insert into public.student_course (student_id, course_id) VALUES (5, 4);
insert into public.student_course (student_id, course_id) VALUES (5, 5);
insert into public.student_course (student_id, course_id) VALUES (10, 6);
insert into public.student_course (student_id, course_id) VALUES (9, 1);
insert into public.student_course (student_id, course_id) VALUES (8, 1);
insert into public.student_course (student_id, course_id) VALUES (7, 1);
insert into public.student_course (student_id, course_id) VALUES (6, 1);
insert into public.student_course (student_id, course_id) VALUES (5, 1);
insert into public.student_course (student_id, course_id) VALUES (4, 1);
insert into public.student_course (student_id, course_id) VALUES (3, 1);
