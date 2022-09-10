package com.mfh.commonmodel.discount;

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
@Table(name = "tDiscount")
@ToString(of = "name")
public class Discount implements Serializable {

  @Serial
  private static final long serialVersionUID = -4502615689431873774L;
  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "dis-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "amount", nullable = false)
  private double amount;

  @Column(name = "type", nullable = false)
  private String type; // percentage || amount

  @Column(name = "expiryDate")
  private LocalDateTime expiryDate;

  @Column(name = "active", nullable = false, columnDefinition = "bool default true")
  private boolean active;

  @Column(name = "deleted", nullable = false, columnDefinition = "bool default false")
  private boolean deleted;

  @Column(name = "discountGroupId", nullable = false)
  private String discountGroupId;
}
