-- Inserting pre-defined Clinics
INSERT INTO Clinic (clinic_id, name) VALUES (1, 'Cardiology');
INSERT INTO Clinic (clinic_id, name) VALUES (2, 'Gastroenterology');
INSERT INTO Clinic (clinic_id, name) VALUES (3, 'Psychology');
INSERT INTO Clinic (clinic_id, name) VALUES (4, 'Endocrinology');
INSERT INTO Clinic (clinic_id, name) VALUES (5, 'Cardiology');
INSERT INTO Clinic (clinic_id, name) VALUES (6, 'Neurology');
INSERT INTO Clinic (clinic_id, name) VALUES (7, 'Ear, Nose & Throat');
INSERT INTO Clinic (clinic_id, name) VALUES (8, 'Child Health');
INSERT INTO Clinic (clinic_id, name) VALUES (9, 'Trauma & Orthopaedics');
INSERT INTO Clinic (clinic_id, name) VALUES (10, 'Dietetics');

-- Inserting pre-defined Doctors
INSERT INTO Doctor (password, first_name, middle_name, last_name,
                    gender, birth_date, specialization, clinic_id)
                    VALUES
                    ('deneme', 'Mehmet', '', 'Çalışkan', 'M', '1997-07-10',
                     'Cardiologist', 1);

INSERT INTO Doctor (password, first_name, middle_name, last_name,
                    gender, birth_date, specialization, clinic_id)
                    VALUES
                    ('fD32GDG1', 'Mert', '', 'Çalışkan', 'M', '2000-07-10',
                     'Child Health', 8);

INSERT INTO Doctor (password, first_name, middle_name, last_name,
                    gender, birth_date, specialization, clinic_id)
                    VALUES
                    ('fd3bfDZ1', 'Ömer', 'Yavuz', 'Öztürk', 'M', '2000-05-17',
                     'Psychology', 3);

INSERT INTO Doctor (password, first_name, middle_name, last_name,
                    gender, birth_date, specialization, clinic_id)
                    VALUES
                    ('dg53fFF3', 'Yusuf', '', 'Alpdemir', 'M', '2000-01-28',
                     'Cardiologist', 1);