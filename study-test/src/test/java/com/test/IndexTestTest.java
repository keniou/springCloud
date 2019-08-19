package com.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huangfeichang.
 * @date 2019/8/8 0008.
 */
public class IndexTestTest {

    @Test
    public void mm() {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            System.err.println("1-->" + a);
            ++a;
        }
        System.err.println(1 + a);
    }
}
