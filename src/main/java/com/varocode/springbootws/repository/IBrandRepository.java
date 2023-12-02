package com.varocode.springbootws.repository;

import com.varocode.springbootws.model.Brand;
import org.springframework.data.repository.CrudRepository;

/**
 * @author aap
 * Repository interface proving CRUD functionality over BRANDS ddbb table.
 * @see CrudRepository
 */
public interface IBrandRepository extends CrudRepository<Brand, String> {

}
