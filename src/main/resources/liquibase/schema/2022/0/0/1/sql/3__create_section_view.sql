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
