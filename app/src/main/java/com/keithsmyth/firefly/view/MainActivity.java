package com.keithsmyth.firefly.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.keithsmyth.firefly.App;
import com.keithsmyth.firefly.R;
import com.keithsmyth.firefly.data.GameController;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements Navigatable {

  @Inject GameController gameController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    App.getComponent().inject(this);
    if (savedInstanceState == null) {
      gameController.checkFirstRun();
      getSupportFragmentManager().beginTransaction()
          .replace(R.id.container, new MainFragment())
          .commit();
    }
  }

  @Override public void navigate(Class<?> fragmentClass, Bundle args) {
    String fragmentName = fragmentClass.getName();
    Fragment fragment = Fragment.instantiate(this, fragmentName, args);
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, fragment)
        .addToBackStack(fragmentName)
        .commit();
  }
}
