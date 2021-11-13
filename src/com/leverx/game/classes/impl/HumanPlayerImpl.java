package com.leverx.game.classes.impl;

import com.leverx.game.classes.GameArea;
import com.leverx.game.classes.Player;
import com.leverx.game.enums.AreaElement;
import com.leverx.game.enums.GameFigure;
import com.leverx.game.enums.PlayerType;
import java.util.Scanner;


/**
 * Defines human player
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see Player
 * @since 0.1
 */
public class HumanPlayerImpl extends Player {

  /**
   * Instantiates a new Human player.
   */
  public HumanPlayerImpl() {
    super();
    this.setPlayerType(PlayerType.HUMAN_PLAYER);
    this.setPlayerFigure(GameFigure.X);
  }

  @Override
  public void play(Scanner scanner, GameArea gameArea) {
    var playerType = getPlayerType();
    var currentPlayersFigure = getPlayerFigure();
    var area = gameArea.getArea();

    System.out.println("Next player is " + playerType);

    move(scanner, currentPlayersFigure, area);
  }

  private void move(Scanner scanner, GameFigure currentPlayersFigure, AreaElement[][] area) {
    String playerTurn;
    boolean isCorrectChoice;

    do {
      System.out.println("Please, input your next game step by sample [rows]x[cols]");
      playerTurn = scanner.nextLine();

      if (playerTurn.matches("^[0-3][x][0-3]$")) {
        String[] values = playerTurn.split("x");

        int rowsNumber = Integer.parseInt(values[0]);
        int colsNumber = Integer.parseInt(values[1]);

        isCorrectChoice = matchesToTheRange(currentPlayersFigure, area, rowsNumber, colsNumber);
      } else {
        isCorrectChoice = false;
      }

      if (!isCorrectChoice) {
        System.out.println("Try again! Invalid input!");
      }

    } while (!isCorrectChoice);
  }

  private boolean matchesToTheRange(GameFigure playersFigure, AreaElement[][] area,
      int rowsNumber, int colsNumber) {

    boolean isCorrectChoice;
    if (rowsNumber < 1 || rowsNumber > 3 || colsNumber < 1 || colsNumber > 3) {
      isCorrectChoice = false;
    } else if (area[rowsNumber - 1][colsNumber - 1] == AreaElement.UNDEFINED) {
      isCorrectChoice = true;
      area[rowsNumber - 1][colsNumber - 1] = playersFigure.getGameSide();
    } else {
      isCorrectChoice = false;
    }
    return isCorrectChoice;
  }
}
