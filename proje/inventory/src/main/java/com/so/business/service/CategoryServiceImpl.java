package com.so.business.service;

import com.so.business.dto.CategoryDto;
import com.so.data.entity.Category;
import com.so.data.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryListToCategoryDtoList(categories);
    }

    private List<CategoryDto> categoryListToCategoryDtoList(List<Category> categories) {
        ArrayList<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category: categories) {
            categoryDtos.add(categoryToCategoryDto(category));
        }

        return categoryDtos;
    }

    private CategoryDto categoryToCategoryDto(Category category) {
        return new CategoryDto(category.getCategoryId(), category.getCategoryName());
    }
}
