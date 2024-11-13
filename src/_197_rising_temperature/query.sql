Select a.id as id
from weather a,
     weather b
where a.recordDate = date_add(b.recordDate, interval +1 day)
  and a.temperature > b.temperature;