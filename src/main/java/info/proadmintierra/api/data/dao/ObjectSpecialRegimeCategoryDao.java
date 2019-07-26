package info.proadmintierra.api.data.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import info.proadmintierra.api.data.dto.CategoryRestrictionsDto;
import info.proadmintierra.api.data.dto.ObjectSpecialRegimeCategoryDto;
import info.proadmintierra.api.data.entity.ObjectSpecialRegime;
import info.proadmintierra.api.data.entity.Organization;

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

    public List<ObjectSpecialRegimeCategoryDto> getListByOrganization(Organization org){

        List<ObjectSpecialRegimeCategoryDto> list = new ArrayList<ObjectSpecialRegimeCategoryDto>();

        List<ObjectSpecialRegime> l = this.osrService.findByOrganization(org);

        for(ObjectSpecialRegime o : l){

            ObjectSpecialRegimeCategoryDto n = new ObjectSpecialRegimeCategoryDto();
            n.setObjSpecialRegime(o);
            Set<CategoryRestrictionsDto> categories = this.catRestrService.getListByObjectSpecialRegime(o);
            n.setCategories(categories);
            list.add(n);

        }
        return list;
    }

}