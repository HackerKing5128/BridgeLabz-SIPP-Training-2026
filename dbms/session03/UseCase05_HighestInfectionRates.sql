-- Use Case 5: Find Countries with Highest Infection Rates
SELECT country_name,
       confirmed_cases,
       population,
       (confirmed_cases * 100.0 / population) AS infection_rate
FROM covid_cases
ORDER BY infection_rate DESC;
