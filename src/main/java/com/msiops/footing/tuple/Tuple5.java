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

import java.util.Objects;
import java.util.function.Function;

import com.msiops.footing.functional.Fun5;

public final class Tuple5<T1, T2, T3, T4, T5> {

    public final T1 _1;

    public final T2 _2;

    public final T3 _3;

    public final T4 _4;

    public final T5 _5;

    Tuple5(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5) {
        super();
        this._1 = Objects.requireNonNull(t1);
        this._2 = Objects.requireNonNull(t2);
        this._3 = Objects.requireNonNull(t3);
        this._4 = Objects.requireNonNull(t4);
        this._5 = Objects.requireNonNull(t5);
    }

    @Override
    public boolean equals(final Object obj) {

        final boolean rval;
        if (obj == this) {
            rval = true;
        } else if (obj instanceof Tuple5) {
            rval = this._1.equals(((Tuple5<?, ?, ?, ?, ?>) obj)._1)
                    && this._2.equals(((Tuple5<?, ?, ?, ?, ?>) obj)._2)
                    && this._3.equals(((Tuple5<?, ?, ?, ?, ?>) obj)._3)
                    && this._4.equals(((Tuple5<?, ?, ?, ?, ?>) obj)._4)
                    && this._5.equals(((Tuple5<?, ?, ?, ?, ?>) obj)._5);
        } else {
            rval = false;
        }
        return rval;

    }

    @Override
    public int hashCode() {

        return Objects.hash(this._1, this._2, this._3, this._4, this._5);

    }

    public <T> T slice(final Function<Tuple5<T1, T2, T3, T4, T5>, T> sel) {
        return sel.apply(this);
    }

    public <T, U> Pair<T, U> slice(
            final Function<Tuple5<T1, T2, T3, T4, T5>, T> sel1,
            final Function<Tuple5<T1, T2, T3, T4, T5>, U> sel2) {
        return new Pair<>(sel1.apply(this), sel2.apply(this));
    }

    public <T, U, V> Triplet<T, U, V> slice(
            final Function<Tuple5<T1, T2, T3, T4, T5>, T> sel1,
            final Function<Tuple5<T1, T2, T3, T4, T5>, U> sel2,
            final Function<Tuple5<T1, T2, T3, T4, T5>, V> sel3) {
        return new Triplet<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this));
    }

    public <T, U, V, W> Tuple4<T, U, V, W> slice(
            final Function<Tuple5<T1, T2, T3, T4, T5>, T> sel1,
            final Function<Tuple5<T1, T2, T3, T4, T5>, U> sel2,
            final Function<Tuple5<T1, T2, T3, T4, T5>, V> sel3,
            final Function<Tuple5<T1, T2, T3, T4, T5>, W> sel4) {
        return new Tuple4<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this), sel4.apply(this));
    }

    public <T, U, V, W, X> Tuple5<T, U, V, W, X> slice(
            final Function<Tuple5<T1, T2, T3, T4, T5>, T> sel1,
            final Function<Tuple5<T1, T2, T3, T4, T5>, U> sel2,
            final Function<Tuple5<T1, T2, T3, T4, T5>, V> sel3,
            final Function<Tuple5<T1, T2, T3, T4, T5>, W> sel4,
            final Function<Tuple5<T1, T2, T3, T4, T5>, X> sel5) {
        return new Tuple5<>(sel1.apply(this), sel2.apply(this),
                sel3.apply(this), sel4.apply(this), sel5.apply(this));
    }

    public <R> R spread(
            final Fun5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, R> f) {
        return f.apply(this._1, this._2, this._3, this._4, this._5);
    }

    @Override
    public String toString() {
        return new StringBuilder().append('(').append(this._1).append(',')
                .append(this._2).append(',').append(this._3).append(',')
                .append(this._4).append(',').append(this._5).append(')')
                .toString();
    }

}
