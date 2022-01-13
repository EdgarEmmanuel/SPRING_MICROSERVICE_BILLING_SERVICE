package com.microservice.billing.service.microservicebillingservice.services;

import com.microservice.billing.service.microservicebillingservice.dto.InvoiceRequestDto;
import com.microservice.billing.service.microservicebillingservice.dto.InvoiceResponseDto;
import com.microservice.billing.service.microservicebillingservice.entities.Customer;
import com.microservice.billing.service.microservicebillingservice.entities.Invoice;
import com.microservice.billing.service.microservicebillingservice.mappers.InvoiceMapper;
import com.microservice.billing.service.microservicebillingservice.openfeign.CustomerServiceRestClient;
import com.microservice.billing.service.microservicebillingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImplementation implements InvoiceServiceInterface{
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerServiceRestClient customerServiceRestClient;

    public InvoiceServiceImplementation(InvoiceRepository invoiceRepository,
                                        InvoiceMapper invoiceMapper,
                                        CustomerServiceRestClient customerServiceRestClient){
        this.invoiceRepository = invoiceRepository;
        this.customerServiceRestClient = customerServiceRestClient;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto) {

        Invoice invoiceToSave = this.invoiceMapper.InvoiceFromInvoiceRequestDto(invoiceRequestDto);

        invoiceToSave.setId(UUID.randomUUID().toString());
        invoiceToSave.setDate(new Date());

        Invoice savedInvoice = this.invoiceRepository.save(invoiceToSave);

        return this.invoiceMapper.InvoiceResponseDtoFromInvoice(savedInvoice);

    }

    @Override
    public InvoiceResponseDto getInvoiceById(String id) {

        Invoice findedInvoice = this.invoiceRepository.findById(id).get();

        Customer customer = this.customerServiceRestClient.getOneCustomerById(findedInvoice.getCustomerId());

        findedInvoice.setCustomer(customer);

        return this.invoiceMapper.InvoiceResponseDtoFromInvoice(findedInvoice);

    }

    @Override
    public List<InvoiceResponseDto> getAllInvoicesByCustomer(String customerId) {
        List<Invoice> invoices = this.invoiceRepository.findByCustomerId(customerId);
        return invoices.stream().map(invoice ->
            this.invoiceMapper.InvoiceResponseDtoFromInvoice(invoice)
        ).collect(Collectors.toList());
    }
}
