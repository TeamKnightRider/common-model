package com.mfh.commonmodel.config;

import java.util.Arrays;

import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.boot.model.relational.Sequence;
import org.hibernate.mapping.Table;
import org.hibernate.tool.schema.spi.SchemaFilter;

public class MySchemaFilter implements SchemaFilter {

  public static final MySchemaFilter INSTANCE = new MySchemaFilter();
  private static final String[] viewTables = {"v_store", "v_section", "v_user", "v_role", "v_authority", "v_account"};

  @Override
  public boolean includeNamespace(Namespace namespace) {
    return true;
  }

  @Override
  public boolean includeTable(Table table) {
    return Arrays.stream(viewTables)
        .noneMatch(s -> s.equals(table.getName()));
  }

  @Override
  public boolean includeSequence(Sequence sequence) {
    return true;
  }
}
