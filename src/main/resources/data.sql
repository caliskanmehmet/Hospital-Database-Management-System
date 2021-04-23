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
INSERT INTO Disease(disease_id, name) VALUES (1, 'COVID-19');
INSERT INTO Disease(disease_id, name) VALUES (2, 'Diabetes');
INSERT INTO Disease(disease_id, name) VALUES (3, 'Influenza');
INSERT INTO Disease(disease_id, name) VALUES (4, 'Healthcare-associated pneumonia (HCAP)');
INSERT INTO Disease(disease_id, name) VALUES (5, 'Pulmonary embolus');
INSERT INTO Disease(disease_id, name) VALUES (6, 'Acute tracheobronchitis');
INSERT INTO Disease(disease_id, name) VALUES (7, 'Gastroesophageal reflux');
INSERT INTO Disease(disease_id, name) VALUES (8, 'Chronic sinusitis');
INSERT INTO Disease(disease_id, name) VALUES (9, 'Streptococcal pharyngitis');
INSERT INTO Disease(disease_id, name) VALUES (10, 'Anxiety');
INSERT INTO Disease(disease_id, name) VALUES (11, 'Acute mitral regurgitation (MR)');
INSERT INTO Disease(disease_id, name) VALUES (12, 'Anemia');
INSERT INTO Disease(disease_id, name) VALUES (13, 'Acute bronchitis');
INSERT INTO Disease(disease_id, name) VALUES (14, 'Acute coronary syndrome');
INSERT INTO Disease(disease_id, name) VALUES (15, 'Dissecting thoracic aortic aneurysm');
INSERT INTO Disease(disease_id, name) VALUES (16, 'Pleural effusion');

-- Inserting pre-defined Symptoms
INSERT INTO Symptom(symptom_id, name) VALUES (1, 'Abdominal pains');
INSERT INTO Symptom(symptom_id, name) VALUES (2, 'Joint pain');
INSERT INTO Symptom(symptom_id, name) VALUES (3, 'Back ache');
INSERT INTO Symptom(symptom_id, name) VALUES (4, 'Bruising');
INSERT INTO Symptom(symptom_id, name) VALUES (5, 'Cough');
INSERT INTO Symptom(symptom_id, name) VALUES (6, 'Diarrhea');
INSERT INTO Symptom(symptom_id, name) VALUES (7, 'Difficulty breathing');
INSERT INTO Symptom(symptom_id, name) VALUES (8, 'Difficulty swallowing');
INSERT INTO Symptom(symptom_id, name) VALUES (9, 'Fever');
INSERT INTO Symptom(symptom_id, name) VALUES (10, 'Headache');
INSERT INTO Symptom(symptom_id, name) VALUES (11, 'Intense fatigue or weakness');
INSERT INTO Symptom(symptom_id, name) VALUES (12, 'Loss of appetite');
INSERT INTO Symptom(symptom_id, name) VALUES (13, 'Nausea vomiting');
INSERT INTO Symptom(symptom_id, name) VALUES (14, 'Chest pain');
INSERT INTO Symptom(symptom_id, name) VALUES (15, 'Rashes');

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