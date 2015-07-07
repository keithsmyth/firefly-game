package com.keithsmyth.firefly.model;

import io.realm.RealmObject;

/**
 * @author keithsmyth
 */
public class Player extends RealmObject {

  public static final String NO_PLAYER = "NO-PLAYER";
  public static final String COL_NAME = "name";

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean hasValue() {
    return NO_PLAYER.equals(NO_PLAYER);
  }
}
