package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.data.mysql.MySqlCategoryDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

// ADDED Annotations Here To:
// - Turn Class into Rest Controller
// - Map Path
// - CrossOrigin
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

    // ADDED Code for Method
    /**
     * Method Description
     * - Returns List of All Categories
     */
    @GetMapping
    public List<Category> getAll() {

        List<Category> categories = categoryDao.getAllCategories();
        return categories;
    }

    // ADDED Code for Method
    /**
     * Method Description
     * - Returns List of All Categories by ID
     */
    @GetMapping("{id}")
    public Category getById(@PathVariable int id) {
        Category category = null;
        try {
            category = categoryDao.getById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }

        if (category == null) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return  category;
    }

    // ADDED Code for Method
    /**
     * Method Description
     * - Returns List of Products by the CategoryId
     */
    @GetMapping("{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId) {

        return productDao.listByCategoryId(categoryId);
    }

    // ADDED Code for Method
    /**
     * Method Description
     * - Adds a New Category
     */
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Category addCategory(@RequestBody Category category) {

        try {
            return categoryDao.create(category);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    // Added Code for Method
    /**
     * Method Description
     * - Update an Existing Category
     */
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {

        categoryDao.update(id, category);
    }

    // Added Code for Method
    /**
     * Method Description
     * - Update an Existing Category
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);

    }
}
