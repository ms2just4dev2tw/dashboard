package com.ex.repository;

import com.ex.pojo.BenchmarkData;
import com.ex.pojo.DatetimePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchmarkDataRepository extends JpaRepository<BenchmarkData, DatetimePrimaryKey> {


}
