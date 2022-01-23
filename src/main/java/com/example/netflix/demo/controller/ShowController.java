package com.example.netflix.demo.controller;

import com.example.netflix.demo.models.Show;
import com.example.netflix.demo.services.ListShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ListShow listShow;

    // get shows based on movieType
    @GetMapping("/tvshows")
    public List<Show> getShowsBasedCondition(
            @RequestParam(value="country", required=false) String country,
            @RequestParam(value="count", required=false) String count,
            @RequestParam(value="startDate", required=false) String startDate,
            @RequestParam(value="endDate", required=false) String endDate,
            @RequestParam(value="listed_in", required=false) String listed_in
    ) {
        List<Show> showList;
        showList = this.listShow.getShowsBasedCondition(country, count, startDate, endDate, listed_in);

        return showList;
    }
}
