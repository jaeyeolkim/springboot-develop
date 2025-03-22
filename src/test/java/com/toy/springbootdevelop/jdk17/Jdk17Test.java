package com.toy.springbootdevelop.jdk17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Jdk17Test {

    @Test
    public void recordTest() {
        ItemRecord juice = new ItemRecord("juice", 3_000);
        Assertions.assertThat(juice.name()).isEqualTo("juice");
    }

    @Test
    public void instanceOfTest() {
        Object object = new ItemRecord("juice", 3_000);
        if (object instanceof ItemRecord juice) {
            System.out.println("juice = " + juice.name());
        }
    }
}
