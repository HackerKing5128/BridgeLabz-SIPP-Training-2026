-- Use Case 2: Insert Initial COVID Data
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('India', '2020-03-15', 100, 2, 50, 1380004385),
('India', '2020-03-16', 150, 3, 70, 1380004385),
('USA', '2020-03-15', 200, 5, 90, 331002651),
('USA', '2020-03-16', 260, 6, 110, 331002651),
('UK', '2020-03-15', 80, 1, 30, 67886011),
('UK', '2020-03-16', 120, 2, 45, 67886011);
