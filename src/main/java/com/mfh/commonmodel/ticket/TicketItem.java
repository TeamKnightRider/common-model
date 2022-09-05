package com.mfh.commonmodel.ticket;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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

@Data
@NoArgsConstructor
@Entity
@Table(name = "tTicketItem")
@ToString(of = "name")
public class TicketItem implements Serializable {

  @Serial
  private static final long serialVersionUID = -3907666506348260076L;
  @Id
  @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
  @GenericGenerator(name = "customGenerator",
      strategy = CustomIdGenerator.CLASS_REFERENCE,
      parameters = {@Parameter(name = CustomIdGenerator.ENTITY_PREFIX, value = "t-itm-")})
  @Column(name = "rid", unique = true)
  private String rid;

  @Column(name = "createdOn", nullable = false)
  private LocalDateTime createdOn;

  @Column(name = "lastModified", nullable = false)
  private LocalDateTime lastModified;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "menuItemId", nullable = false)
  private String menuItemId;

  @Column(name = "taxIncluded", nullable = false)
  private boolean taxIncluded;

  @Column(name = "subtotalAmount", nullable = false)
  private double subtotalAmount;

  @Column(name = "totalAmount", nullable = false)
  private double totalAmount;

  @Column(name = "taxAmount", nullable = false)
  private double taxAmount;

  @Column(name = "discountAmount", nullable = false)
  private double discountAmount;

  @Column(name = "quantity", nullable = false)
  private double quantity;

  @Column(name = "unitPrice", nullable = false)
  private double unitPrice;

  @Column(name = "adjustedSubtotal", nullable = false)
  private double adjustedSubtotal;

  @Column(name = "adjustedTotal", nullable = false)
  private double adjustedTotal;

  @Column(name = "kitchenStatus")
  private String kitchenStatus;

  @Column(name = "printedToKitchen", nullable = false)
  private boolean printedToKitchen;

  @Column(name = "cookingInstructions")
  private String cookingInstructions;

  @Column(name = "deleted", nullable = false)
  private boolean deleted;

  @Column(name = "voided", nullable = false)
  private boolean voided;

  @Column(name = "taxGroupId")
  private String taxGroupId;

  @Column(name = "discountRuleId")
  private String discountRuleId;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "ticket", nullable = false, foreignKey = @ForeignKey(name = "FK_TICKET"))
  private Ticket ticket;
}
// <version name="version" column="VERSION_NO" type="long" />
// <property column="CREATE_DATE" name="createDate"
// type="com.montrosesoftware.dbassist.types.UtcDateType" />
// <property column="VOID_DATE" name="voidDate"
// type="com.montrosesoftware.dbassist.types.UtcDateType" />
// <property column="MENU_ITEM_ID" name="menuItemId" type="java.lang.String" length="128" />
