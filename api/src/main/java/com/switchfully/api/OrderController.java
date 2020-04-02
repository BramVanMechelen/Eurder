package com.switchfully.api;


import com.switchfully.domain.repositiories.OrderRepository;
import com.switchfully.service.dto.CreateOrderDto;
import com.switchfully.service.dto.OrderDto;
import com.switchfully.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = OrderController.ORDER_CONTROLLER_RESOURCE_URL)
public class OrderController {
    public static final String ORDER_CONTROLLER_RESOURCE_URL = "/order";

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository){this.orderRepository = orderRepository;}

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(CREATED)
    public OrderDto addNewOrder(@RequestBody CreateOrderDto createOrderDto){
        return OrderMapper.turnOrderInOrderDto(
                orderRepository.addOrder(
                OrderMapper.turnCreateOrderDtoInOrder(createOrderDto)));

    }

    @GetMapping( produces = "application/json")
    @ResponseStatus(ACCEPTED)
    public List<OrderDto> getAllOrders(){
        return orderRepository.getOrderList().stream()
                .map(OrderMapper::turnOrderInOrderDto)
                .collect(Collectors.toList());
    }
}
