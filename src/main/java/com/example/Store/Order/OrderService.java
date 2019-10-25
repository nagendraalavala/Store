package com.example.Store.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    //create an order
    public OrderEntity createorder(OrderEntity orderEntity)
    {
        return orderRepository.save(orderEntity);
    }


    //get an order details
    public List<OrderEntity> getallorders()
    {
        return (List<OrderEntity>) orderRepository.findAll();
    }

    //get an order by id
    public Optional<OrderEntity> getorderbyId(long id)
    {
        return orderRepository.findById(id);
    }

}
