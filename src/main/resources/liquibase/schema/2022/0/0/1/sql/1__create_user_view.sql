do $do$ begin if not exists (
select
	*
from
	information_schema.views
where
	table_name = N'v_user') then

	create view v_user as
select
	usr.first_name as first_name,
	usr.last_name as last_name,
	usr.user_name as user_name,
	email as email,
	usr.active,
	usr.deleted,
	sec.name as section_name

		from t_user usr

		inner join t_section sec on
		usr.section_id = sec.rid;

end if;
end $do$
