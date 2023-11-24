package com.ruoyi.system.api.util;

import com.ruoyi.system.api.domain.PublicCodeRules;

import javax.security.auth.Subject;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编号自定义生成类
 * 雪花算法 Snowflakes
 */
public class SnowflakeGetId {
    // 雪花算法的参数
    private final long twepoch = 1288834974657L;
    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private final long sequenceBits = 12L;
    private final long workerIdShift = sequenceBits;
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    // 储存时间编号流水集合
    Map<Long, Map<String, String>> codeRulesMap = new HashMap<>();

    // 构造函数，初始化workerId和datacenterId
    public SnowflakeGetId(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("Worker ID can't be greater than " + maxWorkerId + " or less than 0");
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException("Datacenter ID can't be greater than " + maxDatacenterId + " or less than 0");
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    // 生成下一个ID
    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    // 获取当前时间
    private long timeGen() {
        return System.currentTimeMillis();
    }

    // 等待下一个毫秒
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 获取编码
     * @param rules
     * @return
     */
    public String getCode(PublicCodeRules rules) {
        if (rules.getCodingRules() == 1)
            return getSnowflake(rules);
        else
            return getTime(rules);
    }

    /**
     * 雪花算法生成编号
     *
     * @param rules 规则对象
     * @return 编号
     */
    public String getSnowflake(PublicCodeRules rules) {
        // 总长度 = 前缀长度 + id长度
        StringBuffer sb = new StringBuffer(rules.getPrefixs()); // 添加前缀
        long id = nextId(); // 获取随机ID
        int idLen = String.valueOf(id).length(); // id长度
        int qzLen = rules.getPrefixs().length(); // 前缀长度
        int num = (int) (idLen - (rules.getLengths() - qzLen));
        if (num > 0) { // 从id前面去掉多出来的数字
            sb.append(String.valueOf(id).substring(num));
        } else if (num < 0) {
            Random random = new Random();
            String x = String.valueOf(num).substring(1); // 总长度超过id时在末尾添加对应的随机数
            sb.append(id);
            for (int i = 0; i < Integer.parseInt(x); i++) {
                sb.append(random.nextInt(10));
            }
        } else {
            sb.append(id);
        }
        return sb.toString();
    }

    /**
     * 时间算法生成编号
     */
    public String getTime(PublicCodeRules rules) {
        StringBuffer sb = new StringBuffer(rules.getPrefixs()); // 添加前缀
        sb.append(convertToTime(rules.getTimeRules())); // 添加对应时间

        // id 流水长度 最新流水号
        // 初始化当前集合
        Map<String, String> codeList = codeRulesMap.get(rules.getCodeRulesId());
        if (codeList == null) {
            codeList = new HashMap<String, String>();
            codeList.put("len", rules.getLengths().toString());
            codeList.put("liu", getNumber(rules.getLengths()));
            codeRulesMap.put(rules.getCodeRulesId(), null);
        } else if (!rules.getLengths().toString().equals(codeList.get("len"))) {
            codeList.put("len", rules.getLengths().toString());
            codeList.put("liu", getNumber(rules.getLengths()));
            System.out.println();
        }
        int liu = Integer.parseInt(codeList.get("liu"));
        liu++;
        if (!codeList.get("len").equals(codeList.get("liu"))) {
            codeList.put("liu", String.format("%05d", liu));
        } else { // 999后重新递增
            codeList.put("liu", getNumber(rules.getLengths()));
        }
        sb.append(codeList.get("liu"));
        codeRulesMap.put(rules.getCodeRulesId(), codeList);
        return sb.toString();
    }

    /**
     * 添零
     */
    public String getNumber(Long num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < num; i++) {
            sb.append("0");
        }
        return sb.append("1").toString();
    }

    public static String convertToTime(String timeRules) {
        String[] rules = timeRules.split(",");
        Map<String, String> timeValues = getTimeValues(rules);
        String num = timeValues.get("YYYY") + "" + timeValues.get("MM") + "" + timeValues.get("DD") + "" +
                timeValues.get("hh") + "" + timeValues.get("mm") + "" + timeValues.get("ss");

        return num.replace("null", "");
    }

    public static Map<String, String> getTimeValues(String[] rules) {
        Date currentDate = new Date();
        Map<String, String> timeValues = new HashMap<>();
        for (String rule : rules) {
            String timeValue = getTimeValue(currentDate, rule);
            if (timeValue == null) {
                timeValue = "";
            }
            timeValues.put(rule, timeValue);
        }
        return timeValues;
    }

    public static String getTimeValue(Date date, String rule) {
        SimpleDateFormat formatter = new SimpleDateFormat(getDateFormat(rule));
        return formatter.format(date);
    }

    public static String getDateFormat(String rule) {
        switch (rule) {
            case "YYYY":
                return "yyyy";
            case "MM":
                return "MM";
            case "DD":
                return "dd";
            case "hh":
                return "HH";
            case "mm":
                return "mm";
            case "ss":
                return "ss";
            default:
                return "";
        }
    }


    public static void main(String[] args) {
        // 调用查询方法，根据ID查询对应数据
        PublicCodeRules publicCodeRules = new PublicCodeRules();
        // 初始化工具类
        SnowflakeGetId so = new SnowflakeGetId(1, 1);
        // 调用方法
        String id = so.getCode(publicCodeRules);
    }
}
