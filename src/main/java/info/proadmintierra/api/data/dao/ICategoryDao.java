package info.proadmintierra.api.data.dao;

import org.springframework.data.repository.CrudRepository;

import info.proadmintierra.api.data.entity.Category;

/**
 * IRestrictionObjectSpecialRegimeDao
 */
public interface ICategoryDao extends CrudRepository<Category, Long> {
    
}