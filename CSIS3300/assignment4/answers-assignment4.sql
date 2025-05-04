-------------------------------------------------------------------------------
------------------------------ ASSIGNMENT 04 ----------------------------------

USE BikeStores;
GO

---------------------------------
-------------- Q1 ---------------
---------------------------------
-- 1 --

--Use the PIVOT operator to create a pivot table 
--that displays the total sales of Mountain Bikes 
--and Electric Bikes 
--for the brands Sun Bicycles and Trek.


SELECT * 
FROM	(
			SELECT brand AS 'Brand', category, sales
			FROM sales.sales_summary
			WHERE brand IN ('Sun Bicycles', 'Trek')
		) AS t
PIVOT	(
			SUM(sales)
			FOR category IN ([Mountain Bikes], [Electric Bikes])
		) AS pivot_table;

-- 2 --

--Use the GROUP BY CUBE operator to obtain 
--the subtotals and grand total of quantity for model_year and category. 
--The stocks table stores the quantity of a particular product 
--(identified by product_id) in a specific store. 
--Use the COALESCE function properly to handle NULL values 
--(you need to use 'All years' to replace the NULL values in model_year).

SELECT	COALESCE(CAST(p.model_year AS VARCHAR), 'All years') AS 'model_year', 
		COALESCE(c.category_name, 'All categories') AS 'category_name',	
		SUM(s.quantity) AS 'total_qty'
FROM production.stocks AS s
JOIN production.products AS p ON (s.product_id = p.product_id)
JOIN production.categories AS c ON (p.category_id = c.category_id)
GROUP BY CUBE (p.model_year, c.category_name);

-- 3 --

--Use the PIVOT operator to create a pivot table 
--that displays the total quantity of Mountain Bikes 
--and Electric Bikes with the model year 2017 and 2018.

SELECT	Model_Year,
		[Mountain Bikes] AS 'Mountain', 
		[Electric Bikes] AS 'Electric'
FROM	(
			SELECT	p.model_year AS 'Model_Year', 
					c.category_name,	
					s.quantity
			FROM production.stocks AS s
			JOIN production.products AS p ON (s.product_id = p.product_id)
			JOIN production.categories AS c ON (p.category_id = c.category_id)
			WHERE c.category_name IN ('Mountain Bikes', 'Electric Bikes') 
					AND p.model_year IN (2017, 2018)
		) AS t
PIVOT	(
			SUM(quantity)
			FOR category_name IN ([Mountain Bikes], [Electric Bikes])
		) AS pivot_table;


---------------------------------
-------------- Q2 ---------------
---------------------------------

-- 1 --

--Create a clustered index named ix_summary_brand 
--on the brand column of the sales.sales_summary table.

CREATE CLUSTERED INDEX ix_summary_brand
	ON sales.sales_summary(brand);

-- 2 --

--Create a nonclustered index named ix_summary_cover 
--on the table such that it is a covering index for the following query 

--select	category, model_year, sales
--from	sales.sales_summary
--where	sales > 400000;

--and an index seek (nonclustered) operation 
--will be used in the execution plan.

CREATE NONCLUSTERED INDEX ix_summary_cover
	ON sales.sales_summary (sales, category, model_year)

select	category, model_year, sales
from	sales.sales_summary
where	sales > 400000;

-- 3 --
--Give the SQL statement to display the index information of the sales.sales_summary table. 
--Since the table name contains a dot character, quotation marks may be needed. 

EXEC SP_HELPINDEX 'sales.sales_summary';


---------------------------------
-------------- Q3 ---------------
---------------------------------
-- (MongoDB)
---------------------------------

-- 1 --

--Create a covering index named ix_cover for the following query such that IXSCAN is used.
-- db.cars.find( { type: "Truck" }, { model: 1, qty: 1, _id: 0 } )

db.cars.createIndex( { type: 1 }, {name: "ix_cover"} )


-- 2 --

--Compare the execution plans before and after creating the index 
--and briefly explain how the created index can improve the query performance.

-- Before the creation of the index, the query used collscan, 
-- which had to scan all documents in the collection, after the index creation, 
-- the execution plan changed to ixscan where only 2 documents had to be examined 
-- where the type was Truck.