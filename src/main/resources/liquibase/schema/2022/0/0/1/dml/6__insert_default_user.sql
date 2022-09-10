do $$
declare ROLE_SUPER_ADMIN varchar := 'SUPER_ADMIN';
begin
	if exists ( select *from information_schema.tables where table_name = N't_roles_auths')
	then

		insert into t_account (rid,
				                created_on,
				                account_name,
				                "password",
				                active)
				values ('acct-01',
				        '2021-08-01 00:00:00.000',
				        'faysal',
				        '$2a$12$6uLoRZWDEvdZDJ6WZrSO9uy8eRzqtc7FBMaDpkLBKDTMvz9QzdbaC',
				        true
				     );

		insert into t_user (rid,
			             created_on,
			             user_name,
			             email,
			             first_name,
			             last_name,
			             uuid,
			             store_id,
			             account)
			values ('usr-001',
			        '2021-08-01 00:00:00.000',
			        'Faysal Hasan',
			        'mfh.faysal.0@gmail.com',
			        'Md. Faysal',
			        'Hasan',
			        '1234-5678-9090',
			        'store-1',
			        (select rid from t_account where rid = 'acct-01')
			        );

end if;
end $$
