DROP TABLE IF EXISTS diagnose;
DROP TABLE IF EXISTS disease_shows_symptom;
DROP TABLE IF EXISTS disease;
DROP TABLE IF EXISTS eligible_for;
DROP TABLE IF EXISTS evaluate;
DROP TABLE IF EXISTS process;
DROP TABLE IF EXISTS laboratorian;
DROP TABLE IF EXISTS result_of;
DROP TABLE IF EXISTS symptoms_during_visit;
DROP TABLE IF EXISTS symptom;
DROP TABLE IF EXISTS test_component;
DROP TABLE IF EXISTS test_request;
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS clinic;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS test_type;

CREATE TABLE Patient (
        id   INTEGER      NOT NULL AUTO_INCREMENT,
        password VARCHAR(32) NOT NULL,
        first_name VARCHAR(20) NOT NULL,
        middle_name VARCHAR(20),
        last_name VARCHAR(20) NOT NULL,
        gender VARCHAR(1) NOT NULL,
        birth_date DATE NOT NULL,
        ssn VARCHAR(15) NOT NULL,
        weight INTEGER,
        height INTEGER,
        blood_type VARCHAR(10),
        PRIMARY KEY (id)
);

CREATE TABLE Clinic (
        clinic_id INTEGER NOT NULL,
        name VARCHAR(50) NOT NULL,
        PRIMARY KEY (clinic_id)
);

CREATE TABLE Laboratorian (
        id   INTEGER      NOT NULL AUTO_INCREMENT,
        password VARCHAR(32) NOT NULL,
        first_name VARCHAR(20) NOT NULL,
        middle_name VARCHAR(20),
        last_name VARCHAR(20) NOT NULL,
        gender VARCHAR(1) NOT NULL,
        birth_date DATE NOT NULL,
        specialization VARCHAR(30) NOT NULL,
        clinic_id INTEGER,
        PRIMARY KEY (id),
        FOREIGN KEY (clinic_id) REFERENCES Clinic(clinic_id)
);

CREATE TABLE Doctor (
        id   INTEGER      NOT NULL AUTO_INCREMENT,
        password VARCHAR(32) NOT NULL,
        first_name VARCHAR(20) NOT NULL,
        middle_name VARCHAR(20),
        last_name VARCHAR(20) NOT NULL,
        gender VARCHAR(1) NOT NULL,
        birth_date DATE NOT NULL,
        specialization VARCHAR(30) NOT NULL,
        clinic_id INTEGER,
        PRIMARY KEY (id),
        FOREIGN KEY (clinic_id) REFERENCES Clinic(clinic_id)
);

CREATE TABLE Appointment (
        app_id INTEGER NOT NULL AUTO_INCREMENT,
        app_status VARCHAR(15) NOT NULL,
        app_date DATE NOT NULL,
        app_time TIME NOT NULL,
        patient_id INTEGER NOT NULL,
        doctor_id INTEGER NOT NULL,
        PRIMARY KEY (app_id),
        FOREIGN KEY (patient_id) REFERENCES Patient(id),
        FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);

CREATE TABLE Evaluate (
        comment VARCHAR(500),
        rating INTEGER NOT NULL,
        patient_id INTEGER NOT NULL,
        app_id INTEGER NOT NULL,
        PRIMARY KEY (patient_id, app_id),
        FOREIGN KEY (patient_id) REFERENCES Patient(id),
        FOREIGN KEY (app_id) REFERENCES Appointment(app_id)
);

CREATE TABLE Disease (
        disease_id INTEGER NOT NULL,
        name VARCHAR(50) NOT NULL,
        PRIMARY KEY(disease_id)
);

CREATE TABLE Diagnose (
        explanation VARCHAR(500),
        app_id INTEGER NOT NULL,
        disease_id INTEGER NOT NULL,
        PRIMARY KEY (app_id, disease_id),
        FOREIGN KEY (app_id) REFERENCES Appointment(app_id),
        FOREIGN KEY (disease_id) REFERENCES Disease(disease_id)
);

CREATE TABLE Symptom (
        symptom_id INTEGER NOT NULL,
        name VARCHAR(50) NOT NULL,
        explanation VARCHAR(200),
        PRIMARY KEY (symptom_id)
);

CREATE TABLE Disease_shows_symptom (
        disease_id INTEGER NOT NULL,
        symptom_id INTEGER NOT NULL,
        PRIMARY KEY (disease_id, symptom_id),
        FOREIGN KEY (disease_id) REFERENCES Disease(disease_id),
        FOREIGN KEY (symptom_id) REFERENCES Symptom(symptom_id)
);

CREATE TABLE Symptoms_during_visit (
        app_id INTEGER NOT NULL,
        symptom_id INTEGER NOT NULL,
        PRIMARY KEY (app_id, symptom_id),
        FOREIGN KEY (app_id) REFERENCES Appointment(app_id),
        FOREIGN KEY (symptom_id) REFERENCES Symptom(symptom_id)
);

CREATE TABLE Test_type (
        type_id INTEGER NOT NULL,
        name VARCHAR(30) NOT NULL,
        PRIMARY KEY (type_id)
);

CREATE TABLE Test_request (
        request_id INTEGER NOT NULL AUTO_INCREMENT,
        status VARCHAR(15) NOT NULL,
        request_date_time DATETIME NOT NULL,
        app_id INTEGER NOT NULL,
        test_type_id INTEGER NOT NULL,
        PRIMARY KEY (request_id),
        FOREIGN KEY (app_id) REFERENCES Appointment(app_id),
        FOREIGN KEY (test_type_id) REFERENCES Test_type(type_id)
);

CREATE TABLE Eligible_for (
        test_type INTEGER NOT NULL,
        laboratorian_id INTEGER NOT NULL,
        PRIMARY KEY (test_type, laboratorian_id),
        FOREIGN KEY (test_type) REFERENCES Test_type(type_id),
        FOREIGN KEY (laboratorian_id) REFERENCES Laboratorian(id)
);

CREATE TABLE Test_component (
        parameter_name VARCHAR(20) NOT NULL,
        min_value DECIMAL(7,2) NOT NULL,
        max_value DECIMAL(7,2) NOT NULL,
        unit VARCHAR(10) NOT NULL,
        test_type_id INTEGER NOT NULL,
        PRIMARY KEY (test_type_id, parameter_name),
        FOREIGN KEY (test_type_id) REFERENCES Test_type(type_id)
);

CREATE TABLE Result_of (
        score DECIMAL(7,2) NOT NULL,
        test_type_id INTEGER NOT NULL,
        parameter_name VARCHAR(20) NOT NULL,
        request_id INTEGER NOT NULL,
        PRIMARY KEY (test_type_id, parameter_name, request_id),
        FOREIGN KEY (request_id) REFERENCES Test_request(request_id),
        FOREIGN KEY (test_type_id, parameter_name) REFERENCES Test_component(test_type_id, parameter_name)
);

CREATE TABLE Process (
        date_time DATETIME NOT NULL,
        comment VARCHAR(500),
        laboratorian_id INTEGER NOT NULL,
        request_id INTEGER NOT NULL,
        PRIMARY KEY (laboratorian_id, request_id),
        FOREIGN KEY (laboratorian_id) REFERENCES Laboratorian(id),
        FOREIGN KEY (request_id) REFERENCES Test_request(request_id)
);