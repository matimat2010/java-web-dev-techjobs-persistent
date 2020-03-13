## Part 1: Test it with SQL
select column_name, data_type
  from information_schema.columns
 where table_name = 'job';

## Part 2: Test it with SQL
SELECT name FROM techjobs.employer
where location = 'St Louis';
## Part 3: Test it with SQL
DROP TABLE job;
## Part 4: Test it with SQL
Select name, description
from skill
where id in (select skills_id from job_skills where skills_id is not null)
order by name;