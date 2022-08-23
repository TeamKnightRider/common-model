package com.mfh.commonmodel.user;

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
@Table(name = "tUserSession")
@ToString(of = {"name", "loggedInTime", "loggedOutTime"})
public class UserSession implements Serializable {

  @Serial
  private static final long serialVersionUID = -3214866757333752291L;
  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "us-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "userId", nullable = false)
  private String userId;

  @Column(name = "loggedInTime", nullable = false)
  private LocalDateTime loggedInTime;

  @Column(name = "loggedOutTime")
  private LocalDateTime loggedOutTime;
}
