-- Challenge 1: Create COVID Database Schema
CREATE DATABASE covid_db;
USE covid_db;

CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100),
    report_date DATE,
    report_time TIME,
    confirmed_cases INT,
    deaths INT,
    recoveries INT,
    population BIGINT
);
