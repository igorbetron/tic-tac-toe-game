package com.leverx.game.classes;

import com.leverx.game.enums.AreaElement;

/**
 * Defines game area
 *
 * @author Igor Rabcew
 * @version 0.1
 * @since 0.1
 */
public class GameArea {

  private final AreaElement[][] area;

  /**
   * Instantiates a new Game area.
   *
   * @param areaWidth  the area width
   * @param areaHeight the area height
   */
  public GameArea(int areaWidth, int areaHeight) {
    area = new AreaElement[areaWidth][areaHeight];

    for (int i = 0; i < areaHeight; i++) {
      for (int j = 0; j < areaHeight; j++) {
        area[i][j] = AreaElement.UNDEFINED;
      }
    }
  }

  /**
   * {@return true if area is full}
   */
  public boolean isFull() {
    for (int i = 0; i < area.length; i++) {
      for (int j = 0; j < area[i].length; j++) {
        if (area[i][j] == AreaElement.UNDEFINED) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Get game area.
   *
   * @return the game area elements
   */
  public AreaElement[][] getArea() {
    return area;
  }
}
