-- Challenge 4: Delete Incorrect Records
USE covid_db;

DELETE FROM covid_cases
WHERE country = 'IN';
