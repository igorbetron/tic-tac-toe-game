package com.leverx.game.classes.impl;

import com.leverx.game.classes.GameArea;
import com.leverx.game.classes.Player;
import com.leverx.game.enums.AreaElement;
import com.leverx.game.enums.GameFigure;
import com.leverx.game.enums.PlayerType;
import java.util.Random;
import java.util.Scanner;

/**
 * Defines AI game player
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see Player
 * @since 0.1
 */
public class AiPlayerImpl extends Player {

  /**
   * Instantiates a new Ai player.
   */
  public AiPlayerImpl() {
    super();
    this.setPlayerType(PlayerType.AI_PLAYER);
    this.setPlayerFigure(GameFigure.O);
  }

  @Override
  public void play(Scanner scanner, GameArea gameArea) {

    if (gameArea.isFull()) {
      return;
    }

    AreaElement[][] currentArea = gameArea.getArea();
    boolean isCorrectMove = false;

    System.out.println("The next player is AI...");

    while (!isCorrectMove) {
      int colsNumber = new Random().nextInt(3);
      int rowsNumber = new Random().nextInt(3);

      if (currentArea[rowsNumber][colsNumber] == AreaElement.UNDEFINED) {
        currentArea[rowsNumber][colsNumber] = AreaElement.O;
        isCorrectMove = true;
      }
    }
  }
}
