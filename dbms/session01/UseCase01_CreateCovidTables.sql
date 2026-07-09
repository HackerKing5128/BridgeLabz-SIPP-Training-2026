-- Use Case 1: Create COVID Database Schema
CREATE TABLE covid_cases (
    country VARCHAR(100),
    report_date DATE,
    confirmed_cases INT,
    deaths INT,
    recoveries INT,
    population BIGINT
);

CREATE TABLE covid_deaths (
    country VARCHAR(100),
    report_date DATE,
    deaths INT
);

CREATE TABLE covid_vaccines (
    country VARCHAR(100),
    report_date DATE,
    vaccination_rate FLOAT
);
