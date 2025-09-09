# Write your MySQL query statement below
select round(avg(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END
)*100,2) as immediate_percentage
from Delivery d
join(
    select min(order_date) as min_order_date, customer_id
    from delivery
    GROUP BY customer_id
) c
on d.customer_id=c.customer_id and d.order_date = c.min_order_date;