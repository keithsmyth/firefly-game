package com.keithsmyth.firefly.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.keithsmyth.firefly.App;
import com.keithsmyth.firefly.data.GameController;

import javax.inject.Inject;

/**
 * @author keithsmyth
 */
public class BaseGameFragment extends Fragment {

  @Inject GameController gameController;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    App.getComponent().inject(this);
  }
}
