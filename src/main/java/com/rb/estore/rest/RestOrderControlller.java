package com.rb.estore.rest;

import com.rb.estore.model.Order;
import com.rb.estore.model.dto.OrderDto;
import com.rb.estore.service.InterfaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class RestOrderControlller {

    @Autowired
    InterfaceOrderService interfaceOrderService;

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public OrderDto getOrder(@PathVariable int id) {
        Order order = interfaceOrderService.getOrderById(id);
        OrderDto orderDto = new OrderDto(order);

        return orderDto;
    }
}
