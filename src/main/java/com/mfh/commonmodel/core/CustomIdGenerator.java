package com.mfh.commonmodel.core;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

public class CustomIdGenerator extends SequenceStyleGenerator {

  public static final String ENTITY_PREFIX = "Entity";
  public static final String CLASS_REFERENCE = "com.tkr.userservice.core.CustomIdGenerator";
  private String entityPrefix;

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

    long currentTimeMillis = System.currentTimeMillis();
    String idString = String.valueOf(currentTimeMillis);
    idString = idString.substring(idString.length() - 8);
    return entityPrefix + idString;
  }

  @Override
  public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
    super.configure(StringType.INSTANCE, params, serviceRegistry);
    this.entityPrefix = ConfigurationHelper.getString(ENTITY_PREFIX, params);
  }
}
