package info.proadmintierra.api.data.dto;

import java.util.HashSet;
import java.util.Set;

import info.proadmintierra.api.data.entity.ObjectSpecialRegime;

/**
 * RestrictionObjectSpecialRegimeDto
 */
public class ObjectSpecialRegimeCategoryDto {

    ObjectSpecialRegime objSpecialRegime;
    Set<CategoryRestrictionsDto> categories;

    public ObjectSpecialRegimeCategoryDto() {
        this.categories = new HashSet<>();
    }

    public void addCategoryRestriction(CategoryRestrictionsDto categoryRestriction) {
        this.categories.add(categoryRestriction);
    }

    public ObjectSpecialRegime getObjSpecialRegime() {
        return this.objSpecialRegime;
    }

    public void setObjSpecialRegime(ObjectSpecialRegime objSpecialRegime) {
        this.objSpecialRegime = objSpecialRegime;
    }

    public Set<CategoryRestrictionsDto> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<CategoryRestrictionsDto> categories) {
        this.categories = categories;
    }

}