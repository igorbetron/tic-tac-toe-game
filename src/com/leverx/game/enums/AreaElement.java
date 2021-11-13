package com.leverx.game.enums;

/**
 * The enum of area elements.
 */
public enum AreaElement {
  /**
   * Undefined game side.
   */
  UNDEFINED("| * |"),
  /**
   * X game side.
   */
  X("| X |"),
  /**
   * O game side.
   */
  O("| O |");

  private final String label;

  AreaElement(String elementLabel) {
    this.label = elementLabel;
  }

  @Override
  public String toString() {
    return label;
  }
}
