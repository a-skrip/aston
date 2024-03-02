CREATE TABLE IF NOT EXISTS public.user
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(40) NOT NULL,
    post_code  VARCHAR(15),
    profession VARCHAR(40)
);

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
    doctor_id BIGINT NOT NULL ,
    name      VARCHAR(30) NOT NULL,
    CONSTRAINT fk_patient_doctor_id
    FOREIGN KEY (doctor_id)
    REFERENCES doctor (id)
);

