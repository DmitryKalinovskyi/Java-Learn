package com.education.ztu.spring.controller;

import com.education.ztu.spring.configuration.TodoConfiguration;
import com.education.ztu.spring.entity.TodoItem;
import com.education.ztu.spring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoItemController {
    private final TodoService todoService;

    public TodoItemController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Forms can't use put method so i used Post mapping instead
//    @PutMapping
    @PostMapping("update")
    public String updateTodoItem(@ModelAttribute TodoItem todoItem, Model model){
        todoService.updateTodoItem(todoItem);

        return "redirect:/";
    }

    // Forms can't use delete method so i used Post mapping instead
//    @DeleteMapping
    @PostMapping("delete")
    public String deleteTodoItem(@RequestParam("id") Long id) {
        todoService.deleteTodoItem(id);
        return "redirect:/";
    }
}
