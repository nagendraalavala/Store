package com.example.Store.Order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    RestTemplate restTemplate;

   @Autowired
    private OrderService orderService;

   @PostMapping("/addorder")
    public OrderEntity createorder(OrderEntity orderEntity)
   {
       return orderService.createorder(orderEntity);
   }

   @GetMapping("/allorders")
    public List<OrderEntity> getallorders()
   {
       return orderService.getallorders();
   }

   @GetMapping("/findorder/{id}")
    public Optional<OrderEntity> getorderbyid(@PathVariable long id)
   {
       return orderService.getorderbyId(id);
   }

    @RequestMapping(value = "/template/products")
    public String getorderdetails()
    {


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8080/newstore/orderdetails/{id}", HttpMethod.GET, entity, String.class).getBody();
    }
}


