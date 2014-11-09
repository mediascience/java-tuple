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
package example.com.msiops.footing.tuple;

import java.math.BigInteger;

import com.msiops.footing.functional.Fun3;
import com.msiops.footing.tuple.Pair;
import com.msiops.footing.tuple.Sel;
import com.msiops.footing.tuple.Tuple;
import com.msiops.footing.tuple.Tuple5;

public enum Example implements Runnable {

    CONSTRUCT {
        @Override
        public void run() {

            // @formatter:off
            
final Pair<String, Integer> pair = Tuple.of("Hello", 7);
assert pair._1.equals("Hello");
assert pair._2.intValue() == 7;

// max arity is 5
final Tuple5<Integer, Long, String, Object, BigInteger> t5 = Tuple
        .of(19, 200L, "Something", "Another",
                BigInteger.valueOf(15000));
assert t5._1.intValue() == 19;
assert t5._2.longValue() == 200L;
assert t5._3.equals("Something");
assert t5._4.equals("Another");
assert t5._5.equals(BigInteger.valueOf(15000));

// degenerate
assert Tuple.of("The Thing").equals("The Thing");

            // @formatter:on

        }
    },

    SLICE {

        @Override
        public void run() {

            // @formatter:off
            
// smaller
assert Tuple.of("one", "two", "three").slice(Sel::_3, Sel::_1)
        .equals(Tuple.of("three", "one"));

// bigger
assert Tuple.of("one", "two", "three")
        .slice(Sel::_3, Sel::_1, Sel::_2, Sel::_2)
        .equals(Tuple.of("three", "one", "two", "two"));

            // @formatter:on

        }
    },

    SPREAD {

        @Override
        public void run() {

            // @formatter:off
            
final Fun3<Integer, Integer, String, String> f = (i1, i2, l) -> (i1 + i2)
        + " " + l;

assert Tuple.of(7, 11, "Mice").spread(f).equals("18 Mice");

            // @formatter:on

        }

    }

    ;

}
