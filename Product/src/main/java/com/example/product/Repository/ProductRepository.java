package com.example.product.Repository;

import com.example.product.Entity.ProductEntity;
import com.example.product.paging.PagingAndSortObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query("SELECT p FROM ProductEntity p WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<ProductEntity> findAllByName2(@Param("name") String name,Pageable pageable);
    @Query("SELECT p FROM ProductEntity p WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :name, '%'))")

    List<ProductEntity>findAllByName(@Param("name") String Name);

    Page<ProductEntity> findAllByCategoryId(Long id, Pageable pageable);
}
