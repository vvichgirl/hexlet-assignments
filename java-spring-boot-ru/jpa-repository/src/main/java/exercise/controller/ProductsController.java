package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Sort;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping(path = "")
    public List<Product> index(@RequestParam(name = "min", required = false) Integer min,
                               @RequestParam(name = "max", required = false) Integer max) {
        if (min != null && max != null) {
            return productRepository.findByPriceBetween(min, max, Sort.by(Sort.Order.asc("price")));
        }
        if (min != null) {
            return productRepository.findByPriceGreaterThanEqual(min, Sort.by(Sort.Order.asc("price")));
        }
        if (max != null) {
            return productRepository.findByPriceLessThanEqual(max, Sort.by(Sort.Order.asc("price")));
        }
        return productRepository.findAll(Sort.by(Sort.Order.asc("price")));
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
