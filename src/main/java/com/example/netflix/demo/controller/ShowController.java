package com.example.netflix.demo.controller;

import com.example.netflix.demo.models.Show;
import com.example.netflix.demo.services.ListShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ListShow listShow;

    // get all shows
    @GetMapping("/shows")
    public List<Show> getAllShows() {
        List<Show> showList;
        System.out.println("HELLO");
        showList = this.listShow.getAllShows();

        return showList;
    }
}
