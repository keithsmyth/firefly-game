package com.keithsmyth.firefly.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keithsmyth.firefly.R;
import com.keithsmyth.firefly.model.Action;
import com.keithsmyth.firefly.model.Game;
import com.keithsmyth.firefly.model.Turn;
import com.keithsmyth.firefly.view.adapter.ActionAdapter;

import java.util.List;

/**
 * @author keithsmyth
 */
public class GameFragment extends BaseGameFragment {

  private Game game;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                               Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_game, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    if (game != null) return;
    game = gameController.getCurrentGame();
    Turn turn = game.getCurrentTurn();
    if (turn == null) turn = gameController.addNewTurn(game);
    final TextView titleText = (TextView) view.findViewById(R.id.txt_title);
    titleText.setText(getResources().getText(R.string.turn_text,
        String.valueOf(turn.getTurnNumber())));
    final TextView playerText = (TextView) view.findViewById(R.id.txt_player);
    playerText.setText(turn.getPlayer().getName());
    setupAction(view, R.id.txt_action_1, R.id.lst_actions_1, 1, turn);
    setupAction(view, R.id.txt_action_2, R.id.lst_actions_2, 2, turn);
  }

  private void setupAction(View view, int actionTextId, int actionListId, int idx, Turn turn) {
    final TextView actionText = (TextView) view.findViewById(actionTextId);
    actionText.setText(getResources().getString(R.string.action_text, String.valueOf(idx)));
    final RecyclerView actionList = (RecyclerView) view.findViewById(actionListId);
    actionList.setHasFixedSize(true);
    actionList.setLayoutManager(new LinearLayoutManager(getActivity(),
        LinearLayoutManager.HORIZONTAL, false));
    final List<Action> actions = gameController.getActions();
    actionList.setAdapter(new ActionAdapter(actions));
  }
}
