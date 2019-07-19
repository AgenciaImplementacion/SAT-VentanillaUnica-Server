package info.proadmintierra.api.data.dao;

import org.springframework.data.repository.CrudRepository;

import info.proadmintierra.api.data.entity.Organization;

/**
 * IRestrictionDao
 */
public interface IOrganizationDao extends CrudRepository<Organization, Long> {
    
}