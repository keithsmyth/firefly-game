package com.keithsmyth.firefly.data;

import com.keithsmyth.firefly.model.Action;
import com.keithsmyth.firefly.model.Game;
import com.keithsmyth.firefly.model.Player;
import com.keithsmyth.firefly.model.Turn;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * @author keithsmyth
 */
public class GameController {

  private final Realm realm;

  @Inject public GameController(Realm realm) {
    this.realm = realm;
  }

  public void checkFirstRun() {
    loadDefaultActions();
    loadDefaultPlayers();
  }

  private void loadDefaultActions() {
    if (!realm.allObjects(Action.class).isEmpty()) return;
    realm.beginTransaction();
    for (String name : new String[]{Action.NO_ACTION, "BUY", "FLY", "DEAL", "WORK"}) {
      Action action = realm.createObject(Action.class);
      action.setName(name);
    }
    realm.commitTransaction();
  }

  private void loadDefaultPlayers() {
    if (!realm.allObjects(Player.class).isEmpty()) return;
    realm.beginTransaction();
    for (String name : new String[]{Player.NO_PLAYER, "Burqies", "Fuzzy"}) {
      Player player = realm.createObject(Player.class);
      player.setName(name);
    }
    realm.commitTransaction();
  }

  public Game getCurrentGame() {
    return realm.where(Game.class).equalTo(Game.COL_IS_COMPLETE, false).findFirst();
  }

  public Game startNewGame(Iterable<Player> players) {
    if (getCurrentGame() != null) throw new RuntimeException("Game already in progress");
    realm.beginTransaction();
    Game game = realm.createObject(Game.class);
    game.setDate(new Date());
    for (Player player : players) {
      game.getPlayers().add(player);
    }
    game.setIsComplete(false);
    game.setWinner(getNoPlayer());
    realm.commitTransaction();
    return game;
  }

  private Player getNoPlayer() {
    return realm.where(Player.class).equalTo(Player.COL_NAME, Player.NO_PLAYER).findFirst();
  }

  private Action getNoAction() {
    return realm.where(Action.class).equalTo(Action.COL_NAME, Action.NO_ACTION).findFirst();
  }

  public List<Player> getPlayers() {
    return realm.where(Player.class).notEqualTo(Player.COL_NAME, Player.NO_PLAYER).findAll();
  }

  public Turn addNewTurn(Game game) {
    realm.beginTransaction();
    Turn turn = realm.createObject(Turn.class);
    final Player nextPlayer = game.getNextPlayer();
    turn.setPlayer(nextPlayer);
    final Action noAction = getNoAction();
    turn.setAction1(noAction);
    turn.setAction2(noAction);
    turn.setTurnNumber(game.getTurns().size() + 1);
    game.getTurns().add(turn);
    realm.commitTransaction();
    return turn;
  }

  public List<Action> getActions() {
    return realm.where(Action.class).notEqualTo(Action.COL_NAME, Action.NO_ACTION).findAll();
  }
}
