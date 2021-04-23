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

-- Inserting pre-defined Diseases
INSERT INTO Disease(name) VALUES ('COVID-19');
INSERT INTO Disease(name) VALUES ('Diabetes');
INSERT INTO Disease(name) VALUES ('Influenza');
INSERT INTO Disease(name) VALUES ('Healthcare-associated pneumonia (HCAP)');
INSERT INTO Disease(name) VALUES ('Pulmonary embolus');
INSERT INTO Disease(name) VALUES ('Acute tracheobronchitis');
INSERT INTO Disease(name) VALUES ('Gastroesophageal reflux');
INSERT INTO Disease(name) VALUES ('Chronic sinusitis');
INSERT INTO Disease(name) VALUES ('Streptococcal pharyngitis');
INSERT INTO Disease(name) VALUES ('Anxiety');
INSERT INTO Disease(name) VALUES ('Acute mitral regurgitation (MR)');
INSERT INTO Disease(name) VALUES ('Anemia');
INSERT INTO Disease(name) VALUES ('Acute bronchitis');
INSERT INTO Disease(name) VALUES ('Acute coronary syndrome');
INSERT INTO Disease(name) VALUES ('Dissecting thoracic aortic aneurysm');
INSERT INTO Disease(name) VALUES ('Pleural effusion');

-- Inserting pre-defined Symptoms
INSERT INTO Symptom(name) VALUES ('Abdominal pains');
INSERT INTO Symptom(name) VALUES ('Joint pain');
INSERT INTO Symptom(name) VALUES ('Back ache');
INSERT INTO Symptom(name) VALUES ('Bruising');
INSERT INTO Symptom(name) VALUES ('Cough');
INSERT INTO Symptom(name) VALUES ('Diarrhea');
INSERT INTO Symptom(name) VALUES ('Difficulty breathing');
INSERT INTO Symptom(name) VALUES ('Difficulty swallowing');
INSERT INTO Symptom(name) VALUES ('Fever');
INSERT INTO Symptom(name) VALUES ('Headache');
INSERT INTO Symptom(name) VALUES ('Intense fatigue or weakness');
INSERT INTO Symptom(name) VALUES ('Loss of appetite');
INSERT INTO Symptom(name) VALUES ('Nausea vomiting');
INSERT INTO Symptom(name) VALUES ('Chest pain');
INSERT INTO Symptom(name) VALUES ('Rashes');

-- Inserting pre-defined Test Types
INSERT INTO Test_type(type_id,name) VALUES (1, 'Complete blood count (CBC)');
INSERT INTO Test_type(type_id,name) VALUES (2, 'COVID-19 PCR');
INSERT INTO Test_type(type_id,name) VALUES (3, 'Arterial blood gas (ABG)');
INSERT INTO Test_type(type_id,name) VALUES (4, 'Comprehensive metabolic panel (CMP)');
INSERT INTO Test_type(type_id,name) VALUES (5, 'Erythrocyte sedimentation rate (ESR)');
INSERT INTO Test_type(type_id,name) VALUES (6, 'C-reactive protein');
INSERT INTO Test_type(type_id,name) VALUES (7, 'Hormone');

-- Inserting pre-defined Test Components, TODO: Insert More
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('HGB', 13.50, 17.50, 'g/dL', 1);
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('RBC', 4.5, 6.13, 'M/uL', 1);
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('HCT', 42, 52, '%', 1);
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('TSH', 0.51, 4.3, 'ulU/mL', 7);
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('Free T4', 0.98, 1.63, 'ng/dL', 7);
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('Free T3', 2.56, 5.01, 'pg/mL', 7);

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