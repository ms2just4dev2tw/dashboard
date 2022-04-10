package com.ex.util;


import com.ex.pojo.DatetimePrimaryKey;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TimeUnitGenerator {

    private TimeUnitLevel level;
    private AtomicLong timestamp;
    private AtomicInteger timeUnitCount;

    private final int DEFAULT_INIT_COUNT = 0;

    public TimeUnitGenerator(long timestamp) {
        this(timestamp, TimeUnitLevel.Second);
    }

    public TimeUnitGenerator(long timestamp, TimeUnitLevel level) {
        this.level = level;
        this.timestamp = new AtomicLong(timestamp);
        this.timeUnitCount = new AtomicInteger(DEFAULT_INIT_COUNT);
    }

    public DatetimePrimaryKey nextPrimaryKey(long currentTimestamp) {
        currentTimestamp = filterTimestamp(currentTimestamp);

        //
        int compareResult = (int) (timestamp.get() - currentTimestamp);
        if (compareResult == 0)
            timeUnitCount.incrementAndGet();
        else if (compareResult < 0){
            timestamp.set(currentTimestamp);
            timeUnitCount.set(DEFAULT_INIT_COUNT + 1);
        } else
            throw new RuntimeException("TimeUnitGenerator 的内部变量 timestamp 大于 currentTimestamp");

        DatetimePrimaryKey pk = new DatetimePrimaryKey();
        pk.setCreateTime(new Date(currentTimestamp));
        pk.setCount(timeUnitCount.get());
        return  pk;
    }

    private long filterTimestamp(long currentTimestamp) {
        return currentTimestamp/level.inMillis() * level.inMillis();
    }

}
