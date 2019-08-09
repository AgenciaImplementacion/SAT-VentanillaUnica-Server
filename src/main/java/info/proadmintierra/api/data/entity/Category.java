package info.proadmintierra.api.data.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;

/**
 * Category
 */
@Entity
@Table(name = "category", schema = "vu")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "id_object_special_regime", nullable = false)
    //@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ObjectSpecialRegime objectSR;

    @Column(nullable = true)
    private String field;

    @Column(nullable = true)
    private String value;

    @URL
    @Column(name = "url_mas_info", nullable = true)
    private String urlMasInfo;

    @Column(nullable = true, columnDefinition = "text")
    private String description;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany(fetch = FetchType.EAGER)
    private Set<CategoryRestriction> restrictions;

    public Set<CategoryRestriction> getRestrictions() {
        return this.restrictions;
    }

    public void setRestrictions(Set<CategoryRestriction> restrictions) {
        this.restrictions = restrictions;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObjectSpecialRegime getObjectSR() {
        return this.objectSR;
    }

    public void setObjectSR(ObjectSpecialRegime objectSR) {
        this.objectSR = objectSR;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrlMasInfo() {
        return this.urlMasInfo;
    }

    public void setUrlMasInfo(String urlMasInfo) {
		this.urlMasInfo = urlMasInfo;
	}

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}