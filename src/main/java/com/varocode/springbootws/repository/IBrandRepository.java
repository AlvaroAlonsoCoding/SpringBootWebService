package com.varocode.springbootws.repository;

import com.varocode.springbootws.model.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author aap
 * Repository interface proving CRUD functionality over BRANDS ddbb table.
 * @see CrudRepository
 */
public interface IBrandRepository extends CrudRepository<Brand, String> {

    Optional<List<Brand>> findByName(String name);
}
