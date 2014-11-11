/**
 * Licensed under the Apache License, Version 2.0 (the "License") under
 * one or more contributor license agreements. See the NOTICE file
 * distributed with this work for information regarding copyright
 * ownership. You may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fn.com.msiops.footing.tuple;

import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

import com.msiops.footing.functional.Fun5;
import com.msiops.footing.tuple.Sel;
import com.msiops.footing.tuple.Tuple;
import com.msiops.footing.tuple.Tuple5;

public class Tuple5UsageTest {

    private Object v1;

    private Integer v2;

    private Long v3;

    private String v4;

    private Instant v5;

    @Before
    public void setup() {
        this.v1 = "Object";
        this.v2 = 7;
        this.v3 = 3L;
        this.v4 = "String";
        this.v5 = Instant.now();
    }

    @Test
    public void spreadTest() {

        final String expected = new StringBuilder().append(this.v1)
                .append(this.v2).append(this.v3).append(this.v4)
                .append(this.v5).toString();

        final Fun5<Object, Integer, Long, String, Instant, String> f = (t1, t2,
                t3, t4, t5) -> {
            return new StringBuilder().append(t1).append(t2).append(t3)
                    .append(t4).append(t5).toString();
        };

        final String actual = Tuple.of(this.v1, this.v2, this.v3, this.v4,
                this.v5).spread(f);

        assertEquals(expected, actual);

    }

    @Test
    public void testConstruct() {

        final Tuple5<Object, Integer, Long, String, Instant> t = Tuple.of(
                this.v1, this.v2, this.v3, this.v4, this.v5);

        assertEquals(this.v1, t._1);
        assertEquals(this.v2, t._2);
        assertEquals(this.v3, t._3);
        assertEquals(this.v4, t._4);
        assertEquals(this.v5, t._5);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructNull1stIllegal() {

        Tuple.of(null, this.v2, this.v3, this.v4, this.v5);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructNull2ndIllegal() {

        Tuple.of(this.v1, null, this.v3, this.v4, this.v5);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructNull3rdIllegal() {

        Tuple.of(this.v1, this.v2, null, this.v4, this.v5);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructNull4thIllegal() {

        Tuple.of(this.v1, this.v2, this.v3, null, this.v5);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructNull5thIllegal() {

        Tuple.of(this.v1, this.v2, this.v3, this.v4, null);

    }

    @Test
    public void testSlice1() {

        assertEquals(
                this.v4,
                Tuple.of(this.v1, this.v2, this.v3, this.v4, this.v5).slice(
                        Sel::_4));

    }

    @Test
    public void testSlice2() {

        assertEquals(
                Tuple.of(this.v5, this.v1),
                Tuple.of(this.v1, this.v2, this.v3, this.v4, this.v5).slice(
                        Sel::_5, Sel::_1));

    }

    @Test
    public void testSlice3() {

        assertEquals(
                Tuple.of(this.v5, this.v1, this.v3),
                Tuple.of(this.v1, this.v2, this.v3, this.v4, this.v5).slice(
                        Sel::_5, Sel::_1, Sel::_3));

    }

    @Test
    public void testSlice4() {

        assertEquals(
                Tuple.of(this.v5, this.v1, this.v3, this.v3),
                Tuple.of(this.v1, this.v2, this.v3, this.v4, this.v5).slice(
                        Sel::_5, Sel::_1, Sel::_3, Sel::_3));

    }

    @Test
    public void testSlice5() {

        assertEquals(
                Tuple.of(this.v5, this.v1, this.v3, this.v3, this.v4),
                Tuple.of(this.v1, this.v2, this.v3, this.v4, this.v5).slice(
                        Sel::_5, Sel::_1, Sel::_3, Sel::_3, Sel::_4));

    }

}
