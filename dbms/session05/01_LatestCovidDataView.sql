DELIMITER $$

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(6,2)
DETERMINISTIC
BEGIN
    DECLARE mortality DECIMAL(6,2);

    SELECT (deaths * 100.0) / confirmed
    INTO mortality
    FROM covid_cases
    WHERE country = p_country
      AND report_date = p_date;

    RETURN mortality;
END $$

DELIMITER ;