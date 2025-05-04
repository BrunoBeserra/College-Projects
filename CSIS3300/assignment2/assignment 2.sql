-------------------------------------------------------------------------------
------------------------------ ASSIGNMENT 02 ----------------------------------
-------------------------------------------------------------------------------

USE ABC_Dealership
GO;


-- 1 --

-- Find all the teams with the second highest total salary. 
-- Display the team name and the total salary of the team 
-- (give a proper column name) in the result. 

SELECT TOP (1) WITH TIES team_name, CAST(SUM(salary) AS NUMERIC(8, 2)) AS 'total_salary'
FROM Employee
WHERE salary IS NOT NULL AND team_name IS NOT NULL
GROUP BY team_name
HAVING SUM(salary) < (SELECT TOP 1 SUM(salary)
					  FROM Employee
					  GROUP BY team_name)
ORDER BY SUM(salary) DESC;

-- 2 --

-- Find the employees who earn the third lowest salary in their own teams. 
-- Display the team name and the employee name in alphabetical order of team name. 
-- Note: not all teams have employees with the third lowest salary, 
-- and the employee name should display 'N/A' in this case.

WITH salary_ranking AS
(
	SELECT name,
	team_name,
	salary,
	DENSE_RANK() OVER (PARTITION BY team_name ORDER BY salary ASC) AS
	'ranked_by_team'
	FROM Employee
)
SELECT s.team_name,
CASE WHEN name IS NULL THEN 'N/A' ELSE name END AS 'employee_name'
FROM (SELECT DISTINCT team_name FROM Employee) AS s
LEFT JOIN salary_ranking ON (s.team_name = salary_ranking.team_name AND ranked_by_team = 3);

-- 3 --

-- Find the employees who made at least one sale in three consecutive months in 2024. 
-- The employees who made at least one sale in four consecutive months 
-- and above should NOT be included. Display employee name and team name in the result 
-- and remove duplicate rows if applicable. You must use the ROW_NUMBER () function.

WITH monthly_sales AS (
	SELECT employee_id,
	MONTH(sale_date) AS sale_month,
	ROW_NUMBER() OVER (PARTITION BY employee_id ORDER BY MONTH(sale_date))
	AS month_number
	FROM Sale
	WHERE YEAR(sale_date) = 2024
	GROUP BY employee_id, MONTH(sale_date)
),
consecutive_month AS
(
	select employee_id,
	sale_month,
	(sale_month - month_number) AS date_group
	FROM monthly_sales
)
SELECT DISTINCT name,
				team_name
FROM consecutive_month
JOIN Employee ON (Employee.employee_id = consecutive_month.employee_id)
GROUP BY name, date_group, team_name
HAVING count(*) = 3
ORDER BY name;




























































