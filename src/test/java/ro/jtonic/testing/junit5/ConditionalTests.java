package ro.jtonic.testing.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

public class ConditionalTests {

  @Test
  @DisabledIfSystemProperty(named = "test.locally", matches = "false")
  void disabledLocally() {
    Assertions.fail("Should be disabled locally!!!");
  }
}
