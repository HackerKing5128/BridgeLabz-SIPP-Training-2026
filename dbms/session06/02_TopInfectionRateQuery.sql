-- Covering Index for Top Infection Rate Queries
CREATE INDEX idx_infection_rate
ON covid_cases(infection_rate, country, report_date);