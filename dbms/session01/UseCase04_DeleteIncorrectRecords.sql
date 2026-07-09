-- Use Case 4: Delete Incorrect Records
DELETE FROM covid_cases
WHERE country = 'IN';

DELETE FROM covid_cases
WHERE country = 'India'
  AND report_date = '2020-03-15'
  AND confirmed_cases = 120;
