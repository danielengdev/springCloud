package com.example.microservicec.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductJpaEntity, Long> {
    // O Spring Data JPA gera automaticamente as implementações para os métodos CRUD
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário.
}

