package com.ex.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class CustomJacksonFilter {

    public static FilterProvider doFilterBy(String filterId, String[] exceptArr) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(exceptArr);
        return new SimpleFilterProvider().addFilter(filterId, filter);
    }

}
