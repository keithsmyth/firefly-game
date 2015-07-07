package com.keithsmyth.firefly.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.keithsmyth.firefly.R;
import com.keithsmyth.firefly.model.Action;

import java.util.List;

/**
 * @author keithsmyth
 */
public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ActionViewHolder> {

  private final List<Action> actions;

  public ActionAdapter(List<Action> actions) {
    this.actions = actions;
  }

  @Override public ActionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
    final View view = inflater.inflate(R.layout.item_action, viewGroup, false);
    return new ActionViewHolder(view);
  }

  @Override public void onBindViewHolder(ActionViewHolder actionViewHolder, int i) {
    actionViewHolder.bind(actions.get(i));
  }

  @Override public int getItemCount() {
    return actions.size();
  }

  public static class ActionViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameText;

    public ActionViewHolder(View itemView) {
      super(itemView);
      nameText = (TextView) itemView.findViewById(R.id.txt_name);
    }

    public void bind(Action action) {
      nameText.setText(action.getName());
    }
  }
}
