CREATE DATABASE `assignment`;
USE `assignment`;

CREATE TABLE doctor(
	id int not null auto_increment primary key,
    doctor_name varchar(55),
    city ENUM('Delhi','Noida','Faridabad'),
    email varchar(255),
    phone varchar(20),
    speciality ENUM('Orthopedic','Gynecology','Dermatology','ENT Specialist')
);

-- drop table doctor;
-- select * from doctor;


CREATE TABLE patient(
	id int not null auto_increment primary key,
    patient_name varchar(55),
    city varchar(55),
    email varchar(255),
    phone varchar(20),
    symptom ENUM('Arthritis','Back Pain','Tissue injuries','Dysmenorrhea','Skin Infection','Skin Burn','Ear Pain')
);

-- drop table patient;
-- select * from patient;


-- select* from patient_doc;
