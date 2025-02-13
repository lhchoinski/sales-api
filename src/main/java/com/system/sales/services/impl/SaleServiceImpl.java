package com.system.sales.services.impl;

import com.system.sales.dtos.SaleDTO;
import com.system.sales.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "sales.queue")
    public String processSales(SaleDTO saleRequest) {
        try {
            System.out.println("Processando venda: " + saleRequest.getCustomerId());

            return "Venda processada: " + saleRequest.getId();
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }

}
