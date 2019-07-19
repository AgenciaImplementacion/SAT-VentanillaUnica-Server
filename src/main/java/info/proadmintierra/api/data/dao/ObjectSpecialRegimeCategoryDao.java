package info.proadmintierra.api.data.dao;

import java.util.HashSet;
import java.util.Set;

import info.proadmintierra.api.data.dto.CategoryRestrictionsDto;
import info.proadmintierra.api.data.dto.ObjectSpecialRegimeCategoryDto;
import info.proadmintierra.api.data.entity.ObjectSpecialRegime;

/**
 * RestrictionObjectSpecialRegimeDtoDao
 */
public class ObjectSpecialRegimeCategoryDao {

    private IObjectSpecialRegimeDao osrService;
    private CategoryRestrictionsDao catRestrService;

    public ObjectSpecialRegimeCategoryDao(IObjectSpecialRegimeDao osrService, ICategoryDao categoryService,
            ICategoryRestrictionDao categoryRestrictionService) {
        this.osrService = osrService;
        this.catRestrService = new CategoryRestrictionsDao(categoryService, categoryRestrictionService);
    }

    

    public ObjectSpecialRegimeCategoryDto save(ObjectSpecialRegimeCategoryDto data) {

        ObjectSpecialRegime objSpecialRegime = data.getObjSpecialRegime();
        Set<CategoryRestrictionsDto> categories = data.getCategories();

        objSpecialRegime = osrService.save(objSpecialRegime);

        data.setObjSpecialRegime(objSpecialRegime);
        
        Set<CategoryRestrictionsDto> storedCategories = new HashSet<>();

        for (CategoryRestrictionsDto c : categories) {
            c.setObjSpecialRegime(objSpecialRegime);
            c = this.catRestrService.save(c);
            storedCategories.add(c);
        }

        data.setCategories(storedCategories);

        return data;

    }

}