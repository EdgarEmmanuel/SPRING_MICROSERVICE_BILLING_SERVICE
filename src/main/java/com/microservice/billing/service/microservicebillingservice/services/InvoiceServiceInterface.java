package com.microservice.billing.service.microservicebillingservice.services;

import com.microservice.billing.service.microservicebillingservice.dto.InvoiceRequestDto;
import com.microservice.billing.service.microservicebillingservice.dto.InvoiceResponseDto;

import java.util.List;

public interface InvoiceServiceInterface {
    InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto);
    InvoiceResponseDto getInvoiceById(String id);
    List<InvoiceResponseDto> getAllInvoicesByCustomer(String customerId);
}
