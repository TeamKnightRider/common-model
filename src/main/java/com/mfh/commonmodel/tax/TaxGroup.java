package com.mfh.commonmodel.tax;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "tTaxGroup")
@ToString(of = "name")
@EqualsAndHashCode(callSuper = false)
public class TaxGroup implements Serializable {

  @Serial
  private static final long serialVersionUID = 771455566544352133L;

  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "tax-grp-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "lastModified", nullable = false)
  private LocalDateTime lastModified;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "totalTax", nullable = false)
  private double totalTax;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @Column(name = "sectionId", nullable = false)
  private String sectionId;

  //  @OneToMany(mappedBy = "taxGroup", fetch = FetchType.LAZY, orphanRemoval = true)
  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "taxGroupId", referencedColumnName = "rid")
  private Set<Tax> taxes;
}
