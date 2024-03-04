CREATE TABLE IF NOT EXISTS public.doctor
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(40) NOT NULL,
    specialization VARCHAR(40) NOT NULL,
    phone_number   VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.patient
(
    id        BIGSERIAL PRIMARY KEY,
    doctor_id BIGINT      NOT NULL,
    name      VARCHAR(30) NOT NULL,
    CONSTRAINT fk_patient_doctor_id
        FOREIGN KEY (doctor_id)
            REFERENCES doctor (id)
);

CREATE TABLE IF NOT EXISTS public.student
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    phone VARCHAR(7)
);

CREATE TABLE IF NOT EXISTS public.course
(
    id   BIGSERIAL PRIMARY KEY,
    course_name VARCHAR(20) NOT NULL,
    school VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS public.student_course
(
    student_id BIGSERIAL NOT NULL,
    course_id  BIGSERIAL NOT NULL,
    CONSTRAINT fk_student_course_student_id
        FOREIGN KEY (student_id)
            REFERENCES student (id),

    CONSTRAINT fk_student_course_course_id
        FOREIGN KEY (course_id)
            REFERENCES course (id)
);