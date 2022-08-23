package com.mfh.commonmodel.address;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mfh.commonmodel.core.CustomIdGenerator;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tAddress")
public class Address implements Serializable {

  @Serial
  private static final long serialVersionUID = 4945045218085546105L;

  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "add-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "ownerId", unique = true, nullable = false)
  private String ownerId;

  @Column(name = "address1")
  private String address1;

  @Column(name = "address2")
  private String address2;

  @Column(name = "address3")
  private String address3;

  @Column(name = "address4")
  private String address4;

  @Column(name = "address5")
  private String address5;

  @Column(name = "address6")
  private String address6;

  @Column(name = "address7")
  private String address7;

  @Column(name = "address8")
  private String address8;

  @Column(name = "address9")
  private String address9;

  @Column(name = "address10")
  private String address10;
}
