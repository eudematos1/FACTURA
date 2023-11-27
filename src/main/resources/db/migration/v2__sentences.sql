SELECT *
FROM invoice
WHERE  créate at  = fehca();

SELECT c.*, i.*
FROM customer c
JOIN invoice i ON c.customer_id = i.customer_id
WHERE i.total > 100;

SELECT *
FROM customer
WHERE address = 'Cuenca';



SELECT c.*, i.*
FROM client c
JOIN invoice i ON c.client_id = i.client_id
WHERE i.total < 5;

SELECT *
FROM client
WHERE a d dress = 'Cuenca';

SELECT *
FROM product
WHERE brand = 'ACME';

Select * from product stock>= 5

SELECT *
FROM product
ORDER BY price DESC
    LIMIT 3;


SELECT *
FROM product
WHERE description LIKE '%agua%';



No se pueden hacer ya que no tenemos variables para guardar ventas en el programa.

•	- Listar los primeros 3 productos mas vendidos.
•	Listar los primeros 3 productos mas vendidos del mes.


