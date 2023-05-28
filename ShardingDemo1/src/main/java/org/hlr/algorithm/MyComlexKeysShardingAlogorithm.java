package org.hlr.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

public class MyComlexKeysShardingAlogorithm implements ComplexKeysShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Long> complexKeysShardingValue) {

        Collection<Long> idCol = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("id");
        Range<Long> ageRange = complexKeysShardingValue.getColumnNameAndRangeValuesMap().get("age");

        Collection<String> result = new ArrayList<>();

        //id
        for (Long id : idCol) {
            BigInteger idI = BigInteger.valueOf(id);
            BigInteger add = idI.mod(BigInteger.valueOf(2L)).add(new BigInteger("1"));
            result.add("course_" + add);
        }

        //range
        Long lowerEndpoint = ageRange.lowerEndpoint();
        Long upperEndpoint = ageRange.upperEndpoint();


        return result;
    }
}
