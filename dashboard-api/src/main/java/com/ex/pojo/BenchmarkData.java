package com.ex.pojo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

// persistence
@Entity(name = "benchmark_tab")
@IdClass(value = DatetimePrimaryKey.class)
// jackson
@JsonFilter(value = "Benchmark_Filter")
// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BenchmarkData {


    /**
     * 测试项目的数据生成时间
     */
    @Id
    @Column(name = "datetime")
    //
    @JsonProperty(value = "datetime", index = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datetime;

    /**
     * 单位时间计数
     */
    @Id
    @Column(name = "datetime_count")
    //
    @JsonProperty(value = "datetime-count", index = 3)
    private int count;

    /**
     * 测试项目名
     */
    @Column(name = "test_item")
    //
    @JsonProperty(value = "test-item", index = 1)
    private String testItemName;

    /**
     * 测试项目在 arkjit 上花费的启动时间
     */
    @Column(name = "arkjit_runtime")
    //
    @JsonProperty(value = "arkjit-runtime", index = 4)
    private double arkjitRuntime;

    /**
     * 测试项目在 arkjit 上需要的内存
     */
    @Column(name = "arkjit_rss")
    //
    @JsonProperty(value = "arkjit-rss", index = 6)
    private int arkjitRss;

    /**
     * 测试项目在 arknojit 上花费的启动时间
     */
    @Column(name = "arknojit_runtime")
    //
    @JsonProperty(value = "arknojit-runtime", index = 5)
    private double arknojitRuntime;

    /**
     * 测试项目在 arknojit 上需要的内存
     */
    @Column(name = "arknojit_rss")
    //
    @JsonProperty(value = "arknojit-rss", index = 7)
    private int arknojitRss;

}
