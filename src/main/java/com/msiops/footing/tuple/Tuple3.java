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

public final class Tuple3<T1, T2, T3> {

    public final T1 _1;

    public final T2 _2;

    public final T3 _3;

    Tuple3(final T1 t1, final T2 t2, final T3 t3) {
        super();
        this._1 = Objects.requireNonNull(t1);
        this._2 = Objects.requireNonNull(t2);
        this._3 = Objects.requireNonNull(t3);
    }

    @Override
    public boolean equals(final Object obj) {

        final boolean rval;
        if (obj == this) {
            rval = true;
        } else if (obj instanceof Tuple3) {
            rval = this._1.equals(((Tuple3<?, ?, ?>) obj)._1)
                    && this._2.equals(((Tuple3<?, ?, ?>) obj)._2)
                    && this._3.equals(((Tuple3<?, ?, ?>) obj)._3);
        } else {
            rval = false;
        }
        return rval;

    }

    @Override
    public int hashCode() {

        return Objects.hash(this._1, this._2, this._3);

    }

    public <T> T slice(final Function<Tuple3<T1, T2, T3>, T> sel) {
        return sel.apply(this);
    }

}
