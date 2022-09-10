do $$
declare section_rid varchar := 'sec-01';
begin
	if exists ( select *from information_schema.tables where table_name = N't_authority')
	then

		insert into t_authority (rid,created_on,"name")
		values ('auth-21080101',
		        '2021-08-01 00:00:00.000',
		        'CREATE'),

		        ('auth-21080102',
        		'2021-08-01 00:00:00.000',
       			'READ'),

       			('auth-21080103',
        		'2021-08-01 00:00:00.000',
        		'UPDATE'),

        		('auth-21080104',
		        '2021-08-01 00:00:00.000',
        		'DELETE');


end if;
end $$
