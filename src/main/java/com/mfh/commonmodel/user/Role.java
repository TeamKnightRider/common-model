package com.mfh.commonmodel.user;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mfh.commonmodel.core.CustomIdGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tRole")
@ToString(of = "name")
@EqualsAndHashCode(exclude = {"authorities"})
public class Role implements Serializable {

  @Serial
  private static final long serialVersionUID = -613347101865620474L;
  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "role-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @JsonIgnore
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "tRoles_auths",
      joinColumns = {@JoinColumn(name = "roleId")},
      inverseJoinColumns = {@JoinColumn(name = "authId")})
  private Set<Authority> authorities = new HashSet<>();
}
