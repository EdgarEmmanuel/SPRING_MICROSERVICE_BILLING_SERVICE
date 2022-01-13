package com.microservice.billing.service.microservicebillingservice.repositories;

import com.microservice.billing.service.microservicebillingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    List<Invoice> findByCustomerId(String id);
}
