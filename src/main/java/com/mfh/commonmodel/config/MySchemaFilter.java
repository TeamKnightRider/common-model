package com.mfh.commonmodel.config;

import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.boot.model.relational.Sequence;
import org.hibernate.mapping.Table;
import org.hibernate.tool.schema.spi.SchemaFilter;

public class MySchemaFilter implements SchemaFilter {

  public static final MySchemaFilter INSTANCE = new MySchemaFilter();

  @Override
  public boolean includeNamespace(Namespace namespace) {
    return true;
  }

  @Override
  public boolean includeTable(Table table) {
    return !table.getName()
        .contains("v_user");
  }

  @Override
  public boolean includeSequence(Sequence sequence) {
    return true;
  }
}
