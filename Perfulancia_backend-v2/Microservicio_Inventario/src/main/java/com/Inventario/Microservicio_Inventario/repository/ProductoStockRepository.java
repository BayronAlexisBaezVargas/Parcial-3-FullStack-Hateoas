package com.Inventario.Microservicio_Inventario.repository;

import com.Inventario.Microservicio_Inventario.model.ProductoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoStockRepository extends JpaRepository<ProductoStock, Long> {

}
