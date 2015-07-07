package com.keithsmyth.firefly.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.keithsmyth.firefly.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseGameFragment {

  private Navigatable navigatable;

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    navigatable = (Navigatable) activity;
  }

  @Override public void onDetach() {
    navigatable = null;
    super.onDetach();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_main, container, false);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    view.findViewById(R.id.btn_new_game).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        startNewGame();
      }
    });
  }

  private void startNewGame() {
    try {
      gameController.startNewGame(gameController.getPlayers());
    } catch (RuntimeException e) {
      Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
      return;
    }
    navigatable.navigate(GameFragment.class, null);
  }
}
