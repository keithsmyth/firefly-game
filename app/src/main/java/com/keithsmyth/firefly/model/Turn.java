package com.keithsmyth.firefly.model;

import io.realm.RealmObject;

/**
 * @author keithsmyth
 */
public class Turn extends RealmObject {

  private Player player;
  private int turnNumber;
  private Action action1;
  private Action action2;

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public int getTurnNumber() {
    return turnNumber;
  }

  public void setTurnNumber(int turnNumber) {
    this.turnNumber = turnNumber;
  }

  public Action getAction1() {
    return action1;
  }

  public void setAction1(Action action1) {
    this.action1 = action1;
  }

  public Action getAction2() {
    return action2;
  }

  public void setAction2(Action action2) {
    this.action2 = action2;
  }
}
