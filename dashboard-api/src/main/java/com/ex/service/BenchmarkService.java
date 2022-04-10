package com.ex.service;

import com.ex.pojo.GeometricMean;

import java.util.List;

public interface BenchmarkService {

    /**
     *
     * @return
     */
    public List<GeometricMean> getGeometricMean (int page, int pageSize);

}
