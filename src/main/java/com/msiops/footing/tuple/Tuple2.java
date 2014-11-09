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
package com.msiops.footing.tuple;

import java.util.Objects;
import java.util.function.Function;

public final class Tuple2<T1, T2> {

    public final T1 _1;

    public final T2 _2;

    Tuple2(final T1 t1, final T2 t2) {
        super();
        this._1 = Objects.requireNonNull(t1);
        this._2 = Objects.requireNonNull(t2);
    }

    @Override
    public boolean equals(final Object obj) {

        final boolean rval;
        if (obj == this) {
            rval = true;
        } else if (obj instanceof Tuple2) {
            rval = this._1.equals(((Tuple2<?, ?>) obj)._1)
                    && this._2.equals(((Tuple2<?, ?>) obj)._2);
        } else {
            rval = false;
        }
        return rval;

    }

    @Override
    public int hashCode() {

        return Objects.hash(this._1, this._2);

    }

    public <T> T slice(final Function<Tuple2<T1, T2>, T> sel) {
        return sel.apply(this);
    }

    public <T, U, V> Tuple3<T, U, V> slice(
            final Function<Tuple2<T1, T2>, T> sel1,
            final Function<Tuple2<T1, T2>, U> sel2,
            final Function<Tuple2<T1, T2>, V> sel3) {
        return new Tuple3<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this));
    }

    public <T, U> Tuple2<T, U> slice(final Function<Tuple2<T1, T2>, T> sel1,
            final Function<Tuple2<T1, T2>, U> sel2) {
        return new Tuple2<>(sel1.apply(this), sel2.apply(this));
    }

    public <T, U, V, W> Tuple4<T, U, V, W> slice(
            final Function<Tuple2<T1, T2>, T> sel1,
            final Function<Tuple2<T1, T2>, U> sel2,
            final Function<Tuple2<T1, T2>, V> sel3,
            final Function<Tuple2<T1, T2>, W> sel4) {
        return new Tuple4<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this), sel4.apply(this));
    }

    public <T, U, V, W, X> Tuple5<T, U, V, W, X> slice(
            final Function<Tuple2<T1, T2>, T> sel1,
            final Function<Tuple2<T1, T2>, U> sel2,
            final Function<Tuple2<T1, T2>, V> sel3,
            final Function<Tuple2<T1, T2>, W> sel4,
            final Function<Tuple2<T1, T2>, X> sel5) {
        return new Tuple5<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this), sel4.apply(this), sel5.apply(this));
    }

}
