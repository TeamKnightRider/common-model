do 
$do$
begin 
if exists ( select
	*
from
	information_schema.tables
where
	table_name = N't_authority')

then 

create or replace
view v_authority as
select
	auth.rid as rid,
	auth.name as name,
	auth.active,
	auth.deleted
from
	t_authority auth;


end if;
end $do$
