do 
$do$
begin 
if exists ( select
	*
from
	information_schema.tables
where
	table_name = N't_section')

then 

create or replace
view v_section as
select
	sec.rid as rid,
	sec.name as name,
	sec.store_id as store_id,
	sec.active,
	sec.deleted
from
	t_section sec;


end if;
end $do$
