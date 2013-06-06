/*
 * Created on Mar 29, 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2013 the original author or authors.
 */
package org.fest.assertions.api;

import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.test.ExpectedException.none;

/**
 * Tests for {@link LongArrayAssert#contains(long...)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class LongArrayAssert_contains_Test {
  @Rule
  public ExpectedException thrown = none();
  private long[] actual = {1, 2, 3, 4, 5, 6};
  private long[] values = {5, 6};
  private LongArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new LongArrayAssert(actual);
  }

  @Test
  public void should_pass_if_actual_contains_given_values() {
    assertions.contains(values);
  }

  @Test
  public void should_pass_if_actual_contains_given_values_multiple_times() {
    values = new long[]{5, 5, 6, 6};
    assertions.contains(values);
  }

  @Test
  public void should_pass_if_both_actual_and_given_values_are_empty() {
    assertions = new LongArrayAssert(new long[0]);
    assertions.contains(new long[0]);
  }

  @Test
  public void should_return_this_if_actual_contains_given_value() {
    assertions.contains(values);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new LongArrayAssert(null);
    assertions.contains();
  }

  @Test
  public void should_throw_error_if_given_values_is_null() {
    thrown.expect(AssertionError.class);
    assertions.contains(null);
  }

  @Test
  public void should_throw_error_if_given_values_is_empty() {
    thrown.expect(AssertionError.class);
    assertions.contains(new long[0]);
  }
}
