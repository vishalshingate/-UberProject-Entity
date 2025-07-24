CREATE TABLE car
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    created_at  datetime              NOT NULL,
    updated_at  datetime              NOT NULL,
    plat_number VARCHAR(255)          NULL,
    brand       VARCHAR(255)          NULL,
    model       VARCHAR(255)          NULL,
    car_type    ENUM('XL,SEDAN,HATCHBACK,COMPACT_SUV,SUV'),
    driver_id   BIGINT                NULL,
    color_id    BIGINT                NULL,
    CONSTRAINT pk_car PRIMARY KEY (id)
);

CREATE TABLE color
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    updated_at datetime              NOT NULL,
    color      VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_color PRIMARY KEY (id)
);

CREATE TABLE dbconstant
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    updated_at datetime              NOT NULL,
    name       VARCHAR(255)          NOT NULL,
    value      VARCHAR(255)          NULL,
    CONSTRAINT pk_dbconstant PRIMARY KEY (id)
);

CREATE TABLE exact_location
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    updated_at datetime              NOT NULL,
    latitude   DOUBLE                NULL,
    longitude  DOUBLE                NULL,
    CONSTRAINT pk_exactlocation PRIMARY KEY (id)
);

CREATE TABLE named_location
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    created_at        datetime              NOT NULL,
    updated_at        datetime              NOT NULL,
    exact_location_id BIGINT                NULL,
    name              VARCHAR(255)          NULL,
    zip_code          VARCHAR(255)          NULL,
    country           VARCHAR(255)          NULL,
    state             VARCHAR(255)          NULL,
    CONSTRAINT pk_namedlocation PRIMARY KEY (id)
);

CREATE TABLE otp
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime              NOT NULL,
    updated_at     datetime              NOT NULL,
    code           VARCHAR(255)          NULL,
    send_to_number VARCHAR(255)          NULL,
    CONSTRAINT pk_otp PRIMARY KEY (id)
);

ALTER TABLE driver
    ADD aadharcard VARCHAR(255) NULL;

ALTER TABLE driver
    ADD active_city VARCHAR(255) NULL;

ALTER TABLE driver
    ADD driver_approval_status ENUM('APPROVED,DENIED,PENDING');

ALTER TABLE driver
    ADD home_id BIGINT NULL;

ALTER TABLE driver
    ADD is_available BIT(1) NULL;

ALTER TABLE driver
    ADD last_know_location_id BIGINT NULL;

ALTER TABLE driver
    ADD phone_number VARCHAR(255) NULL;

ALTER TABLE driver
    ADD rating DOUBLE NULL;

ALTER TABLE passenger
    ADD active_booking_id BIGINT NULL;

ALTER TABLE passenger
    ADD home_id BIGINT NULL;

ALTER TABLE passenger
    ADD last_known_location_id BIGINT NULL;

ALTER TABLE passenger
    ADD rating DOUBLE NULL;

ALTER TABLE booking
    ADD end_location_id BIGINT NULL;

ALTER TABLE booking
    ADD start_location_id BIGINT NULL;

ALTER TABLE driver
    MODIFY is_available BIT(1) NOT NULL;

ALTER TABLE car
    ADD CONSTRAINT uc_car_platnumber UNIQUE (plat_number);

ALTER TABLE color
    ADD CONSTRAINT uc_color_color UNIQUE (color);

ALTER TABLE dbconstant
    ADD CONSTRAINT uc_dbconstant_name UNIQUE (name);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_ENDLOCATION FOREIGN KEY (end_location_id) REFERENCES exact_location (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_STARTLOCATION FOREIGN KEY (start_location_id) REFERENCES exact_location (id);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_COLOR FOREIGN KEY (color_id) REFERENCES color (id);

ALTER TABLE car
    ADD CONSTRAINT FK_CAR_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_HOME FOREIGN KEY (home_id) REFERENCES exact_location (id);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_LASTKNOWLOCATION FOREIGN KEY (last_know_location_id) REFERENCES exact_location (id);

ALTER TABLE named_location
    ADD CONSTRAINT FK_NAMEDLOCATION_ON_EXACTLOCATION FOREIGN KEY (exact_location_id) REFERENCES exact_location (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_ACTIVEBOOKING FOREIGN KEY (active_booking_id) REFERENCES booking (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_HOME FOREIGN KEY (home_id) REFERENCES exact_location (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_LASTKNOWNLOCATION FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);
