package com.keithsmyth.firefly.model;

import android.support.annotation.Nullable;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * @author keithsmyth
 */
public class Game extends RealmObject {

  public static final String COL_IS_COMPLETE = "isComplete";

  private Date date;
  private RealmList<Player> players;
  private RealmList<Turn> turns;
  private boolean isComplete;
  private Player winner;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public RealmList<Player> getPlayers() {
    return players;
  }

  public void setPlayers(RealmList<Player> players) {
    this.players = players;
  }

  public RealmList<Turn> getTurns() {
    return turns;
  }

  public void setTurns(RealmList<Turn> turns) {
    this.turns = turns;
  }

  public boolean isComplete() {
    return isComplete;
  }

  public void setIsComplete(boolean isComplete) {
    this.isComplete = isComplete;
  }

  public Player getWinner() {
    return winner;
  }

  public void setWinner(Player winner) {
    this.winner = winner;
  }

  public @Nullable Turn getCurrentTurn() {
    return turns.last();
  }

  public Player getNextPlayer() {
    if (turns.isEmpty()) return players.first();
    int index = players.indexOf(turns.last().getPlayer());
    if (index == players.size() - 1) {
      index = 0;
    } else {
      index++;
    }
    return players.get(index);
  }
}
