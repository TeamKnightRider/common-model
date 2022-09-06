package com.mfh.commonmodel.discount;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "tDiscountRule")
@ToString(of = "name")
public class DiscountRule implements Serializable {

  @Serial
  private static final long serialVersionUID = -6976051288877512133L;

  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "disRule-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @Column(name = "sectionId", nullable = false)
  private String sectionId;

  @OneToMany
  @JoinColumn(name = "discount_group_id",
      referencedColumnName = "rid",
      foreignKey = @ForeignKey(name = "FK_DISCOUNT_GROUP"))
  private List<DiscountGroup> discountGroups = new ArrayList<>();
}