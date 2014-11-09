/**
 * Licensed to Media Science International (MSI) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. MSI
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package fn.com.msiops.footing.tuple;

import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import com.msiops.footing.tuple.Tuple;
import com.msiops.footing.tuple.Tuple5;

public class UsageTest {

    private Instant now;

    @Before
    public void setup() {
        this.now = Instant.now();
    }

    @Test
    public void testConstruct5() {

        final Tuple5<Object, Integer, Long, String, Instant> t = Tuple.of(
                "Object", 7, 3L, "String", this.now);

        assertEquals("Object", t._1);
        assertEquals(Integer.valueOf(7), t._2);
        assertEquals(Long.valueOf(3), t._3);
        assertEquals("String", t._4);
        assertEquals(this.now, t._5);

    }

    @Test(expected = NullPointerException.class)
    public void testConstruct5Null1stIllegal() {

        Tuple.of(null, 7, 3L, "String", this.now);

    }

    @Test(expected = NullPointerException.class)
    public void testConstruct5Null2ndIllegal() {

        Tuple.of("Object", null, 3L, "String", this.now);

    }

    @Test(expected = NullPointerException.class)
    public void testConstruct5Null3rdIllegal() {

        Tuple.of("Object", 7, null, "String", this.now);

    }

    @Test(expected = NullPointerException.class)
    public void testConstruct5Null4thIllegal() {

        Tuple.of("Object", 7, 3L, null, this.now);

    }

    @Test(expected = NullPointerException.class)
    public void testConstruct5Null5thIllegal() {

        Tuple.of("Object", 7, 3L, "String", null);

    }

}
