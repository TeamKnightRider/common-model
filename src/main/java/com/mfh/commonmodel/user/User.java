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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mfh.commonmodel.core.CustomIdGenerator;
import com.mfh.commonmodel.section.Section;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tUser")
@ToString(of = "userName")
public class User implements Serializable {

  @Serial
  private static final long serialVersionUID = 2482050672031091709L;

  @Id
  @GeneratedValue(generator = "userIdGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "userIdGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "user-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "uuid", nullable = false)
  private String uuid;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "userName", nullable = false)
  private String userName;

  @Column(name = "email", nullable = false)
  private String email;

  //  https://stackoverflow.com/questions/2069541/postgresql-jdbc-and-streaming-blobs

  //  @Enumerated(EnumType.STRING)
  // URL: which enum is good int or string
  // https://thorben-janssen.com/hibernate-enum-mappings/#:~:text=With%20Hibernate%2C%20you%20can%20map,you%20prefer%20its%20ordinal%20value.
  @Enumerated
  @Column(name = "gender")
  private Gender gender;

  @Column(name = "age")
  private Byte age;

  @Column(name = "active")
  private boolean active;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "sectionId", nullable = false)
  private Section section;
}
