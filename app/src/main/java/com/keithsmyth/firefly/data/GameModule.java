package com.keithsmyth.firefly.data;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * @author keithsmyth
 */
@Module public class GameModule {

  private final Context context;

  public GameModule(Context context) {
    this.context = context;
  }

  @Provides Realm provideRealm() {
    return Realm.getInstance(context);
  }
}
