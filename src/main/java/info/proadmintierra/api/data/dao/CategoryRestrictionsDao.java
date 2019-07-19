package info.proadmintierra.api.data.dao;

import java.util.HashSet;
import java.util.Set;

import info.proadmintierra.api.data.dto.CategoryRestrictionsDto;
import info.proadmintierra.api.data.entity.Category;
import info.proadmintierra.api.data.entity.CategoryRestriction;

/**
 * CategoryRestrictionDao
 */
public class CategoryRestrictionsDao {

    private ICategoryRestrictionDao categoryRestrictionService;
    private ICategoryDao categoryService;

    public CategoryRestrictionsDao( ICategoryDao categoryService, ICategoryRestrictionDao categoryRestrictionService) {
        this.categoryRestrictionService = categoryRestrictionService;
        this.categoryService = categoryService;
    }

    public CategoryRestrictionsDto save(CategoryRestrictionsDto data) {

        Category category = data.getCategory();
        Set<CategoryRestriction> restrictions = data.getRestrictions();

        category = categoryService.save(category);
        data.setCategory(category);

        Set<CategoryRestriction> storedRestrictions = new HashSet<>();

        for (CategoryRestriction cr : restrictions) {
            cr.setCategory(category);
            cr = this.categoryRestrictionService.save(cr);
            storedRestrictions.add(cr);
        }

        data.setRestrictions(storedRestrictions);

        return data;

    }
}