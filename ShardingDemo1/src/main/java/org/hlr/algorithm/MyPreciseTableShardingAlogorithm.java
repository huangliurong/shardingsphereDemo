package org.hlr.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

public class MyPreciseTableShardingAlogorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        BigInteger shardingValueB = BigInteger.valueOf(preciseShardingValue.getValue());
//        BigInteger resB = (shardingValueB.mod(new BigInteger("2")).add(new BigInteger("1")).divide(new BigInteger("2")));
        BigInteger resB = (shardingValueB.mod(new BigInteger("2")).add(new BigInteger("1")));
        String key = preciseShardingValue.getLogicTableName() + "_" + resB;
        if (collection.contains(key)){
            return key;
        }
        throw new UnsupportedOperationException("table route[" + key + "]is not supported. please check your config");
    }
}
