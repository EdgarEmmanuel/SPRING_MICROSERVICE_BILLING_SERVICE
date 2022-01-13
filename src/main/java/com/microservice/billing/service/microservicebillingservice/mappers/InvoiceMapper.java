package com.microservice.billing.service.microservicebillingservice.mappers;

import com.microservice.billing.service.microservicebillingservice.dto.InvoiceRequestDto;
import com.microservice.billing.service.microservicebillingservice.dto.InvoiceResponseDto;
import com.microservice.billing.service.microservicebillingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice InvoiceFromInvoiceRequestDto(InvoiceRequestDto invoiceRequestDto);
    InvoiceResponseDto InvoiceResponseDtoFromInvoice(Invoice invoice);
}
