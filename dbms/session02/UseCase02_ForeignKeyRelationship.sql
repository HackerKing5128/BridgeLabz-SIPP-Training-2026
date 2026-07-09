-- Use Case 2: Create Foreign Key Relationships
CREATE TABLE countries (
    country_id INT PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL
);

CREATE TABLE covid_cases (
    case_id INT PRIMARY KEY,
    country_id INT,
    report_date DATE,
    confirmed_cases INT,
    deaths INT,
    FOREIGN KEY (country_id) REFERENCES countries(country_id)
);
