package com.mfh.commonmodel.user;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.Immutable;

@Data
@NoArgsConstructor
@Immutable
@Entity
@Table(name = "vUser")
@ToString(of = "userName")
public class UserView implements Serializable {

  @Serial
  private static final long serialVersionUID = 2482050672031091709L;

  @Id
  private String rid;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "userName", nullable = false)
  private String userName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "age")
  private Byte age;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @Column(name = "sectionName", nullable = false)
  private String sectionName;
}
