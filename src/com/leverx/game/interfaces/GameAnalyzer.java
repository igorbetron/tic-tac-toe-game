package com.leverx.game.interfaces;

import com.leverx.game.classes.GameArea;
import com.leverx.game.enums.GameState;

/**
 * Defines game analyzer interface
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see com.leverx.game.classes.impl.TicTacGameContextImpl
 * @since 0.1
 */
public interface GameAnalyzer {

  /**
   * Analyzes game area and then defines game state.
   *
   * @param gameArea  the game area
   * @return defined game state
   */
  GameState analyze(GameArea gameArea);
}
