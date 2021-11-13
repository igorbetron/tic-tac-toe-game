package com.leverx.game;

import com.leverx.game.classes.GameContext;
import com.leverx.game.classes.impl.TicTacGameContextImpl;

/**
 * Launches the game
 *
 * @author Igor Rabcew
 * @version 0.1
 * @since 0.1
 */
public class GameRunner {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    GameContext gameContext = new TicTacGameContextImpl();
    gameContext.start();
  }
}
