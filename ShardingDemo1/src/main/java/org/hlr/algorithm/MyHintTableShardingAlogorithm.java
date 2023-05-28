package org.hlr.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Arrays;
import java.util.Collection;

public class MyHintTableShardingAlogorithm implements HintShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<Integer> hintShardingValue) {

        String key = "course_" + hintShardingValue.getValues().toArray()[0];
        if(collection.contains(key)){
            return Arrays.asList(key);
        }

        throw new UnsupportedOperationException("hint route[" + key + "]is not supported. please check your config");
    }
}
