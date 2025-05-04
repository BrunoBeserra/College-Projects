-------------------------------------------------------------------------------
------------------------------ ASSIGNMENT 01 ----------------------------------
-------------------------------------------------------------------------------

USE university
GO;

-- 1 --

--Find the ID and name of instructors who taught at least one course in their own department 
--and at least one course in a different department. 
--Remove duplicate rows in the results.

SELECT i.ID, i.name
FROM instructor AS i
JOIN teaches AS t ON (i.ID = t.ID)
JOIN course AS c ON (t.course_id = c.course_id)
WHERE i.dept_name = c.dept_name
INTERSECT
SELECT i.ID, i.name
FROM instructor AS i
JOIN teaches AS t ON (i.ID = t.ID)
JOIN course AS c ON (t.course_id = c.course_id)
WHERE i.dept_name <> c.dept_name;


-- 2 --

--Find the number of distinct students who took at least one course together 
--with the student with the ID 10269 in the year 2006.

WITH specific_courses (course_id, sec_id,semester, year) AS
(
	SELECT DISTINCT course_id, sec_id, semester, year
	FROM takes
	WHERE ID = '10269'
	AND year = 2006
)
SELECT COUNT(DISTINCT student.ID) AS 'number_of_students'
FROM student
JOIN takes ON (student.ID = takes.ID)
JOIN specific_courses ON (specific_courses.course_id = takes.course_id
						  AND specific_courses.semester = takes.semester
						  AND specific_courses.sec_id = takes.sec_id
						  AND specific_courses.year = takes.year)
WHERE student.ID <> '10269';


-- 3 --

--Find all the departments with the fewest active students in the year 2005. 
--An active student in a year means the student takes at least one course in that year. 
--The result should display the department name and the number of active students. 
--Please note that each active student should be counted only once.

SELECT TOP (1) WITH TIES student.dept_name, COUNT(DISTINCT student.ID) AS 'active_students'
FROM student
JOIN takes ON (student.ID = takes.ID)
WHERE year = 2005
GROUP BY student.dept_name
ORDER BY COUNT(DISTINCT student.ID) ASC;


-- 4 --

--For each instructor who has taught the same course at least twice, 
--show the instructor’s name and the title of each course taught by the instructor at least twice. 
--Sort the result by the name in ascending order first and then by the title in ascending order.

SELECT DISTINCT i.name, c.title
FROM instructor AS i
JOIN teaches AS t ON (i.ID = t.ID)
JOIN course AS c ON (t.course_id = c.course_id)
WHERE c.course_id IN   (SELECT c.course_id
						FROM instructor AS i
						JOIN teaches AS t ON (i.ID = t.ID)
						JOIN course AS c ON (t.course_id = c.course_id)
						GROUP BY i.name, c.course_id
						HAVING COUNT(c.course_id) >= 2)
ORDER BY i.name ASC, c.title ASC;


-- 5 --

--Update the salaries of the instructors as follows 
--and display the total salary of all instructors after the update.

--1) Increase salary by 5% for the instructors who taught at least 3 different courses 
--(different course_id);
--2) Increase salary by 3.5% for the instructors who taught exactly 2 different courses;
--3) Increase salary by 1.5% for other instructors (including the instructors who did not teach).
--Please use BEGIN TRAN and ROLLBACK properly to update the salaries 
--and display the total salary of all the instructors after the update 
--(CREATE VIEW is not allowed to use; you may use the WITH clause within BEGIN TRAN and ROLLBACK).
--You must use the CASE expression in the UPDATE statement.

BEGIN TRAN;

UPDATE instructor
SET salary = CASE
	WHEN cc.number_of_courses > 2 THEN salary * 1.05
	WHEN cc.number_of_courses = 2 THEN salary * 1.035
	ELSE salary * 1.015
END
FROM instructor
LEFT JOIN (
	SELECT DISTINCT ID, COUNT(DISTINCT course_id) AS 'number_of_courses'
	FROM teaches
	GROUP BY ID
	) AS cc ON (cc.ID = instructor.ID);
SELECT SUM(salary) AS 'total_salary'
FROM instructor;

ROLLBACK;








































