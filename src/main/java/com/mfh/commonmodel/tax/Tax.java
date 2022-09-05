package com.mfh.commonmodel.tax;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mfh.commonmodel.core.CustomIdGenerator;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tTax")
@ToString(of = "name")
@EqualsAndHashCode(callSuper = false)
public class Tax implements Serializable {

  @Serial
  private static final long serialVersionUID = 6001636173826906949L;

  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "tax-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "rate", nullable = false)
  private double rate;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @Column(name = "taxGroupId", nullable = false)
  private String taxGroupId;
  //  @JsonIgnore
  //  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  //  @JoinColumn(name = "taxGroup", nullable = false, foreignKey = @ForeignKey(name =
  // "FK_TAX_GROUP"))
  //  private TaxGroup taxGroup;
}
