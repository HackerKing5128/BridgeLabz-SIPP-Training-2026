-- Use Case 5: Prevent Duplicate Country-Date Entries
CREATE TABLE covid_cases (
    country VARCHAR(100),
    report_date DATE,
    confirmed_cases INT,
    deaths INT,
    UNIQUE (country, report_date)
);
