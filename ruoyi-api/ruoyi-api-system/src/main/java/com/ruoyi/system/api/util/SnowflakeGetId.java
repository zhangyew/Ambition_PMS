package com.ruoyi.system.api.util;

/**
 * 编号自定义生成类
 * 雪花算法 Snowflakes
 */
public class SnowflakeGetId {
    private long workerId;
    private final long epoch = 1609459200000L; // 2021-01-01 00:00:00
    private long sequence = 0L;
    private final long workerIdBits = 10L;
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long sequenceBits = 12L;
    private final long workerIdShift = sequenceBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);
    private long lastTimestamp = -1L;

    // 构造函数，传入workerId
    public void SnowflakeIdGenerator(long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("Worker ID can't be greater than " + maxWorkerId + " or less than 0");
        }
        this.workerId = workerId;
    }

    // 生成ID的方法，传入输入字符串、单独编号和编号总长度
    public synchronized String getSnowflakesId(String input, long separateId, int totalLength) {
        long timestamp = System.currentTimeMillis();
        // 检查时间戳是否正常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
        }

        // 如果在同一毫秒内生成多个ID，则进行序列递增
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        // 生成唯一ID
        long id = ((timestamp - epoch) << timestampLeftShift) | (workerId << workerIdShift) | sequence;
        String idStr = String.valueOf(id);
        String separateIdStr = String.valueOf(separateId);
        int separateIdLength = separateIdStr.length();
        int idStrLength = idStr.length();
        int paddingLength = totalLength - separateIdLength - idStrLength;
        // 校验总长度是否足够
        if (paddingLength < 0) {
            throw new IllegalArgumentException("总长度不足以容纳分隔的ID");
        }
        StringBuilder result = new StringBuilder();
        result.append(input);
        // 填充0，保证总长度
        for (int i = 0; i < paddingLength; i++) {
            result.append("0");
        }
        result.append(separateIdStr);
        result.append(idStr);
        return result.toString();
    }

    // 等待下一个毫秒
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

//    public static void main(String[] args) {
//        SnowflakeGetId so = new SnowflakeGetId();
//        for (int i = 0; i < 10; i++) {
//            String id = so.getSnowflakesId("CG", 2222, 22);
//            System.out.println(id);
//        }
//
//    }
}
