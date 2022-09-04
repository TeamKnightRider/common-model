create or replace
view v_store as
select
	store.rid as rid,
	store.name as name,
	store.address_id as address_id,
	store.deleted
from
	t_store store;
