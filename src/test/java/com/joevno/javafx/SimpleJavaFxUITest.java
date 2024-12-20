package com.joevno.javafx;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

/**
 * Unit tests.
 *
 * @see SimpleJavaFxUI
 */
class SimpleJavaFxUITest extends ApplicationTest {
  private Label label;
  private Button button;

  @Override
  public void start(Stage stage) {
    val app = new SimpleJavaFxUI();
    app.start(stage);

    label = lookup(".label").query();
    button = lookup(".button").query();
  }

  @Test
  void testButtonClickChangesLabelText() {
    clickOn(button);
    assertEquals("Button Clicked", label.getText());
  }
}
