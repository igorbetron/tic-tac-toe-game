package com.leverx.game.interfaces;

import com.leverx.game.classes.GameArea;
import com.leverx.game.enums.GameState;

/**
 * Displays game rules,game state and game area to the view
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see com.leverx.game.interfaces.impl.ConsoleViewImpl
 * @since 0.1
 */
public interface View {

  /**
   * Show result.
   *
   * @param gameArea  the game area
   * @param gameState the game state
   */
  void showResult(GameArea gameArea, GameState gameState);

  /**
   * Show rules.
   *
   * @param rulesText the rules text
   */
  void showRules(String rulesText);
}
