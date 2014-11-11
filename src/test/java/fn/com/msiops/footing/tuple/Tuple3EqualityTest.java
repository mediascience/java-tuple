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
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.msiops.footing.tuple.Triplet;
import com.msiops.footing.tuple.Tuple;

public class Tuple3EqualityTest {

    private Triplet<?, ?, ?> control, equivalent;

    private Collection<Triplet<?, ?, ?>> diffs;

    private Object v1, v2, v3;

    @Before
    public void setup() {

        this.v1 = Instant.now();
        this.v2 = "String";
        this.v3 = new Object();

        this.control = Tuple.of(this.v1, this.v2, this.v3);
        this.equivalent = Tuple.of(this.v1, this.v2, this.v3);

        this.diffs = new ArrayList<>();

        this.diffs.add(Tuple.of(new Object(), this.v2, this.v3));
        this.diffs.add(Tuple.of(this.v1, new Object(), this.v3));
        this.diffs.add(Tuple.of(this.v1, this.v2, new Object()));

    }

    @Test
    public void testEquivalent() {
        assertTrue(this.control.equals(this.equivalent));
    }

    @Test
    public void testHashEquivalent() {
        assertEquals(this.control.hashCode(), this.equivalent.hashCode());
    }

    @Test
    public void testNotEqualArbitrary() {
        assertFalse(this.control.equals(new Object()));
    }

    @Test
    public void testNotEqualNull() {
        assertFalse(this.control.equals(null));
    }

    @Test
    public void testReflexive() {
        assertTrue(this.control.equals(this.control));
    }

    @Test
    public void testRepeatableHash() {
        assertEquals(this.control.hashCode(), this.control.hashCode());
    }

    @Test
    public void testSymmetric() {
        assertTrue(this.equivalent.equals(this.control));
    }

    @Test
    public void testUnequal() {
        for (final Triplet<?, ?, ?> d : this.diffs) {
            assertFalse("{" + this.control + "} neq {" + d + "}",
                    this.control.equals(d));
            assertFalse("{" + d + "} neq {" + this.control + "}",
                    d.equals(this.control));
        }
    }

}
