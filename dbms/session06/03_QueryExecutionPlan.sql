EXPLAIN
SELECT c.country,
       c.confirmed,
       v.vaccinated
FROM covid_cases c
JOIN vaccine_data v
ON c.country = v.country
WHERE c.report_date = '2021-05-01';