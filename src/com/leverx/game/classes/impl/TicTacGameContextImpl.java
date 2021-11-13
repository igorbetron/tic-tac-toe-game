package com.leverx.game.classes.impl;

import com.leverx.game.classes.GameContext;
import com.leverx.game.classes.Player;
import com.leverx.game.enums.GameFigure;
import com.leverx.game.enums.GameState;
import com.leverx.game.interfaces.impl.ConsoleViewImpl;
import com.leverx.game.interfaces.impl.TicTacGameAnalyzerImpl;
import java.util.List;
import java.util.Scanner;

/**
 * Defines concrete Tic Tac Toe game with lifecycle methods.
 *
 * @author Igor Rabcew
 * @version 0.1
 * @see GameContext
 * @since 0.1
 */
public class TicTacGameContextImpl extends GameContext {

  /**
   * This field contains game rules
   */
  private static final String RULES =
      "This is a tic-tac-toe game! Follow the instructions on console!";

  /**
   * Instantiates a new Tic Tac Toe game context.
   */
  public TicTacGameContextImpl() {
    super();
  }

  @Override
  public void start() {
    init();

    var view = getView();
    var gameAnalyzer = getGameAnalyzer();
    var gameArea = getGameArea();

    view.showRules(RULES);

    try (var scanner = new Scanner(System.in)) {
      defineSecondPlayer(scanner, getPlayers());

      while (getGameState() == GameState.IN_PROGRESS) {
        gameStep(scanner);

        GameState currentGameState = gameAnalyzer.analyze(gameArea);
        setGameState(currentGameState);

        display();
      }
    }
  }

  @Override
  protected void init() {
    var gameAnalyzer = new TicTacGameAnalyzerImpl();
    var view = new ConsoleViewImpl();

    setGameAnalyzer(gameAnalyzer);
    setView(view);
    initDefaultPlayer();
  }

  @Override
  protected void gameStep(Scanner scanner) {
    var playerList = getPlayers();
    var currentGameArea = getGameArea();

    for (var player : playerList) {
      if (player.isCurrentPlayer()) {
        player.play(scanner, currentGameArea);
      }
    }

    playerList.stream().
        forEachOrdered(Player::nextPlayer);
  }

  @Override
  protected void display() {
    var gameState = getGameState();
    var gameArea = getGameArea();
    var resultView = getView();

    resultView.showResult(gameArea, gameState);
  }

  /**
   * Initializes first game player
   */
  private void initDefaultPlayer() {
    var firstPlayer = new HumanPlayerImpl();

    firstPlayer.setCurrentPlayer(true);
    addPlayer(firstPlayer);
  }

  /**
   * Defines second game player
   */
  private void defineSecondPlayer(Scanner scanner, List<Player> players) {
    String userChoice = "";

    System.out.println("Please, define type for second player! 1 - HUMAN 2 -AI");
    userChoice = scanner.nextLine();

    switch (userChoice.toLowerCase()) {
      case "1" -> {
        var humanPlayer = new HumanPlayerImpl();
        humanPlayer.setPlayerFigure(GameFigure.O);
        players.add(humanPlayer);
      }
      case "2" -> {
        var aIPlayer = new AiPlayerImpl();
        players.add(aIPlayer);
      }
      default -> {
        var humanPlayer = new HumanPlayerImpl();
        humanPlayer.setPlayerFigure(GameFigure.O);
        players.add(humanPlayer);
        System.out.println("Invalid input data! The second player is human!");
      }
    }
  }
}
