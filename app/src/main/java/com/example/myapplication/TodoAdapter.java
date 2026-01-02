package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<Todo> todos;
    private Context context;

    public TodoAdapter(List<Todo> todos, Context context) {
        this.todos = todos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.title.setText(todo.getTitle());
        holder.status.setText(todo.isCompleted() ? "Completed" : "Pending");

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("task_title", todo.getTitle());
            intent.putExtra("task_status", todo.isCompleted());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return todos.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            status = itemView.findViewById(R.id.tvStatus);
        }
    }
}