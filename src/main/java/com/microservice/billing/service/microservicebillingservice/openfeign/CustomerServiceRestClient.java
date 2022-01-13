package com.microservice.billing.service.microservicebillingservice.openfeign;

import com.microservice.billing.service.microservicebillingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceRestClient {

    @GetMapping(path = "/api/customers/{id}")
    Customer getOneCustomerById(@PathVariable(name = "id")  String id);

    @GetMapping(path = "/api/customers")
    List<Customer> getAllCustomers();

}
