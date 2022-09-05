package com.mfh.commonmodel.ticket;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mfh.commonmodel.core.CustomIdGenerator;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tTicket")
@ToString(of = {"rid", "totalAmount"})
public class Ticket implements Serializable {

  @Serial
  private static final long serialVersionUID = 4769814701341545281L;
  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "tkt-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Version
  @Column(name = "version", nullable = false)
  private Long version;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "lastModified", nullable = false)
  private LocalDateTime lastModified;

  @Column(name = "tokenNo", nullable = false)
  private short tokenNo;

  @Column(name = "tableNo")
  private Short tableNo;

  @Column(name = "closedOn")
  private LocalDateTime closedOn;

  @Column(name = "taxIncluded", nullable = false)
  private boolean taxIncluded;

  @Column(name = "subtotalAmount", nullable = false)
  private double subtotalAmount;

  @Column(name = "totalAmount", nullable = false)
  private double totalAmount;

  @Column(name = "paidAmount", nullable = false)
  private double paidAmount;

  @Column(name = "taxAmount", nullable = false)
  private double taxAmount;

  @Column(name = "discountAmount", nullable = false)
  private double discountAmount;

  @Column(name = "voidAmount", nullable = false)
  private double voidAmount;

  @Column(name = "refundAmount", nullable = false)
  private double refundAmount;

  @Column(name = "refundableAmount", nullable = false)
  private double refundableAmount;

  @Column(name = "dueAmount", nullable = false)
  private double dueAmount;

  @Column(name = "serviceCharge", nullable = false)
  private double serviceCharge;

  @Column(name = "deliveryCharge", nullable = false)
  private double deliveryCharge;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "paid", nullable = false)
  private boolean paid;

  @Column(name = "voided", nullable = false)
  private boolean voided;

  @Column(name = "refunded", nullable = false)
  private boolean refunded;

  @Column(name = "closed", nullable = false)
  private boolean closed;

  @Column(name = "note")
  private String note;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @Column(name = "taxGroupId", nullable = false)
  private String taxGroupId;

  @Column(name = "discountRuleId")
  private String discountRuleId;

  @Column(name = "sectionId", nullable = false)
  private String sectionId;

  @Column(name = "terminalId", nullable = false)
  private String terminalId;

  // BI-DIRECTIONAL
  @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<TicketItem> ticketItems = new ArrayList<>();
}

