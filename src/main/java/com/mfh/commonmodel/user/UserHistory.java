package com.mfh.commonmodel.user;

import java.io.Serial;
import java.io.Serializable;

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
@Table(name = "tUserHistory")
@ToString(of = {"userId", "details"})
public class UserHistory implements Serializable {

  @Serial
  private static final long serialVersionUID = 2753828099596917794L;
  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "usr-hist-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "userId", nullable = false)
  private String userId;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "details", nullable = false)
  private String details;
}
