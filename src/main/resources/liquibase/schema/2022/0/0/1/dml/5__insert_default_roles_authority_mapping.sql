do $$
declare ROLE_SUPER_ADMIN varchar := 'SUPER_ADMIN';
declare ROLE_ADMIN varchar := 'ADMIN';

declare AUTH_CREATE varchar := 'CREATE';
declare AUTH_READ varchar := 'READ';
declare AUTH_UPDATE varchar := 'UPDATE';
declare AUTH_DELETE varchar := 'DELETE';
begin 
	if exists ( select *from information_schema.tables where table_name = N't_roles_auths')
	then 

		insert into t_roles_auths (role_id, auth_id)
		values ((select rid from t_role where name = ROLE_SUPER_ADMIN), (
		    select rid
		    from t_authority
		    where name = AUTH_CREATE)),
		    
		    ((select rid from t_role where name = ROLE_SUPER_ADMIN), (
		    select rid
		    from t_authority
		    where name = AUTH_READ)),
		    
		    ((select rid from t_role where name = ROLE_SUPER_ADMIN), (
		    select rid
		    from t_authority
		    where name = AUTH_UPDATE)),
		    
		    ((select rid from t_role where name = ROLE_SUPER_ADMIN), (
		    select rid
		    from t_authority
		    where name = AUTH_DELETE)),
		    
		    ((select rid from t_role where name = ROLE_ADMIN), (
		    select rid
		    from t_authority
		    where name = AUTH_CREATE)),
		    
		    ((select rid from t_role where name = ROLE_ADMIN), (
		    select rid
		    from t_authority
		    where name = AUTH_READ)),
		    
		    ((select rid from t_role where name = ROLE_ADMIN), (
		    select rid
		    from t_authority
		    where name = AUTH_UPDATE)),
		    
		    ((select rid from t_role where name = ROLE_ADMIN), (
		    select rid
		    from t_authority
		    where name = AUTH_DELETE));

 
end if;
end $$
