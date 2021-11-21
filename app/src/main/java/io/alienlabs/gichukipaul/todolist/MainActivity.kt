package io.alienlabs.gichukipaul.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var toDoAdapter: ToDoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rvToDoItems: RecyclerView = findViewById(R.id.rvTodoItems)
        var addButton: Button = findViewById(R.id.btnAddTodo)
        var deleteButton: Button = findViewById(R.id.btnDeleteDoneToDo)
        var Text: EditText = findViewById(R.id.etTodoTitle)

        toDoAdapter = ToDoAdapter(mutableListOf())
        rvToDoItems.adapter = toDoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val title = Text.text.toString()
            if (!title.isEmpty()) {
                val td = ToDo(title, false)
                toDoAdapter.addTodo(td)
            }
            Text.text.clear()
        }

        deleteButton.setOnClickListener {
            toDoAdapter.deleteDoneTodos()
        }

    }
}