do 
$do$
begin 
if exists ( select
	*
from
	information_schema.tables
where
	table_name = N't_store')

then 

create or replace
view v_store as
select
	store.rid as rid,
	store.name as name,
	store.address_id as address_id,
	store.deleted
from
	t_store store;

end if;
end $do$
