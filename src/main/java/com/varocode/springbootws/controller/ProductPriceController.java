package com.varocode.springbootws.controller;

import com.varocode.springbootws.model.ProductPrice;
import com.varocode.springbootws.repository.IBrandRepository;
import com.varocode.springbootws.repository.IProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Stream;

/**
 * @author aap
 * REST controller
 */
@RestController
public class ProductPriceController {

    @Autowired
    private IProductPriceRepository repository;
    @Autowired
    private IBrandRepository brandRepository;

    //http://localhost:8080/productPriceFinder?productId=1&brand=ZARA&date=2020-12-31
    @GetMapping("/productPriceFinder")
    public ProductPrice getProductPriceByDate(@RequestParam(value = "productId") int productId,
                                              @RequestParam(value = "brand") String brand,
                                              @RequestParam(value = "date") String date) {
        return brandRepository.findByName(brand)
                .map(Collection::stream)
                .flatMap(Stream::findFirst)
                .map(brandPojo -> repository.findProductPriceByDate(productId, brandPojo, new Date()))
                .orElseGet(ProductPrice::new);
    }
}
