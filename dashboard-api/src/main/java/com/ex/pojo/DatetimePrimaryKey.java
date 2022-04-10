package com.ex.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatetimePrimaryKey {

    /**
     * DatetimePrimaryKey 对象的生城市间
     */
    private Date datetime;

    /**
     * 单位时间计数
     */
    private int count;

}
