-- Inserting pre-defined Clinics
INSERT INTO Clinic (clinic_id, name) VALUES (1, 'Cardiology');

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
                     'Dermatologist', 1);