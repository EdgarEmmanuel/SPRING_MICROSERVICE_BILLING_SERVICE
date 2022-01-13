package com.microservice.billing.service.microservicebillingservice.dto;

import com.microservice.billing.service.microservicebillingservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequestDto {
    private BigDecimal amount;
    private String customerId;
}
