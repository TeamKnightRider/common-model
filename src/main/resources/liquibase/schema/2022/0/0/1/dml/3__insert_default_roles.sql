do $$
declare section_rid varchar := 'sec-01';
begin
	if exists ( select *from information_schema.tables where table_name = N't_role')
	then

		insert into t_role (rid, created_on, section_id, "name")
		values ('role-21080101',
		        '2021-08-01 00:00:00.000',
		        section_rid,
		        'SUPER_ADMIN'),

		        ('role-21080102',
		        '2021-08-01 00:00:00.000',
		        'sec-01',
		        'ADMIN'),

		        ('role-21080103',
		        '2021-08-01 00:00:00.000',
		        'sec-01',
		        'MANAGER'),

		        ('role-21080104',
		        '2021-08-01 00:00:00.000',
		        'sec-01',
		        'AGENT'),

		        ('role-21080105',
		        '2021-08-01 00:00:00.000',
		        'sec-01',
		        'JUNIOR_AGENT'),

		        ('role-21080106',
		        '2021-08-01 00:00:00.000',
		        'sec-01',
		        'USER'),

		        ('role-21080107',
				'2021-08-01 00:00:00.000',
				'sec-01',
				'CUSTOMER');

end if;
end $$
