select name as Customers
from customers c
where (select count(*) from orders where customerId = c.id) = 0;