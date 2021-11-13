package com.leverx.game.enums;

/**
 * The enum of game figure.
 */
public enum GameFigure {
  /**
   * Undefined game figure.
   */
  UNDEFINED(AreaElement.UNDEFINED),
  /**
   * X game figure.
   */
  X(AreaElement.X),
  /**
   * O game figure.
   */
  O(AreaElement.O);

  private final AreaElement areaElement;

  GameFigure(AreaElement areaElement) {
    this.areaElement = areaElement;
  }

  public AreaElement getGameSide() {
    return areaElement;
  }

  @Override
  public String toString() {
    return areaElement.toString();
  }
}
