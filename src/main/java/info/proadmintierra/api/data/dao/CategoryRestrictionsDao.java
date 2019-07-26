package info.proadmintierra.api.data.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import info.proadmintierra.api.data.dto.CategoryRestrictionsDto;
import info.proadmintierra.api.data.entity.Category;
import info.proadmintierra.api.data.entity.CategoryRestriction;
import info.proadmintierra.api.data.entity.ObjectSpecialRegime;

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

    public Set<CategoryRestrictionsDto> getListByObjectSpecialRegime(ObjectSpecialRegime obj){
        Set<CategoryRestrictionsDto> list = new HashSet<CategoryRestrictionsDto>();

        List<Category> l = this.categoryService.findByObjectSR(obj);

        for(Category o : l){
            CategoryRestrictionsDto n = new CategoryRestrictionsDto();
            n.setCategory(o);
            n.setObjSpecialRegime(obj);

            Set<CategoryRestriction> r = new HashSet<CategoryRestriction>(this.categoryRestrictionService.findByCategory(o));
            n.setRestrictions(r);
            
            list.add(n);
        }
        
        return list;
    }
}