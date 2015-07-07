package com.keithsmyth.firefly.data;

import com.keithsmyth.firefly.view.BaseGameFragment;
import com.keithsmyth.firefly.view.MainActivity;

import dagger.Component;

/**
 * @author keithsmyth
 */
@Component(modules = GameModule.class)
public interface GameComponent {

  void inject(MainActivity activity);

  void inject(BaseGameFragment baseGameFragment);
}
