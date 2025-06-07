package com.naim.ecommerce.payment;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment")
public class Payment {

  @Getter
  @Id
  @GeneratedValue
  private Integer id;

  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  private PaymentMethod paymentMethod;

  private Integer orderId;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(insertable = false)
  private LocalDateTime lastModifiedDate;


  public Integer getId() {
    return id;
  }

  // Private constructor (only accessible via Builder)
  private Payment(Builder builder) {
    this.id = Integer.valueOf(builder.id);
    this.paymentMethod = PaymentMethod.valueOf(builder.paymentMethod);
    this.amount = builder.amount;
    this.orderId = Integer.valueOf(builder.orderId);
  }

  // Static builder() method
  public static Builder builder() {
    return new Builder();
  }

  // Getters (omitted for brevity)

  // Builder class
  public static class Builder {
    private String id;
    private String paymentMethod;
    private BigDecimal amount;
    private String orderId;

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder paymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
    }

    public Builder amount(BigDecimal amount) {
      this.amount = amount;
      return this;
    }

    public Builder orderId(String orderId) {
      this.orderId = orderId;
      return this;
    }

    public Payment build() {
      return new Payment(this);
    }

  }
}
