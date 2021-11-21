package io.alienlabs.gichukipaul.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ToDoAdapter(private var todos: MutableList<ToDo>) : RecyclerView.Adapter<ToDoVH>() {

    fun addTodo(toDo: ToDo) {
        todos.add(toDo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos() {
        todos.forEach { todo ->
            if (todo.isChecked)
                todos.remove(todo)
            //notifyItemRemoved(todos.indexOf(todo)+1)
            notifyDataSetChanged()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoVH {
        return ToDoVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ToDoVH, position: Int) {
        var currentItem = todos[position]
        holder.apply {
            tx.text = currentItem.title
            cb.isChecked = currentItem.isChecked
            holder.cb.setOnCheckedChangeListener { buttonView, isChecked ->
                currentItem.isChecked = !currentItem.isChecked
                notifyDataSetChanged()
            }
        }

    }

    override fun getItemCount(): Int {
        return todos.size
    }

}

class ToDoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tx: TextView
    var cb: CheckBox

    init {
        tx = itemView.findViewById(R.id.tvTodoTitle)
        cb = itemView.findViewById(R.id.cbDone)
    }

}