package com.mfh.commonmodel.unit;

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
@Table(name = "tUnit")
@ToString(of = "name")
public class Unit implements Serializable {
  @Serial
  private static final long serialVersionUID = 6908803069646398812L;

  @Id
  @GeneratedValue(generator = "unitIdGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "unitIdGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "unit-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "base", nullable = false)
  private boolean baseUnit;

  @Column(name = "rate", nullable = false)
  private double rate;

  @Column(name = "conversionRate", nullable = false)
  private double conversionRate;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @Column(name = "unitGroupId", nullable = false)
  private String unitGroupId;
}
