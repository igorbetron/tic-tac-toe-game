package com.leverx.game.interfaces.impl;

import com.leverx.game.classes.GameArea;
import com.leverx.game.enums.AreaElement;
import com.leverx.game.enums.GameState;
import com.leverx.game.interfaces.GameAnalyzer;

/**
 * Defines game state for concrete game
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see GameAnalyzer
 * @since 0.1
 */
public class TicTacGameAnalyzerImpl implements GameAnalyzer {

  @Override
  public GameState analyze(GameArea gameArea) {
    var currentGameState = defineWinner(gameArea);

    if (gameArea.isFull() && currentGameState == GameState.IN_PROGRESS) {
      return GameState.DRAW;
    } else {
      return currentGameState;
    }
  }

  /**
   * Analyzes cols, rows and diagonal for next game step or display winner
   *
   * @param gameArea current game area with elements
   * @return defined game state
   */
  private GameState defineWinner(GameArea gameArea) {
    AreaElement[][] currentGameArea = gameArea.getArea();

    var horizontalLineResult = analyzeRows(currentGameArea);

    if (horizontalLineResult != GameState.IN_PROGRESS) {
      return horizontalLineResult;
    }

    var verticalLineResult = analyzeCols(currentGameArea);

    if (verticalLineResult != GameState.IN_PROGRESS) {
      return verticalLineResult;
    }

    var leftDiagonalResult = analyzeLeftDiagonal(currentGameArea);

    if (leftDiagonalResult != GameState.IN_PROGRESS) {
      return leftDiagonalResult;
    }

    var rightDiagonalResult = analyzeRightDiagonal(currentGameArea);

    if (rightDiagonalResult != GameState.IN_PROGRESS) {
      return rightDiagonalResult;
    }

    return GameState.IN_PROGRESS;
  }

  /**
   * Analyze only right diagonal of game area
   *
   * @param currentGameArea current game area
   * @return game state IN_PROGRESS,X_WON or Y_WON
   */
  private GameState analyzeRightDiagonal(AreaElement[][] currentGameArea) {
    int ticCounter = 0;
    int tacCounter = 0;
    int areaLength = currentGameArea.length;

    for (int i = 0; i < areaLength; i++) {
      if (currentGameArea[i][areaLength - i - 1] == AreaElement.X) {
        ticCounter++;
      }

      if (currentGameArea[i][areaLength - i - 1] == AreaElement.O) {
        tacCounter++;
      }
    }

    if (ticCounter == currentGameArea.length) {
      return GameState.X_WON;
    } else if (tacCounter == currentGameArea.length) {
      return GameState.Y_WON;
    }

    return GameState.IN_PROGRESS;
  }

  /**
   * Analyze only left diagonal of game area
   *
   * @param currentGameArea current game area
   * @return game state IN_PROGRESS,X_WON or Y_WON
   */
  private GameState analyzeLeftDiagonal(AreaElement[][] currentGameArea) {
    int ticCounter = 0;
    int tacCounter = 0;

    for (int i = 0; i < currentGameArea.length; i++) {
      for (int j = 0; j < currentGameArea[i].length; j++) {
        if (currentGameArea[i][j] == AreaElement.X) {
          ticCounter++;
        }

        if (currentGameArea[i][j] == AreaElement.O) {
          tacCounter++;
        }
      }

      if (ticCounter == currentGameArea.length) {
        return GameState.X_WON;
      } else if (tacCounter == currentGameArea.length) {
        return GameState.Y_WON;
      }

      ticCounter = 0;
      tacCounter = 0;
    }

    return GameState.IN_PROGRESS;
  }

  /**
   * Analyze only cols of game area
   *
   * @param currentGameArea current game area
   * @return game state IN_PROGRESS,X_WON or Y_WON
   */
  private GameState analyzeCols(AreaElement[][] currentGameArea) {
    int ticCounter = 0;
    int tacCounter = 0;

    for (int i = 0; i < currentGameArea.length; i++) {
      for (int j = 0; j < currentGameArea[i].length; j++) {
        if (currentGameArea[j][i] == AreaElement.X) {
          ticCounter++;
        }

        if (currentGameArea[j][i] == AreaElement.O) {
          tacCounter++;
        }
      }

      if (ticCounter == currentGameArea.length) {
        return GameState.X_WON;
      } else if (tacCounter == currentGameArea.length) {
        return GameState.Y_WON;
      }

      ticCounter = 0;
      tacCounter = 0;
    }

    return GameState.IN_PROGRESS;
  }

  /**
   * Analyze only rows of game area
   *
   * @param currentGameArea current game area
   * @return game state IN_PROGRESS, X_WON or Y_WON
   */
  private GameState analyzeRows(AreaElement[][] currentGameArea) {
    int ticCounter = 0;
    int tacCounter = 0;

    for (int i = 0; i < currentGameArea.length; i++) {
      for (int j = 0; j < currentGameArea[i].length; j++) {
        if (currentGameArea[i][j] == AreaElement.X) {
          ticCounter++;
        }

        if (currentGameArea[i][j] == AreaElement.O) {
          tacCounter++;
        }
      }

      if (ticCounter == currentGameArea.length) {
        return GameState.X_WON;
      } else if (tacCounter == currentGameArea.length) {
        return GameState.Y_WON;
      }

      ticCounter = 0;
      tacCounter = 0;
    }

    return GameState.IN_PROGRESS;
  }
}
