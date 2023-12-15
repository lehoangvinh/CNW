package com.example.shopson.model.bo;

import com.example.shopson.model.bean.Category;
import com.example.shopson.model.dao.CategoryDAO;

import java.util.List;

public class CategoryBO {
    private final CategoryDAO categoryDAO = new CategoryDAO();
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
