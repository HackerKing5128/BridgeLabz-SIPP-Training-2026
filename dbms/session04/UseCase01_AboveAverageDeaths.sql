SELECT country, death_count
FROM covid_deaths
WHERE death_count >
(
    SELECT AVG(death_count)
    FROM covid_deaths
);