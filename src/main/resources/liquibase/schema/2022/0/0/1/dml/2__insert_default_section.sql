do $$
   declare sectionName varchar := 'Section';
   declare storeId varchar := 'store-1';
begin
	if not exists(select * from t_section where name = sectionName)
	then
		if exists(select * from t_store where rid = storeId)
		then
    		insert into t_section (rid,"name",store_id)
			values ('section-01',sectionName, storeId);
	    end if;
	end if;
end$$;
