do 
$do$
begin 
if exists ( select
	*
from
	information_schema.tables
where
	table_name = N't_account')

then 

create or replace
view v_account as
select
	acc.rid as rid,
	acc.account_name as name,
	acc.created_on,
	acc.active,
	acc.credential_expire_date,
	acc.credential_expired,
	acc.expire_date,
	acc.expired,
	acc.locked,
	acc.deleted
from
	t_account acc;



end if;
end $do$
