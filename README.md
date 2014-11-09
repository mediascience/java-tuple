Tuples for Java
===============

[![Build Status](https://travis-ci.org/mediascience/java-tuple.svg)](https://travis-ci.org/mediascience/java-tuple)

Tuples mainly to support multi-value function
return. Features include:

* arity to five
* spread
* slice

## Usage

### Include Dependencies
```xml
<dependency>
    <groupId>com.msiops.footing</groupId>
    <artifactId>footing-tuple</artifactId>
    <version>${v.tuple}</version>
</dependency>
```
See [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%20%22com.msiops.footing%22%20a%3A%22footing-tuple%22) for latest version.


### Construct

```java
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
```


### Slice

```java
// smaller
assert Tuple.of("one", "two", "three").slice(Sel::_3, Sel::_1)
        .equals(Tuple.of("three", "one"));

// bigger
assert Tuple.of("one", "two", "three")
        .slice(Sel::_3, Sel::_1, Sel::_2, Sel::_2)
        .equals(Tuple.of("three", "one", "two", "two"));
```

### Spread

```java
final Fun3<Integer, Integer, String, String> f = (i1, i2, l) -> (i1 + i2)
        + " " + l;

assert Tuple.of(7, 11, "Mice").spread(f).equals("18 Mice");
```


## Versioning

Releases in the 0.x series are the Wild West. Anything can change between
releases--package names, method signatures, behavior, whatever. But if you
like it as it is right now, all the tests pass so just use it at its current
version and have fun.

The next version series will be 1.x. Every release in that series will be
backward compatible with every lower-numbered release in the same series
except possibly in the case of 1) a bug fix or 2) a correction to an
underspecification.

An incompatible change to the interface, behavior, license, or anything else
after the 1.x series is published will result in a new series, such as
2.x.

## Acknowledgements

Inspired by Haskell and Go

Media Science International makes this all possible.

## License

Licensed to Media Science International (MSI) under one or more
contributor license agreements. See the NOTICE file distributed with this
work for additional information regarding copyright ownership. MSI
licenses this file to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance with the
License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations
under the License.


