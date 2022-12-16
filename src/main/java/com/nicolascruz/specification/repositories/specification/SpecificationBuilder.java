package com.nicolascruz.specification.repositories.specification;

import java.util.ArrayList;
import java.util.List;

public class SpecificationBuilder {

    private List<Filter> params;

    public SpecificationBuilder() {
        params = new ArrayList<>();
    }

    public final SpecificationBuilder with(String key, String operation, Object value) {
        //Creating filters
        QueryOperator op = QueryOperator.getSimpleOperation(operation);
        if (op != null) {
            params.add(new Filter(key, op, value.toString()));
        }
        return this;
    }

    public List<Filter> getFilters() {
        return params;
    }

}
