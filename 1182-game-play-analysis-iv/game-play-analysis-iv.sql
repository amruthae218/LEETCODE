# Write your MySQL query statement below
select round(count(distinct(player_id))/(select count(distinct(player_id))from Activity),2) as fraction
from Activity A
where event_date=(select min(event_date)+ interval 1 day 
                    from Activity a1
                    where A.player_id=a1.player_id)
