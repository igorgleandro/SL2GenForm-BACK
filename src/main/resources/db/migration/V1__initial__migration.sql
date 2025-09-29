CREATE TABLE users
(
    user_name    varchar(255) not null,
    user_surname varchar(255) not null,
    user_email   varchar(255) not null,
    user_id      bigint auto_increment
        primary key
);

CREATE TABLE myforms (
                         myforms_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id BIGINT NOT NULL,
                         agent_name VARCHAR(255) NOT NULL,
                         agent_nbr VARCHAR(255) NOT NULL,
                         agency_name VARCHAR(255) NOT NULL,
                         agency_nbr VARCHAR(255) NOT NULL,
                         name_insured VARCHAR(255) NOT NULL,
                         description_risk VARCHAR(255) NOT NULL,
                         coverage_code VARCHAR(255),
                         insurer1 VARCHAR(255),
                         contacted_through1 VARCHAR(255),
                         full_contact_name1 VARCHAR(255),
                         email_phone1 VARCHAR(255),
                         website1 VARCHAR(255),
                         naic1 VARCHAR(255),
                         date1 VARCHAR(255),
                         insurer2 VARCHAR(255),
                         contacted_through2 VARCHAR(255),
                         full_contact_name2 VARCHAR(255),
                         email_phone2 VARCHAR(255),
                         website2 VARCHAR(255),
                         naic2 VARCHAR(255),
                         date2 VARCHAR(255),
                         insurer3 VARCHAR(255),
                         contacted_through3 VARCHAR(255),
                         full_contact_name3 VARCHAR(255),
                         email_phone3 VARCHAR(255),
                         website3 VARCHAR(255),
                         naic3 VARCHAR(255),
                         date3 VARCHAR(255),
                         FOREIGN KEY (user_id) REFERENCES users(user_id)
);