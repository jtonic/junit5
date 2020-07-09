package ro.jtonic.testing.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig(Junit5ApplicationTests.Config.class)
class Junit5ApplicationTests {

  @Configuration
  static class Config {}

	@Test
	void contextLoads() {
	}

	@Test
  // @DisabledIfSystemProperty(named = "test.locally", matches = "false")
  @DisabledIf("#{systemProperties['test.locally'] == null || systemProperties['test.locally'].equals('false')}")
  void disabledLocally() {
    Assertions.fail("Should be disabled locally!!!!");
  }
}
