package com.mfh.commonmodel.config;

import org.hibernate.tool.schema.internal.DefaultSchemaFilter;
import org.hibernate.tool.schema.spi.SchemaFilter;
import org.hibernate.tool.schema.spi.SchemaFilterProvider;

//https://stackoverflow.com/questions/6212144/how-to-disable-schema-validation-in-hibernate-for-certain-entities
public class MySchemaFilterProvider implements SchemaFilterProvider {

  @Override
  public SchemaFilter getCreateFilter() {
    return DefaultSchemaFilter.INSTANCE;
  }

  @Override
  public SchemaFilter getDropFilter() {
    return DefaultSchemaFilter.INSTANCE;
  }

  @Override
  public SchemaFilter getMigrateFilter() {
    return MySchemaFilter.INSTANCE;
  }

  @Override
  public SchemaFilter getValidateFilter() {
    return DefaultSchemaFilter.INSTANCE;
  }
}
