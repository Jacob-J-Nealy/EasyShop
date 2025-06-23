package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests


// Rest Controller Class Annotation
@RestController
@RequestMapping("/categories")
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
    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAll() {

        List<Category> categories = categoryDao.getAllCategories();
        return categories;
    }

    /**
     * Method Description
     * - Returns List of All Categories by ID
     */
    @RequestMapping(path = "/categories/{CategoryID}", method = RequestMethod.GET)
    public Category getById(@PathVariable int id) {

        return categoryDao.getById(id);
    }

    /**
     * Method Description
     * - Returns List of Products by the CategoryId
     */
    @RequestMapping(path = "{categoryId}/products", method = RequestMethod.GET)
    public List<Product> getProductsById(@PathVariable int categoryId)
    {
       return productDao.listByCategoryId(categoryId);
    }

    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function
    @RequestMapping(path = "categories/{categoryId}", method = RequestMethod.GET)
    public Category addCategory(@RequestBody Category category)
    {
        // insert the category
        return null;
    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        // update the category by id
    }


    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public void deleteCategory(@PathVariable int id)
    {
        // delete the category by id
    }
}
