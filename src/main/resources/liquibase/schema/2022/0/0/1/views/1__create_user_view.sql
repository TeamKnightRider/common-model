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
	table_name = 't_store')

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
	store.rid as store_rid,
	store.name as store_name
from
	t_user usr
inner join t_store store on
	usr.store_id = store.rid;


end if;
end if;
end if;

end $do$
