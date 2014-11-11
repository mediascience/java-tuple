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
package com.msiops.footing.tuple;

public interface Sel {

    static <T> T _1(final Pair<T, ?> tup) {

        return tup._1;

    }

    static <T> T _1(final Triplet<T, ?, ?> tup) {

        return tup._1;

    }

    static <T> T _1(final Tuple4<T, ?, ?, ?> tup) {

        return tup._1;

    }

    static <T> T _1(final Tuple5<T, ?, ?, ?, ?> tup) {

        return tup._1;

    }

    static <T> T _2(final Pair<?, T> tup) {

        return tup._2;

    }

    static <T> T _2(final Triplet<?, T, ?> tup) {

        return tup._2;

    }

    static <T> T _2(final Tuple4<?, T, ?, ?> tup) {

        return tup._2;

    }

    static <T> T _2(final Tuple5<?, T, ?, ?, ?> tup) {

        return tup._2;

    }

    static <T> T _3(final Triplet<?, ?, T> tup) {

        return tup._3;

    }

    static <T> T _3(final Tuple4<?, ?, T, ?> tup) {

        return tup._3;

    }

    static <T> T _3(final Tuple5<?, ?, T, ?, ?> tup) {

        return tup._3;

    }

    static <T> T _4(final Tuple4<?, ?, ?, T> tup) {

        return tup._4;

    }

    static <T> T _4(final Tuple5<?, ?, ?, T, ?> tup) {

        return tup._4;

    }

    static <T> T _5(final Tuple5<?, ?, ?, ?, T> tup) {

        return tup._5;

    }

}
