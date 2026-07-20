SELECT country,
       vaccinated_population AS population,
       'Vaccinated' AS status
FROM covid_vaccination

UNION

SELECT country,
       unvaccinated_population,
       'Unvaccinated'
FROM covid_vaccination;