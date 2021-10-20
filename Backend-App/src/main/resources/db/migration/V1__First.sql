CREATE TABLE IF NOT EXISTS patient (
 patient_id INT AUTO_INCREMENT,
    patient_name VARCHAR(255) NOT NULL,
    mobile_no VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    blood_group VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    age int,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (patient_id)
)  ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS doctor
(
    doctor_id int NOT NULL AUTO_INCREMENT,
    doctor_name VARCHAR(255),
    speciality VARCHAR(255),
    location VARCHAR(255),
    hospital_name VARCHAR(255),
    mobile_no VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    charged_per_visit double precision,
    PRIMARY KEY (doctor_id)
) ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS appointment
(
    appointment_id int NOT NULL AUTO_INCREMENT,
    patient_id int,
    doctor_id int,
    appointment_date DATETIME,
    appointment_time varchar(30),
    appointment_status VARCHAR(255),
    remark VARCHAR(255),
    CONSTRAINT Appointment_pkey PRIMARY KEY (appointment_id),
    CONSTRAINT doctor_fk FOREIGN KEY (doctor_id)
        REFERENCES Doctor (doctor_id) MATCH SIMPLE,
    CONSTRAINT patient_fk FOREIGN KEY (patient_id)
        REFERENCES Patient (patient_id) MATCH SIMPLE
) ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS availability_dates
(
    availability_id int NOT NULL AUTO_INCREMENT,
    doctor_id int,
    from_date DATETIME,
    end_date DATETIME,
    PRIMARY KEY (availability_id),
    FOREIGN KEY (doctor_id)
        REFERENCES Doctor (doctor_id) MATCH SIMPLE
) ENGINE=INNODB;



CREATE TABLE IF NOT EXISTS admin
(
    admin_id int NOT NULL AUTO_INCREMENT,
    admin_name VARCHAR(255),
    contact_no VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (admin_id)
) ENGINE=INNODB;


CREATE TABLE feedback
(
    feedback_id int NOT NULL AUTO_INCREMENT,
    rating int,
    patient_id int,
    doctor_id int,
    feedback_comment VARCHAR(255),
    PRIMARY KEY (feedback_id),
    FOREIGN KEY (patient_id)
        REFERENCES Patient (patient_id) MATCH SIMPLE,
    FOREIGN KEY (doctor_id)
        REFERENCES Doctor (doctor_id) MATCH SIMPLE
) ENGINE=INNODB;



CREATE TABLE user
(
    user_id int NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(255),
    password VARCHAR(255),
    roles VARCHAR(255),
    PRIMARY KEY (user_id),
    CONSTRAINT UserToDoctor_FK FOREIGN KEY (user_id)
        REFERENCES Doctor (doctor_id) MATCH SIMPLE,
    CONSTRAINT UserToPatient_FK FOREIGN KEY (user_id)
        REFERENCES Patient (patient_id) MATCH SIMPLE
) ENGINE=INNODB;
