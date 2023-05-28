package org.hlr.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;

public class MyRangeDBShardingAlogorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {

//        Long lowerEndpoint = rangeShardingValue.getValueRange().lowerEndpoint();
//        Long upperEndpoint = rangeShardingValue.getValueRange().upperEndpoint();

        return collection;
    }
}
