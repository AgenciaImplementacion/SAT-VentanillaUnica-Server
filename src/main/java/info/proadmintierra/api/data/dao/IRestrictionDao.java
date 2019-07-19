package info.proadmintierra.api.data.dao;

import org.springframework.data.repository.CrudRepository;

import info.proadmintierra.api.data.entity.Restriction;

/**
 * IRestrictionDao
 */
public interface IRestrictionDao extends CrudRepository<Restriction, Long> {
    
}