package com.switchfully.api;


import com.switchfully.domain.repositiories.OrderRepository;
import com.switchfully.service.dto.orderdto.CreateOrderDto;
import com.switchfully.service.dto.orderdto.OrderDto;
import com.switchfully.service.mapper.OrderMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = OrderController.ORDER_CONTROLLER_RESOURCE_URL)
public class OrderController {
    public static final String ORDER_CONTROLLER_RESOURCE_URL = "/order";

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(CREATED)
    public OrderDto addNewOrder(@RequestBody CreateOrderDto createOrderDto){
        return OrderMapper.turnOrderInOrderDto(Objects.requireNonNull(OrderRepository.addOrder(OrderMapper.turnCreateOrderDtoInOrder(createOrderDto))));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(ACCEPTED)
    public List<OrderDto> getAllOrders() {
        return OrderRepository.getOrderList().stream().map(OrderMapper::turnOrderInOrderDto).collect(Collectors.toList());
    }
}
