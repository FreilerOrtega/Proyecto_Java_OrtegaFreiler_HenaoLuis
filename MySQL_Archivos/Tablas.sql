drop database if exists xd;
create database if not exists xd;

use xd;

CREATE TABLE Persona (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    second_name VARCHAR(255),
    last_name1 VARCHAR(255),
    last_name2 VARCHAR(255),
    id_number INT,
    address VARCHAR(255),
    phone BIGINT,
    email VARCHAR(255),
    emergency_contact BIGINT,
    person_type VARCHAR(255)
);

CREATE TABLE Mascota (
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameP VARCHAR(255),
    species VARCHAR(255),
    breed VARCHAR(255),
    age INT,
    birth_date VARCHAR(255),
    gender VARCHAR(255),
    weight DOUBLE,
    photo VARCHAR(255),
    owner_id INT,
    FOREIGN KEY (owner_id) REFERENCES Persona(id)
);

CREATE TABLE Lote (
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    entry_date VARCHAR(255),
    entry_quantity INT,
    current_quantity INT,
    expiration_date VARCHAR(255)
);

CREATE TABLE Medicamento (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameM VARCHAR(255),
    batch_id INT,
    manufacturer VARCHAR(255),
    typeM VARCHAR(255),
    presentation VARCHAR(255),
    price INT,
    FOREIGN KEY (batch_id) REFERENCES Lote(id)
);

CREATE TABLE Historial_vacunas (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id INT,
    vaccine_id INT,
    application_date VARCHAR(255),
    next_dose_date VARCHAR(255),
    FOREIGN KEY (pet_id) REFERENCES Mascota(id),
    FOREIGN KEY (vaccine_id) REFERENCES Medicamento(id)
);

CREATE TABLE Padecimientos (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id INT,
    detection_date VARCHAR(255),
    diagnosis VARCHAR(255),
    FOREIGN KEY (pet_id) REFERENCES Mascota(id)
);

CREATE TABLE cita (
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id INT,
    owner_id INT,
    dates VARCHAR(255),
    consultation_reason VARCHAR(255),
    veterinarian_id INT,
    diagnosis VARCHAR(255),
    attendance BOOLEAN,
    status VARCHAR(255),
    hours varchar(10),
    FOREIGN KEY (pet_id) REFERENCES Mascota(id),
    FOREIGN KEY (owner_id) REFERENCES Persona(id),
    FOREIGN KEY (veterinarian_id) REFERENCES Persona(id)
);

CREATE TABLE Procedimiento (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id INT,
    procedurer VARCHAR(255),
    dates VARCHAR(255),
    veterinarian_id INT,
    appointment_id INT,
    FOREIGN KEY (pet_id) REFERENCES Mascota(id),
    FOREIGN KEY (veterinarian_id) REFERENCES Persona(id),
    FOREIGN KEY (appointment_id) REFERENCES cita(id)
);


CREATE TABLE Desparacitaciones (
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    typeD VARCHAR(255),
    application_date VARCHAR(255),
    next_deworming_date VARCHAR(255),
    medicine_id INT,
    pet_id INT,
    veterinarian_id INT,
    FOREIGN KEY (medicine_id) REFERENCES Medicamento(id),
    FOREIGN KEY (pet_id) REFERENCES Mascota(id),
    FOREIGN KEY (veterinarian_id) REFERENCES Persona(id)
);

CREATE TABLE Cirugias (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id INT,
    veterinarian_id INT,
    surgery_date VARCHAR(255),
    recovery_days INT,
    recovery_status VARCHAR(255),
    FOREIGN KEY (pet_id) REFERENCES Mascota(id),
    FOREIGN KEY (veterinarian_id) REFERENCES Persona(id)
);

CREATE TABLE login (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    passwordU VARCHAR(255),
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES Persona(id)
);

CREATE TABLE Facturas (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    descriptions INT,
    total INT,
    date VARCHAR(255),
    FOREIGN KEY (client_id) REFERENCES Persona(id)
);

CREATE TABLE medicamento_factura (
    invoice_id INT NOT NULL,
    medicine_id INT,
    quantity INT,
    FOREIGN KEY (invoice_id) REFERENCES Facturas(id),
    FOREIGN KEY (medicine_id) REFERENCES Medicamento(id)
);

CREATE TABLE Contratos_Adopcion (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id INT,
    owner_id INT,
    date INT,
    FOREIGN KEY (pet_id) REFERENCES Mascota(id),
    FOREIGN KEY (owner_id) REFERENCES Persona(id)
);

CREATE TABLE seguimiento_post_adopcion (
    appointment_number INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    contract_id INT,
    details VARCHAR(255),
    dates VARCHAR(255),
    FOREIGN KEY (contract_id) REFERENCES Contratos_Adopcion(id)
);