package com.mfh.commonmodel.currency;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.mfh.commonmodel.store.Store;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tCurrency")
@ToString(of = {"name", "code"})
public class Currency implements Serializable {

  @Serial
  private static final long serialVersionUID = -5511580698651895220L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rid")
  private int rid;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "symbol", nullable = false)
  private String symbol;

  @Column(name = "defaultCurrency", nullable = false)
  private boolean defaultCurrency;

  @ManyToOne
  @JoinColumn(name = "storeId", nullable = false)
  private Store store;

  @Column(name = "active", nullable = false, columnDefinition = "bool default true")
  private boolean active;

  @Column(name = "deleted", nullable = false, columnDefinition = "bool default false")
  private boolean deleted;
}
