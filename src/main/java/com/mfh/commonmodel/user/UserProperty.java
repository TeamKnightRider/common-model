package com.mfh.commonmodel.user;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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

@Data
@NoArgsConstructor
@Entity
@Table(name = "tUserProperty")
@ToString(of = "propertyType")
public class UserProperty implements Serializable {
  @Serial
  private static final long serialVersionUID = 1200466866674086996L;
  @Id
  @GeneratedValue(generator = "userPropIdGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "userPropIdGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "user-prop-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;

  @Enumerated
  @Column(name = "propertyType")
  private UserPropertyType userPropertyType;

  @Column(name = "propertyRid", nullable = false)
  private String propertyRid;
}
