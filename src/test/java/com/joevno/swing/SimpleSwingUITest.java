package com.joevno.swing;

import lombok.val;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests.
 *
 * @see SimpleSwingUI
 */
class SimpleSwingUITest {
  private FrameFixture window;

  @BeforeEach
  public void setUp() {
    val frame = GuiActionRunner.execute(SimpleSwingUI::newInstance);
    window = new FrameFixture(frame);
    window.show(); // shows the frame to test
  }

  @AfterEach
  public void tearDown() {
    window.cleanUp();
  }

  @Test
  @SuppressWarnings("java:S2699")
  void testButtonClickChangesLabelText() {
    window.button().click();
    window.label().requireText("Button Clicked");
  }
}
