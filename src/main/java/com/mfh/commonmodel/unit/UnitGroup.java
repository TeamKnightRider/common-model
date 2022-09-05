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
@Table(name = "tUnitGroup")
@ToString(of = "name")
public class UnitGroup implements Serializable {

  @Serial
  private static final long serialVersionUID = 3359243563224227728L;

  @Id
  @GeneratedValue(generator = "unitGroupIdGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "unitGroupIdGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "un-grp-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @Column(name = "sectionId", nullable = false)
  private String sectionId;
}
