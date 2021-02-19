package com.leodelmiro.casadocodigo.newstate;

import com.leodelmiro.casadocodigo.newcountry.Country;
import com.leodelmiro.casadocodigo.validation.annotations.ExistsId;
import com.leodelmiro.casadocodigo.validation.annotations.UniqueCountryStateField;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueCountryStateField(stateAttribute = "name", countryField = "countryId", domainClass = State.class, message = "{UniqueCountryStateName.newStateForm}")
public class NewStateForm {

    @NotBlank
    private String name;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Country.class)
    private Long countryId;

    @Deprecated
    public NewStateForm() {

    }

    public NewStateForm(@NotBlank String name, @NotNull Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toModel(EntityManager entityManager) {
        @NotNull Country country = entityManager.find(Country.class, countryId);

        Assert.state(country != null, "Você está querendo cadastrar um estado passando um país que não existe no banco " + countryId);

        return new State(name, country);
    }

}
