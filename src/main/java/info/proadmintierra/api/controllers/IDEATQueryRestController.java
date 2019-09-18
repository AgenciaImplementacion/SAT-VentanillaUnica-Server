package info.proadmintierra.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ParcelQueryRestController
 */
@RestController
@RequestMapping("/ideat")
@CrossOrigin(origins = { "http://localhost:4200", "*" })
public class IDEATQueryRestController {

    @GetMapping(path = "/models/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getModels(@PathVariable int id) {
        switch (id) {
        case 1:
            return "{ \"entity\": 1, \"name\": \"Departamento Nacional de Planeación\", \"topics\":[ { \"name\":\"Ordenamiento Territorial\", \"models\":[ { \"name\": \"Ordenamiento_Territorial_V0_0_3.ili\", \"url\": \"http://repositorio.proadmintierra.info/LADM_COL/Ordenamiento_Territorial/Ordenamiento_Territorial_V0_0_3.ili\", \"objects\":[ { \"name\": \"Zona POT\", \"url\":\"http://192.168.98.69:7070/geoserver/LADM/wfs?service=wfs&version=2.0.0&request=GetFeature&typeNames=LADM:canutalito_objespecial&outputFormat=application/json\" }, { \"name\": \"Zona de Protección\", \"url\":\"http://192.168.98.69:7070/geoserver/LADM/wfs?service=wfs&version=2.0.0&request=GetFeature&typeNames=LADM:canutalito_zona_proteccion&outputFormat=application/json\" } ] } ] } ] }";
        case 2:
            return "{ \"entity\": 2, \"name\": \"Parques Nacionales Naturales de Colombia\", \"topics\":[ { \"name\":\"Sistema Parques Nacionales Naturales\", \"models\":[ { \"name\": \"Parques_Nacionales_Naturales_V0_0_1.ili\", \"url\": \"https://repositorio.proadmintierra.info/LADM_COL/Sistema_Parques_Nacionales_Naturales/Parques_Nacionales_Naturales_V0_0_1.ili\", \"objects\":[ { \"name\": \"Área Protegida\", \"url\":\"http://192.168.98.69:7070/geoserver/LADM/wfs?service=wfs&version=2.0.0&request=GetFeature&typeNames=LADM:canutalito_area_protegida&outputFormat=application/json\" } ] } ] } ] }";
        case 3:
            return "{ \"entity\": 3, \"name\": \"Unidad Nacional para la Gestión del Riesgo de Desastres\", \"topics\":[ { \"name\":\"Condición de Amenaza y Riesgo\", \"models\":[ { \"name\": \"Amenaza_Riesgo_V0_0.ili\", \"url\": \"https://repositorio.proadmintierra.info/LADM_COL/Condicion_Amenaza_Riesgo/Amenaza_Riesgo_V0_0.ili\", \"objects\":[ { \"name\": \"Amenaza y Riesgo\", \"url\":\"http://192.168.98.69:7070/geoserver/LADM/wfs?service=wfs&version=2.0.0&request=GetFeature&typeNames=LADM:canutalito_ayr&outputFormat=application/json\" } ] } ] } ] }";
        default:
            return "{}";
        }
    }

}