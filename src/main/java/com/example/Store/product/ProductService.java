package com.example.Store.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntity productEntity;


    //AddProduct
    public ProductEntity addProduct(ProductEntity productEntity)
    {
        return productRepository.save(productEntity);
    }

    //GetAllProducts
    public  List<ProductEntity> getAllProducts()
    {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public Optional<ProductEntity> findById(Long id)
    {
        return productRepository.findById(id);
    }


    public String getorderdetails(long id)
    {
        String output = null;
        if(productEntity.getPd_id().equals(id))
        {
             output=productEntity.getPd_name()+productEntity.getPd_desc();
        }return output;
    }





}
