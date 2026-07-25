DELIMITER $$

CREATE TRIGGER BeforeCovidUpdate
BEFORE UPDATE
ON covid_cases
FOR EACH ROW
BEGIN

    INSERT INTO covid_audit(
        country,
        report_date,
        old_confirmed,
        new_confirmed,
        old_deaths,
        new_deaths,
        old_recovered,
        new_recovered
    )
    VALUES(
        OLD.country,
        OLD.report_date,
        OLD.confirmed,
        NEW.confirmed,
        OLD.deaths,
        NEW.deaths,
        OLD.recovered,
        NEW.recovered
    );

END $$

DELIMITER ;