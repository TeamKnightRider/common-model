do 
$do$
begin 
if exists ( select
	*
from
	information_schema.tables
where
	table_name = N't_role')

then 

create or replace
view v_role as
select
	role.rid as rid,
	role.name as name,
	role.active,
	role.deleted
from
	t_role role;




end if;
end $do$
