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

import org.junit.Before;
import org.junit.Test;

import com.msiops.footing.functional.Fun2;
import com.msiops.footing.tuple.Pair;
import com.msiops.footing.tuple.Sel;
import com.msiops.footing.tuple.Tuple;

public class Tuple2UsageTest {

    private Object v1;

    private Integer v2;

    @Before
    public void setup() {
        this.v1 = "Object";
        this.v2 = 7;
    }

    @Test
    public void spreadTest() {

        final String expected = new StringBuilder().append(this.v1)
                .append(this.v2).toString();

        final Fun2<Object, Integer, String> f = (t1, t2) -> {
            return new StringBuilder().append(t1).append(t2).toString();
        };

        final String actual = Tuple.of(this.v1, this.v2).spread(f);

        assertEquals(expected, actual);

    }

    @Test
    public void testConstruct() {

        final Pair<Object, Integer> t = Tuple.of(this.v1, this.v2);

        assertEquals(this.v1, t._1);
        assertEquals(this.v2, t._2);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructNull1stIllegal() {

        Tuple.of(null, this.v2);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructNull2ndIllegal() {

        Tuple.of(this.v1, null);

    }

    @Test
    public void testSlice1() {

        assertEquals(this.v2, Tuple.of(this.v1, this.v2).slice(Sel::_2));

    }

    @Test
    public void testSlice2() {

        assertEquals(Tuple.of(this.v2, this.v1), Tuple.of(this.v1, this.v2)
                .slice(Sel::_2, Sel::_1));

    }

    @Test
    public void testSlice3() {

        assertEquals(Tuple.of(this.v2, this.v1, this.v1),
                Tuple.of(this.v1, this.v2).slice(Sel::_2, Sel::_1, Sel::_1));

    }

    @Test
    public void testSlice4() {

        assertEquals(
                Tuple.of(this.v1, this.v2, this.v1, this.v1),
                Tuple.of(this.v1, this.v2).slice(Sel::_1, Sel::_2, Sel::_1,
                        Sel::_1));

    }

    @Test
    public void testSlice5() {

        assertEquals(
                Tuple.of(this.v1, this.v2, this.v1, this.v1, this.v2),
                Tuple.of(this.v1, this.v2).slice(Sel::_1, Sel::_2, Sel::_1,
                        Sel::_1, Sel::_2));

    }

}
