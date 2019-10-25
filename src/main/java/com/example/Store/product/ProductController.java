package com.example.Store.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/newstore")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductEntity productEntity;

    @PostMapping("/add")
    public ProductEntity addProduct(@RequestBody ProductEntity productEntity)
    {
        return productService.addProduct(productEntity);
    }

    @GetMapping("/allProducts")
    public List<ProductEntity> getAllProducts()
    {
        return  productService.getAllProducts();
    }

    @GetMapping("/find/{id}")
    public Optional<ProductEntity> findById(@PathVariable Long id)
    {
        return productService.findById(id);
    }

    @GetMapping("/orderdetails/{id}")
    public String getorderdetails(@PathVariable long id)
    {
        return productService.getorderdetails(id);
    }





}
