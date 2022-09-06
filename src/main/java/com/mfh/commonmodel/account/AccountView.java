package com.mfh.commonmodel.account;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.Immutable;

@Data
@NoArgsConstructor
@Immutable
@Entity
@Table(name = "vAccount")
@ToString(of = "accountName")
public class AccountView implements Serializable {

  @Serial
  private static final long serialVersionUID = -6002906031495302386L;
  @Id
  private String rid;

  private LocalDateTime expireDate;

  private LocalDateTime credentialExpireDate;

  private String name;

  private boolean active;

  private boolean locked;

  private boolean expired;

  private boolean credentialExpired;

  private boolean deleted;
}
