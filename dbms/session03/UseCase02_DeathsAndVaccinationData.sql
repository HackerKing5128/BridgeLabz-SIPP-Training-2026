-- Use Case 2: Join COVID Deaths and Vaccination Data
SELECT d.country_name, d.death_count, v.vaccination_status
FROM covid_deaths d
LEFT JOIN covid_vaccines v ON d.country_id = v.country_id;
