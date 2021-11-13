package com.leverx.game.classes;

import com.leverx.game.enums.GameFigure;
import com.leverx.game.enums.PlayerType;
import java.util.Scanner;

/**
 * Defines game player
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see com.leverx.game.classes.impl.AiPlayerImpl
 * @see com.leverx.game.classes.impl.HumanPlayerImpl
 * @since 0.1
 */
public abstract class Player {

  private PlayerType playerType;
  private GameFigure gameFigure;
  private boolean isCurrentPlayer;

  /**
   * Instantiates a new Player.
   */
  protected Player() {
    this.playerType = PlayerType.UNDEFINED_PLAYER;
    this.gameFigure = GameFigure.UNDEFINED;
  }

  /**
   * Play method.
   *
   * @param scanner  the scanner
   * @param gameArea the game area
   */
  public abstract void play(Scanner scanner, GameArea gameArea);

  /**
   * @return true if this is current player
   */
  public boolean isCurrentPlayer() {
    return isCurrentPlayer;
  }

  /**
   * Sets current player.
   *
   * @param currentPlayer the current player
   */
  public void setCurrentPlayer(boolean currentPlayer) {
    isCurrentPlayer = currentPlayer;
  }

  /**
   * Gets player type.
   *
   * @return the player type
   */
  public PlayerType getPlayerType() {
    return playerType;
  }

  /**
   * Sets player type.
   *
   * @param playerType the player type
   */
  public void setPlayerType(PlayerType playerType) {
    this.playerType = playerType;
  }

  /**
   * Gets player figure.
   *
   * @return the type of player's figure
   */
  public GameFigure getPlayerFigure() {
    return gameFigure;
  }

  /**
   * Sets player figure.
   *
   * @param gameFigure the game figure
   */
  public void setPlayerFigure(GameFigure gameFigure) {
    this.gameFigure = gameFigure;
  }

  /**
   * Change to the next player.
   */
  public void nextPlayer() {
    if (isCurrentPlayer) {
      isCurrentPlayer = false;
    } else {
      isCurrentPlayer = true;
    }
  }
}
