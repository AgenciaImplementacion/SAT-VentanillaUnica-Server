package info.proadmintierra.api.data.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import info.proadmintierra.api.data.dto.CategoryRestrictionsDto;
import info.proadmintierra.api.data.dto.ObjectSpecialRegimeCategoryDto;
import info.proadmintierra.api.data.entity.Category;
import info.proadmintierra.api.data.entity.CategoryRestriction;
import info.proadmintierra.api.data.entity.ObjectSpecialRegime;
import info.proadmintierra.api.data.entity.Organization;

/**
 * RestrictionObjectSpecialRegimeDtoDao
 */
public class ObjectSpecialRegimeCategoryDao {

    private IObjectSpecialRegimeDao osrService;
    private CategoryRestrictionsDao catRestrService;
    private ICategoryDao categoryService;
    private ICategoryRestrictionDao caterogyRestrictionService;

    public ObjectSpecialRegimeCategoryDao(IObjectSpecialRegimeDao osrService, ICategoryDao categoryService,
            ICategoryRestrictionDao categoryRestrictionService) {
        this.osrService = osrService;
        this.catRestrService = new CategoryRestrictionsDao(categoryService, categoryRestrictionService);
        this.categoryService = categoryService;
        this.caterogyRestrictionService = categoryRestrictionService;
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

    public ObjectSpecialRegimeCategoryDto update(ObjectSpecialRegimeCategoryDto data) {

        ObjectSpecialRegime objSpecialRegime = data.getObjSpecialRegime();
        Set<CategoryRestrictionsDto> categories = data.getCategories();

        objSpecialRegime = osrService.save(objSpecialRegime);

        data.setObjSpecialRegime(objSpecialRegime);

        Set<CategoryRestrictionsDto> storedCategories = new HashSet<>();

        for (CategoryRestrictionsDto c : categories) {

            long categoryId = c.getCategory().getId();
            if (categoryId != 0) {
                System.out.println("borrando categoria ... " + categoryId);

                List<CategoryRestriction> objectsRestrictions = this.caterogyRestrictionService
                        .findByCategory(c.getCategory());

                if (objectsRestrictions.size() > 0) {
                    System.out.println("borrando restricciones" + objectsRestrictions.size());

                    for (CategoryRestriction care : objectsRestrictions) {
                        System.out.println("id ----> " + care.getId());
                        this.caterogyRestrictionService.deleteById(care.getId());
                    }

                }

                this.categoryService.deleteById(categoryId);
            }

            c.setObjSpecialRegime(objSpecialRegime);
            c = this.catRestrService.save(c);
            storedCategories.add(c);
        }

        data.setCategories(storedCategories);

        return data;

    }

    public void delete(long objectSpecialRegimeId) {

        this.osrService.findById(objectSpecialRegimeId);

    }

    public List<ObjectSpecialRegimeCategoryDto> getListByOrganization(Organization org) {

        List<ObjectSpecialRegimeCategoryDto> list = new ArrayList<ObjectSpecialRegimeCategoryDto>();

        List<ObjectSpecialRegime> l = this.osrService.findByOrganization(org);

        for (ObjectSpecialRegime o : l) {

            ObjectSpecialRegimeCategoryDto n = new ObjectSpecialRegimeCategoryDto();
            n.setObjSpecialRegime(o);
            Set<CategoryRestrictionsDto> categories = this.catRestrService.getListByObjectSpecialRegime(o);
            n.setCategories(categories);
            list.add(n);

        }
        return list;
    }

}