package info.proadmintierra.api.data.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import info.proadmintierra.api.data.entity.Category;
import info.proadmintierra.api.data.entity.ObjectSpecialRegime;

/**
 * IRestrictionObjectSpecialRegimeDao
 */
public interface ICategoryDao extends CrudRepository<Category, Long> {

    List<Category> findByObjectSR(ObjectSpecialRegime objectSR);
    
}