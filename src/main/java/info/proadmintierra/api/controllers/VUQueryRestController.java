package info.proadmintierra.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.proadmintierra.api.data.dao.ICategoryDao;
import info.proadmintierra.api.data.dao.ICategoryRestrictionDao;
import info.proadmintierra.api.data.dao.IObjectSpecialRegimeDao;
import info.proadmintierra.api.data.dao.IOrganizationDao;
import info.proadmintierra.api.data.dao.IRestrictionDao;
import info.proadmintierra.api.data.dao.ObjectSpecialRegimeCategoryDao;
import info.proadmintierra.api.data.dto.ObjectSpecialRegimeCategoryDto;
import info.proadmintierra.api.data.entity.Organization;
import info.proadmintierra.api.data.entity.Restriction;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ParcelQueryRestController
 */
@RestController
@RequestMapping("/vu")
@CrossOrigin(origins = { "http://localhost:4200", "*" })
public class VUQueryRestController {

    // SELECT
    // ST_AsText(ST_GeomFromGeoJSON('{"type":"Point","coordinates":[-48.23456,20.12345]}'))
    // http://192.168.98.69:7070/geoserver/LADM/wfs?service=wfs&version=2.0.0&request=GetFeature&typeNames=LADM:canutalito_area_protegida&count=2&outputFormat=application/json
    // http://192.168.98.69:7070/geoserver/LADM/wfs?service=wfs&version=2.0.0&request=GetFeature&typeNames=LADM:canutalito_area_protegida&featureID=canutalito_area_protegida.fid--6ad77683_16bb35d3b8b_-4e33&outputFormat=application/json

    @Autowired
    private ICategoryRestrictionDao categoryRestrictionService;

    @Autowired
    private IObjectSpecialRegimeDao osrService;

    @Autowired
    private ICategoryDao categoryService;

    @Autowired
    private IOrganizationDao organizationService;

    @Autowired
    private IRestrictionDao restrictionService;

    @PostMapping("/ore")
    public ObjectSpecialRegimeCategoryDto create(@Valid @RequestBody ObjectSpecialRegimeCategoryDto inputObject,
            BindingResult result) {

        ObjectSpecialRegimeCategoryDao osrCatService = new ObjectSpecialRegimeCategoryDao(osrService, categoryService,
                categoryRestrictionService);
        inputObject = osrCatService.save(inputObject);

        return inputObject;
    }

    @PutMapping("/ore")
    public ObjectSpecialRegimeCategoryDto update(@Valid @RequestBody ObjectSpecialRegimeCategoryDto inputObject,
            BindingResult result) {

        ObjectSpecialRegimeCategoryDao osrCatService = new ObjectSpecialRegimeCategoryDao(osrService, categoryService,
                categoryRestrictionService);
        inputObject = osrCatService.update(inputObject);

        return inputObject;
    }

    @DeleteMapping("/ore/{id}")
    public void delete(@PathVariable long id) {

        ObjectSpecialRegimeCategoryDao osrCatService = new ObjectSpecialRegimeCategoryDao(osrService, categoryService,
                categoryRestrictionService);
        osrCatService.delete(id);

    }

    @GetMapping("/ore/{id}")
    public Iterable<ObjectSpecialRegimeCategoryDto> list(@PathVariable int id) {

        Organization org = this.organizationService.findById(Long.parseLong(id + "")).get();
        ObjectSpecialRegimeCategoryDao osrCatService = new ObjectSpecialRegimeCategoryDao(osrService, categoryService,
                categoryRestrictionService);

        return osrCatService.getListByOrganization(org);
    }

    @GetMapping("/ore/restrictions")
    public Iterable<Restriction> getRestrictions() {
        return this.restrictionService.findAll();
    }

    @GetMapping("/ore/organizations")
    public Iterable<Organization> getEntities() {
        return this.organizationService.findAll();
    }
}