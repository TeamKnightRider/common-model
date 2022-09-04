create or replace
view v_role as
select
	role.rid as rid,
	role.name as name,
	role.active,
	role.deleted
from
	t_role role;

