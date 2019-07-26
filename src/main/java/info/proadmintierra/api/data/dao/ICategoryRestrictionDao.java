package info.proadmintierra.api.data.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import info.proadmintierra.api.data.entity.Category;
import info.proadmintierra.api.data.entity.CategoryRestriction;

/**
 * IRestrictionObjectSpecialRegimeDao
 */
public interface ICategoryRestrictionDao extends CrudRepository<CategoryRestriction, Long> {

    List<CategoryRestriction> findByCategory(Category category);

}