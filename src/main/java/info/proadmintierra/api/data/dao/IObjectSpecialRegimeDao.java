package info.proadmintierra.api.data.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import info.proadmintierra.api.data.entity.ObjectSpecialRegime;
import info.proadmintierra.api.data.entity.Organization;

/**
 * IObjectSpecialRegimeDao
 */
public interface IObjectSpecialRegimeDao extends CrudRepository<ObjectSpecialRegime, Long> {

    List<ObjectSpecialRegime> findByOrganization(Organization organization);

    ObjectSpecialRegime findById(long id);
    
}