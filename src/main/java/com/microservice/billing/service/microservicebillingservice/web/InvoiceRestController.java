package com.microservice.billing.service.microservicebillingservice.web;

import com.microservice.billing.service.microservicebillingservice.dto.InvoiceRequestDto;
import com.microservice.billing.service.microservicebillingservice.dto.InvoiceResponseDto;
import com.microservice.billing.service.microservicebillingservice.services.InvoiceServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {

    private InvoiceServiceInterface invoiceServiceInterface;


    public InvoiceRestController(InvoiceServiceInterface invoiceServiceInterface){
        this.invoiceServiceInterface = invoiceServiceInterface;
    }

    @GetMapping(path = "/invoice/{id}")
    public InvoiceResponseDto getOneInvoice(@PathVariable(name = "id") String invoiceId){
        return this.invoiceServiceInterface.getInvoiceById(invoiceId);
    }


    @GetMapping(path = "/invoices/{customerId}")
    public List<InvoiceResponseDto> getAllCustomerInvoices(
            @PathVariable(name = "customerId") String customerId){

        return this.invoiceServiceInterface.getAllInvoicesByCustomer(customerId);

    }

    @PostMapping(path = "/invoice/save", consumes = "application/json")
    public InvoiceResponseDto saveOneInvoice(@RequestBody InvoiceRequestDto invoiceRequestDto){
        return this.invoiceServiceInterface.save(invoiceRequestDto);
    }

}
