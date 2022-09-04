create or replace
view v_authority as
select
	auth.rid as rid,
	auth.name as name,
	auth.active,
	auth.deleted
from
	t_authority auth;
