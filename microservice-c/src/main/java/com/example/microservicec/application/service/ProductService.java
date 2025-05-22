package com.example.microservicec.application.service;
import com.example.microservicec.application.dto.ProductDTO;
import com.example.microservicec.domain.entity.Product;
import com.example.microservicec.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        // Converte DTO para entidade de domínio
        Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity());
        Product savedProduct = productRepository.save(product);
        // Converte entidade de domínio de volta para DTO
        return new ProductDTO(savedProduct.getId(), savedProduct.getName(), savedProduct.getPrice(), savedProduct.getQuantity());
    }

    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getQuantity()));
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getQuantity()))
                .collect(Collectors.toList());
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(productDTO.getName());
                    existingProduct.setPrice(productDTO.getPrice());
                    existingProduct.setQuantity(productDTO.getQuantity());
                    Product updatedProduct = productRepository.save(existingProduct);
                    return new ProductDTO(updatedProduct.getId(), updatedProduct.getName(), updatedProduct.getPrice(), updatedProduct.getQuantity());
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id)); // Exemplo de tratamento de erro
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}