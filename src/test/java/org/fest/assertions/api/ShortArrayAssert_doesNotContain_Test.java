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
 * Tests for {@link ShortArrayAssert#doesNotContain(short...)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ShortArrayAssert_doesNotContain_Test {
  @Rule
  public ExpectedException thrown = none();
  private short[] actual = {(short) 6, (short) 8, (short) 10};
  private short[] values = {(short) 2, (short) 4};
  private ShortArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new ShortArrayAssert(actual);
  }

  @Test
  public void should_pass_if_actual_does_not_contain_given_values() {
    assertions.doesNotContain(values);
  }

  @Test
  public void should_return_this_if_actual_does_not_contain_given_values() {
    assertions.doesNotContain(values);
  }

  @Test
  public void should_pass_if_actual_does_not_contain_given_values_multiple_times() {
    assertions.doesNotContain((short) 2, (short) 2, (short) 2, (short) 4);
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    assertions = new ShortArrayAssert(new short[0]);
    assertions.doesNotContain(values);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new ShortArrayAssert(null);
    assertions.doesNotContain(values);
  }

  @Test
  public void should_throw_error_if_given_values_is_null() {
    thrown.expect(AssertionError.class);
    values = null;
    assertions.doesNotContain(values);
  }

  @Test
  public void should_throw_error_if_given_values_is_empty() {
    thrown.expect(AssertionError.class);
    assertions.doesNotContain();
  }

  @Test
  public void should_fail_if_actual_contains_given_values() {
    thrown.expect(AssertionError.class);
    assertions.doesNotContain((short) 6, (short) 8);
  }
}
