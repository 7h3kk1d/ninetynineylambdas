package com.thekkid.ninetyninelambdas.problems;

import com.jnape.palatable.lambda.adt.hlist.Tuple2;
import com.jnape.palatable.lambda.functions.builtin.fn2.Zip;

import static com.jnape.palatable.lambda.functions.Fn2.fn2;
import static com.jnape.palatable.lambda.functions.builtin.fn1.Not.not;
import static com.jnape.palatable.lambda.functions.builtin.fn2.CmpEq.cmpEq;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Filter.filter;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Iterate.iterate;
import static com.jnape.palatable.lambda.functions.builtin.fn2.Map.map;

/**
 * Remove the K'th element from a list
 */
public class Twenty {
    public static <T> Iterable<T> twenty(long n, Iterable<T> ts) {
        return Zip.<Long, T>zip(iterate(fn2(Long::sum).apply(1L), 1L))
                .fmap(filter(not(cmpEq(n).contraMap(Tuple2::_1))))
                .fmap(map(Tuple2::_2))
                .apply(ts);
    }
}