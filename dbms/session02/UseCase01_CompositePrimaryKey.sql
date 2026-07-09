-- Use Case 1: Define Primary Keys in COVID Tables
CREATE TABLE covid_cases (
    country VARCHAR(100),
    report_date DATE,
    confirmed_cases INT,
    deaths INT,
    recoveries INT,
    last_updated TIMESTAMP,
    PRIMARY KEY (country, report_date)
);
