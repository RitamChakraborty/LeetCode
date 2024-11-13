select name as Employee
from employee e1
where e1.managerId is not null
  and e1.salary > (select salary from employee where id = e1.managerId);