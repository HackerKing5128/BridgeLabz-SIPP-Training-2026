-- Use Case 3: Add Constraints to Ensure Data Quality
CREATE TABLE covid_cases (
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL,
    deaths INT,
    recoveries INT,
    CHECK (deaths <= confirmed_cases)
);
