-- Composite Index on Country and Date
CREATE INDEX idx_country_date
ON covid_cases(country, report_date);

-- Single Column Index on Date
CREATE INDEX idx_report_date
ON covid_cases(report_date);