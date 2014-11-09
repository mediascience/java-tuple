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

import com.msiops.footing.functional.Fun4;

public final class Tuple4<T1, T2, T3, T4> {

    public final T1 _1;

    public final T2 _2;

    public final T3 _3;

    public final T4 _4;

    Tuple4(final T1 t1, final T2 t2, final T3 t3, final T4 t4) {
        super();
        this._1 = Objects.requireNonNull(t1);
        this._2 = Objects.requireNonNull(t2);
        this._3 = Objects.requireNonNull(t3);
        this._4 = Objects.requireNonNull(t4);
    }

    @Override
    public boolean equals(final Object obj) {

        final boolean rval;
        if (obj == this) {
            rval = true;
        } else if (obj instanceof Tuple4) {
            rval = this._1.equals(((Tuple4<?, ?, ?, ?>) obj)._1)
                    && this._2.equals(((Tuple4<?, ?, ?, ?>) obj)._2)
                    && this._3.equals(((Tuple4<?, ?, ?, ?>) obj)._3)
                    && this._4.equals(((Tuple4<?, ?, ?, ?>) obj)._4);
        } else {
            rval = false;
        }
        return rval;

    }

    @Override
    public int hashCode() {

        return Objects.hash(this._1, this._2, this._3, this._4);

    }

    public <T> T slice(final Function<Tuple4<T1, T2, T3, T4>, T> sel) {
        return sel.apply(this);
    }

    public <T, U> Pair<T, U> slice(
            final Function<Tuple4<T1, T2, T3, T4>, T> sel1,
            final Function<Tuple4<T1, T2, T3, T4>, U> sel2) {
        return new Pair<>(sel1.apply(this), sel2.apply(this));
    }

    public <T, U, V> Triplet<T, U, V> slice(
            final Function<Tuple4<T1, T2, T3, T4>, T> sel1,
            final Function<Tuple4<T1, T2, T3, T4>, U> sel2,
            final Function<Tuple4<T1, T2, T3, T4>, V> sel3) {
        return new Triplet<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this));
    }

    public <T, U, V, W> Tuple4<T, U, V, W> slice(
            final Function<Tuple4<T1, T2, T3, T4>, T> sel1,
            final Function<Tuple4<T1, T2, T3, T4>, U> sel2,
            final Function<Tuple4<T1, T2, T3, T4>, V> sel3,
            final Function<Tuple4<T1, T2, T3, T4>, W> sel4) {
        return new Tuple4<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this), sel4.apply(this));
    }

    public <T, U, V, W, X> Tuple5<T, U, V, W, X> slice(
            final Function<Tuple4<T1, T2, T3, T4>, T> sel1,
            final Function<Tuple4<T1, T2, T3, T4>, U> sel2,
            final Function<Tuple4<T1, T2, T3, T4>, V> sel3,
            final Function<Tuple4<T1, T2, T3, T4>, W> sel4,
            final Function<Tuple4<T1, T2, T3, T4>, X> sel5) {
        return new Tuple5<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this), sel4.apply(this), sel5.apply(this));
    }

    public <R> R spread(
            final Fun4<? super T1, ? super T2, ? super T3, ? super T4, R> f) {
        return f.apply(this._1, this._2, this._3, this._4);
    }

}
