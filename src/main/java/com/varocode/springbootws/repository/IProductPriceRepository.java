package com.varocode.springbootws.repository;

import com.varocode.springbootws.model.Brand;
import com.varocode.springbootws.model.ProductPrice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author aap
 * Repository interface proving CRUD functionality over PRICES ddbb table.
 * JPQL @Query is used for finder's method customization but QueryDSL
 * would be the prefered option in a real-world scenario.
 * @see CrudRepository
 */
@Repository
public interface IProductPriceRepository extends CrudRepository<ProductPrice, Integer> {

    /**
     * Demo query function
     */
    @Query("select p from ProductPrice p where p.productId=:productId and p.brand=:brand " +
            "and p.startDate<:priceDate and p.endDate>=:priceDate")
    public ProductPrice findProductPriceByDate(@Param("productId") int productId,
                                        @Param("brand") Brand brand,
                                        @Param(("priceDate")) Date priceDate);
}
