package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.data.mysql.MySqlCategoryDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests


// Rest Controller Class Annotation
@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController
{
    // Class Attributes
    private CategoryDao categoryDao;
    private ProductDao productDao;

    // Autowired Constructor
    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;

    }

    /**
     * Method Description
     * - Returns List of All Categories
     */
    @GetMapping
    public List<Category> getAll() {

        List<Category> categories = categoryDao.getAllCategories();
        return categories;
    }

    /**
     * Method Description
     * - Returns List of All Categories by ID
     */
    @GetMapping("{id}")
    public Category getById(@PathVariable int id) {

        return categoryDao.getById(id);
    }

    /**
     * Method Description
     * - Returns List of Products by the CategoryId
     */
    @GetMapping("{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId) {
       return productDao.listByCategoryId(categoryId);
    }

    /**
     * Method Description
     * - Adds a New Category
     */
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Category addCategory(@RequestBody Category category) {

        return categoryDao.create(category);
    }

    /**
     * Method Description
     * - Update an Existing Category
     */
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {

        categoryDao.update(id, category);
    }

    /**
     * Method Description
     * - Update an Existing Category
     */
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);

    }
}
