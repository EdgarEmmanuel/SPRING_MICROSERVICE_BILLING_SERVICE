package com.microservice.billing.service.microservicebillingservice;

import com.microservice.billing.service.microservicebillingservice.dto.InvoiceRequestDto;
import com.microservice.billing.service.microservicebillingservice.services.InvoiceServiceInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceBillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceServiceInterface invoiceServiceInterface){
        return args -> {
            invoiceServiceInterface.save(new InvoiceRequestDto(new BigDecimal(100),"81580545-3afc-414b-92a8-4832d9dcfad1"));
            invoiceServiceInterface.save(new InvoiceRequestDto(new BigDecimal(400),"C02"));
            invoiceServiceInterface.save(new InvoiceRequestDto(new BigDecimal(400),"81580545-3afc-414b-92a8-4832d9dcfad1"));
        };
    }

}
