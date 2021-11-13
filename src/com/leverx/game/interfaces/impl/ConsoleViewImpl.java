package com.leverx.game.interfaces.impl;

import com.leverx.game.classes.GameArea;
import com.leverx.game.enums.AreaElement;
import com.leverx.game.enums.GameState;
import com.leverx.game.interfaces.View;

/**
 * Defines console view for the concrete game
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see View
 * @since 0.1
 */
public class ConsoleViewImpl implements View {

  @Override
  public void showResult(GameArea gameArea, GameState gameState) {
    AreaElement[][] area = gameArea.getArea();

    System.out.println("Current state of this game is: " + gameState);

    for (int i = 0; i < area.length; i++) {
      for (int j = 0; j < area[i].length; j++) {
        System.out.print(area[i][j]);
      }
      System.out.println();
    }
  }

  @Override
  public void showRules(String rulesMessage) {
    System.out.println(rulesMessage);
  }
}
