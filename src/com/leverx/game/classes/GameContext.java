package com.leverx.game.classes;

import com.leverx.game.enums.GameState;
import com.leverx.game.interfaces.GameAnalyzer;
import com.leverx.game.interfaces.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Defines game context and game life cycles methods
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see com.leverx.game.classes.impl.TicTacGameContextImpl
 * @since 0.1
 */
public abstract class GameContext {

  private List<Player> players;
  private GameArea gameArea;
  private GameState gameState;
  private GameAnalyzer victoryAnalyzer;
  private View view;

  /**
   * Instantiates a new Game context.
   */
  protected GameContext() {
    players = new ArrayList<>();
    gameArea = new GameArea(3, 3);
    gameState = GameState.IN_PROGRESS;
  }

  /**
   * Start game.
   */
  public abstract void start();

  /**
   * Init game lifecycle method.
   */
  protected abstract void init();

  /**
   * Game step lifecycle method.
   *
   * @param gameInput the game input
   */
  protected abstract void gameStep(Scanner gameInput);

  /**
   * Display game lifecycle method
   */
  protected abstract void display();

  /**
   * Gets players.
   *
   * @return the players
   */
  protected List<Player> getPlayers() {
    return players;
  }

  /**
   * Add new player to players.
   *
   * @param player the new player
   */
  protected void addPlayer(Player player) {
    players.add(player);
  }

  /**
   * Gets game area.
   *
   * @return the game area
   */
  protected GameArea getGameArea() {
    return gameArea;
  }

  /**
   * Gets game state.
   *
   * @return the game state
   */
  public GameState getGameState() {
    return gameState;
  }

  /**
   * Sets game state.
   *
   * @param gameState the new game state.
   */
  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }

  /**
   * Gets game analyzer.
   *
   * @return the game analyzer for define
   */
  protected GameAnalyzer getGameAnalyzer() {
    return victoryAnalyzer;
  }

  /**
   * Sets game analyzer.
   *
   * @param analyzer the game analyzer
   */
  protected void setGameAnalyzer(GameAnalyzer analyzer) {
    victoryAnalyzer = analyzer;
  }

  /**
   * Gets game view.
   *
   * @return the view
   */
  protected View getView() {
    return view;
  }

  /**
   * Sets view.
   *
   * @param view the view
   */
  protected void setView(View view) {
    this.view = view;
  }
}
