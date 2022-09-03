package com.mfh.commonmodel.section;

import java.io.Serial;
import java.io.Serializable;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mfh.commonmodel.core.CustomIdGenerator;
import com.mfh.commonmodel.store.Store;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tSection")
@ToString(of = "name")
public class Section implements Serializable {

  @Serial
  private static final long serialVersionUID = 1973877929166509952L;
  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "section-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @ManyToOne
  @JoinColumn(name = "storeId", nullable = false)
  private Store store;
}
