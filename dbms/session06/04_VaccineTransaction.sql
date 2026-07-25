-- Create table (if it does not already exist)
CREATE TABLE IF NOT EXISTS vaccine_data (
    country VARCHAR(100),
    report_date DATE,
    vaccinated INT
);

-- Start Transaction
START TRANSACTION;

-- Insert vaccine distribution records
INSERT INTO vaccine_data (country, report_date, vaccinated)
VALUES ('India', '2021-05-01', 250000);

INSERT INTO vaccine_data (country, report_date, vaccinated)
VALUES ('USA', '2021-05-01', 300000);

-- Commit transaction
COMMIT;

-- Rollback Example
START TRANSACTION;

INSERT INTO vaccine_data (country, report_date, vaccinated)
VALUES ('India', '2021-05-02', 260000);

-- Undo the insertion
ROLLBACK;

-- Verify Data
SELECT * FROM vaccine_data;