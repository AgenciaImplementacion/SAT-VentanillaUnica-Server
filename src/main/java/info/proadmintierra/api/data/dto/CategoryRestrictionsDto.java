package info.proadmintierra.api.data.dto;

import java.util.HashSet;
import java.util.Set;

import info.proadmintierra.api.data.entity.Category;
import info.proadmintierra.api.data.entity.CategoryRestriction;
import info.proadmintierra.api.data.entity.ObjectSpecialRegime;

/**
 * CategoryRestrictionDto
 */
public class CategoryRestrictionsDto {

    Category category;
    Set<CategoryRestriction> restrictions;

    public CategoryRestrictionsDto() {
        this.restrictions = new HashSet<>();
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<CategoryRestriction> getRestrictions() {
        return this.restrictions;
    }

    public void setRestrictions(Set<CategoryRestriction> restrictions) {
        this.restrictions = restrictions;
    }

    public void setObjSpecialRegime(ObjectSpecialRegime objSpecialRegime) {
        this.category.setObjectSR(objSpecialRegime);
    }

    public void addCategoryRestriction(CategoryRestriction categoryRestriction) {
        this.restrictions.add(categoryRestriction);
    }
}