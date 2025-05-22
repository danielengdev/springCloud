package com.example.microservicec.infrastructure.repository;

import com.example.microservicec.domain.entity.Product;
import com.example.microservicec.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("productRepositoryImpl") // Nome do componente para evitar conflito com a interface
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id)
                .map(this::toDomainEntity); // Converte ProductJpaEntity para Product
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(this::toDomainEntity) // Converte ProductJpaEntity para Product
                .collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        ProductJpaEntity jpaEntity = toJpaEntity(product); // Converte Product para ProductJpaEntity
        ProductJpaEntity savedJpaEntity = jpaProductRepository.save(jpaEntity);
        return toDomainEntity(savedJpaEntity); // Converte de volta para Product
    }

    @Override
    public void deleteById(Long id) {
        jpaProductRepository.deleteById(id);
    }

    // Métodos de mapeamento entre Product (domínio) e ProductJpaEntity (persistência)
    private Product toDomainEntity(ProductJpaEntity jpaEntity) {
        return new Product(jpaEntity.getId(), jpaEntity.getName(), jpaEntity.getPrice(), jpaEntity.getQuantity());
    }

    private ProductJpaEntity toJpaEntity(Product domainEntity) {
        return new ProductJpaEntity(domainEntity.getId(), domainEntity.getName(), domainEntity.getPrice(), domainEntity.getQuantity());
    }
}
