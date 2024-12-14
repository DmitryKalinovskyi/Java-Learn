package com.education.ztu.spring.controller;

import com.education.ztu.spring.configuration.TodoConfiguration;
import com.education.ztu.spring.entity.TodoItem;
import com.education.ztu.spring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/todo")
public class TodoItemController {
    private final TodoService todoService;
    private final TodoConfiguration todoConfiguration;

    public TodoItemController(TodoConfiguration todoConfiguration, TodoService todoService) {
        this.todoService = todoService;
        this.todoConfiguration = todoConfiguration;
    }

    @GetMapping("update/{id}")
    public String getUpdatePage(@PathVariable("id") long id, Model model){
        Optional<TodoItem> todoItem = todoService.getTodoItemById(id);

        if(todoItem.isEmpty()) {
            model.addAttribute("message", "Todo item with id " + id + " is not founded.");
            return "404";
        }

        model.addAttribute("title", todoConfiguration.getTitle());
        model.addAttribute("todoItem", todoItem.get());

        return "edit-page.html";
    }

    @PostMapping("update")
    public String updateTodoItem(@ModelAttribute TodoItem todoItem, Model model){
        todoService.updateTodoItem(todoItem);

        return "redirect:/";
    }

    @PostMapping("delete")
    public String deleteTodoItem(@RequestParam("id") long id) {
        todoService.deleteTodoItem(id);
        return "redirect:/";
    }
}
