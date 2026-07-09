-- Use Case 4: Calculate Average New Deaths Per Day
SELECT report_date, AVG(new_deaths) AS average_new_deaths
FROM covid_cases
GROUP BY report_date
ORDER BY report_date;
