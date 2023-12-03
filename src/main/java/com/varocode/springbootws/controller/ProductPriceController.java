package com.varocode.springbootws.controller;

import com.varocode.springbootws.model.Brand;
import com.varocode.springbootws.model.ProductPrice;
import com.varocode.springbootws.repository.IBrandRepository;
import com.varocode.springbootws.repository.IProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
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


    @GetMapping("/productPriceFinder")
    public ProductPrice getProductPriceByDate(@RequestParam(value = "productId") int productId,
                                              @RequestParam(value = "brand") String brand,
                                              @RequestParam(value = "date")
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return getBrandByName(brand)
                .map(brandPojo -> repository.findProductPriceByDate(productId, brandPojo, date))
                .map(Collection::stream)
                .flatMap(Stream::findFirst) //As results are ordered by higher priority value, first stream value is required
                .orElseGet(ProductPrice::new);
    }


    /**
     *
     * @param name Brand's name
     * @return Brand pojo's Optional from a given name
     */
    public Optional<Brand> getBrandByName(String name){
        return brandRepository.findByName(name)
                .map(Collection::stream)
                .flatMap(Stream::findFirst);
    }
}
