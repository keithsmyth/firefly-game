package com.keithsmyth.firefly;

import android.app.Application;

import com.keithsmyth.firefly.data.DaggerGameComponent;
import com.keithsmyth.firefly.data.GameComponent;
import com.keithsmyth.firefly.data.GameModule;

/**
 * @author keithsmyth
 */
public class App extends Application {

  private static App sInstance;

  private GameComponent component;

  @Override public void onCreate() {
    super.onCreate();
    sInstance = this;
  }

  public static GameComponent getComponent() {
    if (sInstance.component == null) {
      sInstance.component = DaggerGameComponent.builder()
          .gameModule(new GameModule(sInstance.getApplicationContext()))
          .build();
    }
    return sInstance.component;
  }
}
