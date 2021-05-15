-- Inserting pre-defined Clinics
INSERT INTO Clinic (clinic_id, name) VALUES (1, 'Cardiology')^;
INSERT INTO Clinic (clinic_id, name) VALUES (2, 'Gastroenterology')^;
INSERT INTO Clinic (clinic_id, name) VALUES (3, 'Psychology')^;
INSERT INTO Clinic (clinic_id, name) VALUES (4, 'Endocrinology')^;
INSERT INTO Clinic (clinic_id, name) VALUES (5, 'Cardiology')^;
INSERT INTO Clinic (clinic_id, name) VALUES (6, 'Neurology')^;
INSERT INTO Clinic (clinic_id, name) VALUES (7, 'Ear, Nose & Throat')^;
INSERT INTO Clinic (clinic_id, name) VALUES (8, 'Child Health')^;
INSERT INTO Clinic (clinic_id, name) VALUES (9, 'Trauma & Orthopaedics')^;
INSERT INTO Clinic (clinic_id, name) VALUES (10, 'Dietetics')^;
INSERT INTO Clinic (clinic_id, name) VALUES (11, 'Clinical Laboratory')^;

-- Inserting pre-defined Diseases
INSERT INTO Disease(disease_id, name) VALUES (1, 'COVID-19')^;
INSERT INTO Disease(disease_id, name) VALUES (2, 'Diabetes')^;
INSERT INTO Disease(disease_id, name) VALUES (3, 'Influenza')^;
INSERT INTO Disease(disease_id, name) VALUES (4, 'Healthcare-associated pneumonia (HCAP)')^;
INSERT INTO Disease(disease_id, name) VALUES (5, 'Pulmonary embolus')^;
INSERT INTO Disease(disease_id, name) VALUES (6, 'Acute tracheobronchitis')^;
INSERT INTO Disease(disease_id, name) VALUES (7, 'Gastroesophageal reflux')^;
INSERT INTO Disease(disease_id, name) VALUES (8, 'Chronic sinusitis')^;
INSERT INTO Disease(disease_id, name) VALUES (9, 'Streptococcal pharyngitis')^;
INSERT INTO Disease(disease_id, name) VALUES (10, 'Anxiety')^;
INSERT INTO Disease(disease_id, name) VALUES (11, 'Acute mitral regurgitation (MR)')^;
INSERT INTO Disease(disease_id, name) VALUES (12, 'Anemia')^;
INSERT INTO Disease(disease_id, name) VALUES (13, 'Acute bronchitis')^;
INSERT INTO Disease(disease_id, name) VALUES (14, 'Acute coronary syndrome')^;
INSERT INTO Disease(disease_id, name) VALUES (15, 'Dissecting thoracic aortic aneurysm')^;
INSERT INTO Disease(disease_id, name) VALUES (16, 'Pleural effusion')^;

-- Inserting pre-defined Symptoms
INSERT INTO Symptom(symptom_id, name) VALUES (1, 'Abdominal pains')^;
INSERT INTO Symptom(symptom_id, name) VALUES (2, 'Joint pain')^;
INSERT INTO Symptom(symptom_id, name) VALUES (3, 'Back ache')^;
INSERT INTO Symptom(symptom_id, name) VALUES (4, 'Bruising')^;
INSERT INTO Symptom(symptom_id, name) VALUES (5, 'Cough')^;
INSERT INTO Symptom(symptom_id, name) VALUES (6, 'Diarrhea')^;
INSERT INTO Symptom(symptom_id, name) VALUES (7, 'Difficulty breathing')^;
INSERT INTO Symptom(symptom_id, name) VALUES (8, 'Difficulty swallowing')^;
INSERT INTO Symptom(symptom_id, name) VALUES (9, 'Fever')^;
INSERT INTO Symptom(symptom_id, name) VALUES (10, 'Headache')^;
INSERT INTO Symptom(symptom_id, name) VALUES (11, 'Intense fatigue or weakness')^;
INSERT INTO Symptom(symptom_id, name) VALUES (12, 'Loss of appetite')^;
INSERT INTO Symptom(symptom_id, name) VALUES (13, 'Nausea vomiting')^;
INSERT INTO Symptom(symptom_id, name) VALUES (14, 'Chest pain')^;
INSERT INTO Symptom(symptom_id, name) VALUES (15, 'Rashes')^;

-- Inserting pre-defined Test Types
INSERT INTO Test_type(type_id,name) VALUES (1, 'Complete blood count (CBC)')^;
INSERT INTO Test_type(type_id,name) VALUES (2, 'COVID-19 PCR')^;
INSERT INTO Test_type(type_id,name) VALUES (3, 'Arterial blood gas (ABG)')^;
INSERT INTO Test_type(type_id,name) VALUES (4, 'Comprehensive metabolic panel (CMP)')^;
INSERT INTO Test_type(type_id,name) VALUES (5, 'Erythrocyte sedimentation rate (ESR)')^;
INSERT INTO Test_type(type_id,name) VALUES (6, 'C-reactive protein')^;
INSERT INTO Test_type(type_id,name) VALUES (7, 'Hormone')^;

-- Inserting pre-defined Test Components, TODO: Insert More
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('HGB', 13.50, 17.50, 'g/dL', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('RBC', 4.5, 6.13, 'M/uL', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('HCT', 42, 52, '%', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                        ('WBC', 4, 10.5, 'k/uL', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                        ('NEU%', 37, 80, '%', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                        ('LY%', 10, 50, '%', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                        ('MCV', 80, 100, 'fL', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                        ('MCH', 25, 34, 'pg', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                        ('PLT', 140, 424, 'K/uL', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                        ('BAS#', 0, 0.2, 'K/uL', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                        ('PCT', 0, 9.99, '%', 1)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('TSH', 0.51, 4.3, 'ulU/mL', 7)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('Free T4', 0.98, 1.63, 'ng/dL', 7)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                          ('Free T3', 2.56, 5.01, 'pg/mL', 7)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('IGF I', 53, 331, 'ng/mL', 7)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('Progesterone', 0, 1.4, 'ng/mL', 7)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('CT', 24, 35, 'ng/mL', 2)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('HCO3', 22, 38, 'mEq/L', 3)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('PaO2', 75, 100, 'mmHg', 3)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('SaO2', 94, 100, '%', 3)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('ALT', 4, 36, 'U/L', 4)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('AST', 8, 36, 'U/L', 4)^;
INSERT INTO Test_component(parameter_name, min_value, max_value, unit, test_type_id) VALUES
                            ('BUN', 6, 20, 'mg/dl', 4)^;

-- Inserting pre-defined Doctors
INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                   ('MehmetCaliskan', 'Mehmet', '', 'Çalışkan', 'M', '1997-07-10')^;

INSERT INTO Doctor (person_id, specialization, clinic_id)
                    VALUES
                    ((SELECT LAST_INSERT_ID()), 'Cardiologist', 1)^;

INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                   ('MertCaliskan', 'Mert', '', 'Çalışkan', 'M', '2000-02-10')^;

INSERT INTO Doctor (person_id, specialization, clinic_id)
                    VALUES
                    ((SELECT LAST_INSERT_ID()), 'Psychology', 3)^;

INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                    ('OmerOzturk', 'Ömer', 'Yavuz', 'Öztürk', 'M', '1999-06-19')^;

INSERT INTO Doctor (person_id, specialization, clinic_id)
                    VALUES
                    ((SELECT LAST_INSERT_ID()), 'Cardiologist', 1)^;

-- Inserting pre-defined Laboratorians
INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                    ('YusufAlpdemir', 'Yusuf', '', 'Alpdemir', 'M', '1998-12-19')^;

INSERT INTO Laboratorian (person_id, specialization, clinic_id)
                        VALUES
                        ((SELECT LAST_INSERT_ID()), 'Blood Test Specialist', 11)^;

INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                        ('KahramanDeniz', 'Kahraman', '', 'Deniz', 'M', '1992-12-01')^;

INSERT INTO Laboratorian (person_id, specialization, clinic_id)
                        VALUES
                        ((SELECT LAST_INSERT_ID()), 'Hormone Test Specialist', 11)^;

INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                        ('CerenGundogdu', 'Ceren', '', 'Gündoğdu', 'F', '1997-12-15')^;

INSERT INTO Laboratorian (person_id, specialization, clinic_id)
                        VALUES
                        ((SELECT LAST_INSERT_ID()), 'Blood Test Specialist', 11)^;

INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                        ('KadirYilmaz', 'Kadir', '', 'Yılmaz', 'M', '1993-12-15')^;

INSERT INTO Laboratorian (person_id, specialization, clinic_id)
                        VALUES
                        ((SELECT LAST_INSERT_ID()), 'ABG Test Specialist', 11)^;

INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                        ('AhmetYildirim', 'Ahmet', '', 'Yıldırım', 'M', '1990-05-15')^;

INSERT INTO Laboratorian (person_id, specialization, clinic_id)
                        VALUES
                        ((SELECT LAST_INSERT_ID()), 'CMP Test Specialist', 11)^;

INSERT INTO Eligible_for (test_type, laboratorian_id) VALUES (1, 2000)^;
INSERT INTO Eligible_for (test_type, laboratorian_id) VALUES (1, 2002)^;
INSERT INTO Eligible_for (test_type, laboratorian_id) VALUES (7, 2001)^;
INSERT INTO Eligible_for (test_type, laboratorian_id) VALUES (3, 2003)^;
INSERT INTO Eligible_for (test_type, laboratorian_id) VALUES (4, 2004)^;

-- Inserting pre-defined Patients
INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                    ('JackRyan', 'Jack', '', 'Ryan', 'M', '1970-12-19')^;

INSERT INTO Patient (ssn, person_id, weight, height, blood_type)
                        VALUES
                        ('12345678910',(SELECT LAST_INSERT_ID()), 76, 178, 'AB Rh-')^;

INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES
                        ('JonSnow', 'Jon', '', 'Snow', 'M', '1980-12-19')^;

INSERT INTO Patient (ssn, person_id, weight, height, blood_type)
                        VALUES
                        ('1531357530',(SELECT LAST_INSERT_ID()), 74, 170, '0 Rh-')^;