package com.mfh.commonmodel.user.account;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mfh.commonmodel.core.CustomIdGenerator;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tAccount")
@ToString(of = "accountName")
public class Account implements Serializable {

  @Serial
  private static final long serialVersionUID = -4682557759360150675L;

  public static final String PROP_ACCOUNT_NAME = "accountName";
  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "acc-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  //    @Column(name = "salt")
  //    private String salt;

  @Column(name = "expireDate")
  private LocalDateTime expireDate;

  @Column(name = "credentialExpireDate")
  private LocalDateTime credentialExpireDate;

  @Column(name = "accountName", unique = true, nullable = false)
  private String accountName;

  @Column(name = "password", nullable = false)
  private char[] password;

  @Column(name = "active", nullable = false, columnDefinition = "bool default true")
  private boolean active;

  @Column(name = "locked", nullable = false, columnDefinition = "bool default false")
  private boolean locked;

  @Column(name = "expired", nullable = false, columnDefinition = "bool default false")
  private boolean expired;

  @Column(name = "credentialExpired", nullable = false, columnDefinition = "bool default true")
  private boolean credentialExpired;

  @Column(name = "deleted", nullable = false, columnDefinition = "bool default false")
  private boolean deleted;
}
