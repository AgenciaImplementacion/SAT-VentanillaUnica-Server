package info.proadmintierra.api.data.dao;

import org.springframework.data.repository.CrudRepository;

import info.proadmintierra.api.data.entity.CategoryRestriction;

/**
 * IRestrictionObjectSpecialRegimeDao
 */
public interface ICategoryRestrictionDao extends CrudRepository<CategoryRestriction, Long> {
    
}