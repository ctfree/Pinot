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
/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.linkedin.pinot.common.request;



/**
 * Filter Operator
 *
 */
public enum FilterOperator implements org.apache.thrift.TEnum {
  AND(0),
  OR(1),
  EQUALITY(2),
  NOT(3),
  RANGE(4),
  REGEX(5),
  IN(6),
  NOT_IN(7);

  private final int value;

  private FilterOperator(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static FilterOperator findByValue(int value) {
    switch (value) {
      case 0:
        return AND;
      case 1:
        return OR;
      case 2:
        return EQUALITY;
      case 3:
        return NOT;
      case 4:
        return RANGE;
      case 5:
        return REGEX;
      case 6:
        return IN;
      case 7:
        return NOT_IN;
      default:
        return null;
    }
  }
}
