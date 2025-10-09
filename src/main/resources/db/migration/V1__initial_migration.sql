CREATE TABLE cov_codes
(
    id   INT NOT NULL,
    code VARCHAR(255) NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_covcodes PRIMARY KEY (id)
);

CREATE TABLE insurers
(
    id      INT          NOT NULL,
    insurer VARCHAR(255) NOT NULL,
    naic    VARCHAR(255) NULL,
    website VARCHAR(500) NULL,
    CONSTRAINT pk_insurers PRIMARY KEY (id)
);

CREATE TABLE myforms
(
    id                 INT AUTO_INCREMENT NOT NULL,
    agent_name         VARCHAR(255) NULL,
    agent_nbr          VARCHAR(255) NULL,
    agency_name        VARCHAR(255) NULL,
    agency_nbr         VARCHAR(255) NULL,
    name_insured       VARCHAR(255) NULL,
    description_risk   VARCHAR(255) NULL,
    coverage_code      VARCHAR(255) NULL,
    insurer1           VARCHAR(255) NULL,
    contacted_through1 VARCHAR(255) NULL,
    full_contact_name1 VARCHAR(255) NULL,
    email_phone1       VARCHAR(255) NULL,
    website1           VARCHAR(255) NULL,
    naic1              VARCHAR(255) NULL,
    date1              VARCHAR(255) NULL,
    insurer2           VARCHAR(255) NULL,
    contacted_through2 VARCHAR(255) NULL,
    full_contact_name2 VARCHAR(255) NULL,
    email_phone2       VARCHAR(255) NULL,
    website2           VARCHAR(255) NULL,
    naic2              VARCHAR(255) NULL,
    date2              VARCHAR(255) NULL,
    insurer3           VARCHAR(255) NULL,
    contacted_through3 VARCHAR(255) NULL,
    full_contact_name3 VARCHAR(255) NULL,
    email_phone3       VARCHAR(255) NULL,
    website3           VARCHAR(255) NULL,
    naic3              VARCHAR(255) NULL,
    date3              VARCHAR(255) NULL,
    user_id            BIGINT NULL,
    CONSTRAINT pk_myforms PRIMARY KEY (id)
);

CREATE TABLE users
(
    user_id  BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NULL,
    surname  VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    `role`   VARCHAR(255) NULL,
    avatar   VARCHAR(255) NULL,
    theme VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);

ALTER TABLE myforms
    ADD CONSTRAINT FK_MYFORMS_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);