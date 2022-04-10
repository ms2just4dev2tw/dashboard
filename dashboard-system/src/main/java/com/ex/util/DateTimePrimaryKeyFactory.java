package com.ex.util;

import com.ex.pojo.DatetimePrimaryKey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一个数据库表对应一个 timestamp+count 生成器
 * 一旦确定了 level，这个数据库表的辅助主键列的生成策略也就固定了
 */
public class DateTimePrimaryKeyFactory {

    private Map<String, TimeUnitGenerator> generatorMap;

    public DateTimePrimaryKeyFactory() {
        generatorMap = new ConcurrentHashMap<>();
    }

    public DatetimePrimaryKey uniquePrimaryKey(String tableName) {
        return uniquePrimaryKey(tableName, TimeUnitLevel.Second);
    }

    public DatetimePrimaryKey uniquePrimaryKey(String tableName, TimeUnitLevel level) {
        long currentTimestamp = System.currentTimeMillis();
        TimeUnitGenerator generator = generatorMap.get(tableName);

        if(generator == null)
            generator = putAndGet(currentTimestamp, tableName, level);

        return generator.nextPrimaryKey(currentTimestamp);
    }

    private TimeUnitGenerator putAndGet(long currentTimestamp, String tableName, TimeUnitLevel level) {
        TimeUnitGenerator generator = new TimeUnitGenerator(currentTimestamp, level);
        generatorMap.put(tableName, generator);
        return generator;
    }

}
