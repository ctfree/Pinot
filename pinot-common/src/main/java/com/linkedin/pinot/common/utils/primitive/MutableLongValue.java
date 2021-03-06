/**
 * Copyright (C) 2014-2015 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.common.utils.primitive;

import java.io.Serializable;


/**
 * Simple wrapper for a mutable long value.
 */
public class MutableLongValue extends Number implements Serializable, Comparable<MutableLongValue> {
  private long value;

  public MutableLongValue(long value) {
    this.value = value;
  }

  public MutableLongValue() {
    value = 0L;
  }

  @Override
  public int intValue() {
    return (int) value;
  }

  @Override
  public long longValue() {
    return value;
  }

  @Override
  public float floatValue() {
    return value;
  }

  @Override
  public double doubleValue() {
    return value;
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }

  public void addToValue(long otherValue) {
    value += otherValue;
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }

  @Override
  public int compareTo(MutableLongValue o) {
    return Long.compare(value, o.value);
  }
}
