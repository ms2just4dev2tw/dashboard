package com.ex.pojo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@JsonFilter(value = "GeometricMean_Filter")
// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeometricMean {

    @JsonProperty(value = "test-item", index = 1)
    private String testItemName;

    @JsonProperty(value = "datetime", index = 3)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonProperty(value = "datetime-count", index = 4)
    private int timeUnitCount;

    @JsonProperty(value = "geometric-mean", index = 2)
    private double valueOfGeometricMean;

}
