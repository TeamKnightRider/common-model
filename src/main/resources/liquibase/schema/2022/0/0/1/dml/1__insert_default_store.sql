do $$
   declare storeName varchar := 'Store';
begin
	if not exists(select * from t_store where name = storeName)
	then
    	insert into t_store (rid,created_on,deleted,"name")
		values ('store-1','2021-08-01 00:00:00.000',false,storeName);
	end if;
end$$;
