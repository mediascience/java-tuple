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

import org.junit.Before;
import org.junit.Test;

import com.msiops.footing.tuple.Tuple;

public class DegenerateUsageTest {

    private Object v1;

    @Before
    public void setup() {
        this.v1 = "Object";
    }

    @Test
    public void testDegenerateTuple() {

        assertEquals(this.v1, Tuple.of(this.v1));

    }

}
