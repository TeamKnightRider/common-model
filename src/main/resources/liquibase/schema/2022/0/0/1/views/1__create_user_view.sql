do $do$ begin if not exists (
select
	*
from
	information_schema.views
where
	table_name = N'v_user')

then if exists (
select
	*
from
	information_schema.tables
where
	table_name = 't_user' ) then if exists (
select
	*
from
	information_schema.tables
where
	table_name = 't_section')

then create view v_user as
select
	usr.rid as rid,
	usr.first_name as first_name,
	usr.last_name as last_name,
	usr.user_name as user_name,
	usr.age as age,
	email as email,
	usr.active,
	usr.deleted,
	sec.rid as section_rid,
	sec.name as section_name
from
	t_user usr
inner join t_section sec on
	usr.section_id = sec.rid;


end if;
end if;
end if;

end $do$
