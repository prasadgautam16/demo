package com.example.netflix.demo.controller;

import com.example.netflix.demo.models.Show;
import com.example.netflix.demo.services.ListShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ListShow listShow;

    // get all shows
    @GetMapping("/tvshows")
    public List<Show> getAllShows() {
        List<Show> showList;
        showList = this.listShow.getAllShows();

        return showList;
    }

    // get first n course
    @GetMapping("/tvshows?count={n}")
    public List<Show> getNumberOfShows(
            @RequestParam(value="count", required=true) int n
    ) {
        List<Show> showList;
        showList = this.listShow.getNumberOfShows(n);

        return showList;
    }
}
