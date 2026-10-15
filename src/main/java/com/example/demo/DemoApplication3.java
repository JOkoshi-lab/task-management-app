package com.example.demo;

import java.util.List;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@SpringBootApplication
@Controller
public class DemoApplication3 {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication3.class, args);
    }

    /** 1件のタスクデータ(ID, タスク内容, 締切, 完了してるか否か) */
    record TaskItem(String id, String task, String deadline, boolean done) {
    }

    /** タスクデータのリスト */
    private final TaskListDao dao;

    DemoApplication3(TaskListDao dao) {
        this.dao = dao;
    }

    @RequestMapping("/tasklist")
    String tasklist(Model model) {List<TaskItem> taskItems = dao.findAll();
        model.addAttribute("taskList", taskItems);
        return "task"; // ビューの名前
    }

    @RequestMapping("/addtask")
    String addItem(@RequestParam("task") String task,
            @RequestParam("deadline") String deadline) {
        // タスクが未入力なら登録しない
        if (task.equals("")) {
            return "redirect:/tasklist";
        }
        String id = UUID.randomUUID().toString().substring(0, 8); // UUIDの先頭8文字
        TaskItem item = new TaskItem(id, task, deadline, false);
        dao.add(item);
        return "redirect:/tasklist";
    }

    @RequestMapping("/change")
    String changeState(@RequestParam("id") String id) {

        dao.change(id);

        return "redirect:/tasklist";
    }
}